package katas;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata7Test {

    @Test
    public void testExecute() {

        List<Map<String,Object>> expectedResult = new ArrayList<>();

        expectedResult.add(ImmutableMap.of("id", 70111470, "title", "Die Hard", "url", "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"));
        expectedResult.add(ImmutableMap.of("id",654356453,"title","Bad Boys","url","http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg"));
        expectedResult.add(ImmutableMap.of("id",65432445,"title", "The Chamber","url","http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"));
        expectedResult.add(ImmutableMap.of("id",675465,"title", "Fracture","url","http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"));

        Assert.assertThat(Kata7.execute(), equalTo(expectedResult));
    }
}
