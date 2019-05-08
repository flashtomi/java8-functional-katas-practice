package katas;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata5Test {

    @Test
    public void testExecute() {

        double expectedResult = 5.0;

        Assert.assertThat(Kata5.execute(), equalTo(expectedResult));
    }
}
