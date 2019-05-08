package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(List::stream)
                .map(movie -> getIdTitleUrlMap(movie))
                .collect(Collectors.toList());
    }

    private static Map getIdTitleUrlMap(Movie movie) {
        return ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "url", getSmallestBoxArtUrl(movie.getBoxarts()));
    }

    private static String getSmallestBoxArtUrl(List<BoxArt> boxArts) {
        return boxArts.stream().reduce(getSmallerBoxArt).map(BoxArt::getUrl).orElse("");
    }

    private static BinaryOperator<BoxArt> getSmallerBoxArt = (t, u) -> getBoxArtArea(t) < getBoxArtArea(u) ? t : u;

    private static Integer getBoxArtArea(BoxArt boxArt) {
        return boxArt.getWidth() * boxArt.getHeight();
    }
}
