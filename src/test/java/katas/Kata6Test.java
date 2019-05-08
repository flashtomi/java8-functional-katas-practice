package katas;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata6Test {

    @Test
    public void testExecute() {

        Optional<String> expectedResult = Optional.of("http://cdn-0.nflximg.com/images/2891/Fracture300.jpg");

        Assert.assertThat(Kata6.execute(), equalTo(expectedResult));
    }
}
