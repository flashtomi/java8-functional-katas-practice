package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.function.DoubleBinaryOperator;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static double execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .mapToDouble(Movie::getRating)
                .reduce(0, getLargerRating);
    }

    private static DoubleBinaryOperator getLargerRating = (rating1, rating2) -> rating1 > rating2 ? rating1 : rating2;
}
