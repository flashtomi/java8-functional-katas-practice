package katas;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata1Test {

    @Test
    public void testExecute() {
        List<Map<String,Object>> expectedResult = new ArrayList<>();

        expectedResult.add(ImmutableMap.of("id",70111470,"title", "Die Hard"));
        expectedResult.add(ImmutableMap.of("id",654356453,"title","Bad Boys"));
        expectedResult.add(ImmutableMap.of("id",65432445,"title", "The Chamber"));
        expectedResult.add(ImmutableMap.of("id",675465,"title", "Fracture"));

        Assert.assertThat(Kata1.execute(), equalTo(expectedResult));
    }
}
