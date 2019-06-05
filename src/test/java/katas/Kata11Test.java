package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata11Test {

    @Test
    public void testExecute() {

        List<Map> expectedResult = new ArrayList<>();

        expectedResult.add(ImmutableMap.of("name", "New Releases",
                "videos", ImmutableList.of(
                        ImmutableMap.of("id", 65432445, "title", "The Chamber", "time", 32432, "boxart", "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"),
                        ImmutableMap.of("id", 675465, "title", "Fracture", "time", 3534543, "boxart", "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg")
                )));
        expectedResult.add(ImmutableMap.of("name", "Thrillers",
                "videos", ImmutableList.of(
                        ImmutableMap.of("id", 70111470, "title", "Die Hard", "time", 645243, "boxart", "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"),
                        ImmutableMap.of("id", 654356453, "title", "Bad Boys", "time", 984934, "boxart", "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg")
                )));

        Assert.assertThat(Kata10.execute(), equalTo(expectedResult));
    }
}
