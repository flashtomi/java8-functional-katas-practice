package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.InterestingMoment;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(movie -> movie.stream())
                .map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "time", getMidInterestingMoment(movie), "url", getSmallestBoxArtUrl(movie)))
                .collect(Collectors.toList());
    }

    private static Date getMidInterestingMoment(Movie movie) {
        return movie.getInterestingMoments()
                .stream()
                .filter(interestingMoment -> "Middle".equals(interestingMoment.getType()))
                .map(InterestingMoment::getTime).findAny().orElse(null);
    }

    private static String getSmallestBoxArtUrl(Movie movie) {
        return movie.getBoxarts().stream().reduce(getSmallerBoxArt).map(BoxArt::getUrl).orElse("");
    }

    private static BinaryOperator<BoxArt> getSmallerBoxArt = (t, u) -> getBoxArtArea(t) < getBoxArtArea(u) ? t : u;

    private static Integer getBoxArtArea(BoxArt boxArt) {
        return boxArt.getWidth() * boxArt.getHeight();
    }
}
