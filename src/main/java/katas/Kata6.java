package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static Optional<String> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(Movie::getBoxarts)
                .flatMap(Collection::stream)
                .reduce(getBiggerBoxArt)
                .map(BoxArt::getUrl);
    }

    private static BinaryOperator<BoxArt> getBiggerBoxArt = (t, u) -> getBoxArtArea(t) > getBoxArtArea(u) ? t : u;

    private static Integer getBoxArtArea(BoxArt boxArt) {
        return boxArt.getWidth() * boxArt.getHeight();
    }
}
