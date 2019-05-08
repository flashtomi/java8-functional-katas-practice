package katas;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata2Test {

    @Test
    public void testExecute() {
        List<Integer> expectedResult = ImmutableList.of(654356453,675465);

        Assert.assertThat(Kata2.execute(), equalTo(expectedResult));
    }
}
