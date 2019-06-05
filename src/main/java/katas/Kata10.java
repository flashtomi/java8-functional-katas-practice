package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {
    public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        Map<Integer, List<Map>> movieGroups = getGroupByListId(videos);

        return lists.stream().map(list -> ImmutableMap.of("name", list.get("name"), "videos", getVideos(movieGroups.get(list.get("id"))))).collect(Collectors.toList());

//        return lists.stream().map(list -> ImmutableMap.of("name", list.get("name"), "videos", videos.stream()
//                .filter(video -> video.get("listId").toString().equals(list.get("id").toString()))
//                .map(movie -> ImmutableMap.of("id", movie.get("id"), "title", movie.get("title"))).collect(Collectors.toList()))).collect(Collectors.toList());

    }

    private static Map<Integer, List<Map>> getGroupByListId(List<Map> videos) {
        return videos.stream().collect(Collectors.groupingBy(video -> (Integer) video.get("listId")));
    }

    private static List<ImmutableMap<String, Object>> getVideos(List<Map> movies) {
        return movies.stream()
                .map(movie -> ImmutableMap.of("id", movie.get("id"), "title", movie.get("title")))
                .collect(Collectors.toList());
    }
}
