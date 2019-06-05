package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata10Test {

    @Test
    public void testExecute() {

        List<Map> expectedResult = new ArrayList<>();

        expectedResult.add(ImmutableMap.of("name", "New Releases",
                            "videos", ImmutableList.of(
                                    ImmutableMap.of("id", 65432445, "title", "The Chamber"),
                                    ImmutableMap.of("id", 675465, "title", "Fracture")
                            )));
        expectedResult.add(ImmutableMap.of("name", "Thrillers",
                            "videos", ImmutableList.of(
                                    ImmutableMap.of("id", 70111470, "title", "Die Hard"),
                                    ImmutableMap.of("id", 654356453, "title", "Bad Boys")
                            )));

        Assert.assertThat(Kata10.execute(), equalTo(expectedResult));
    }
}
