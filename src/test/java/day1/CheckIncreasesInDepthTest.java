package day1;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckIncreasesInDepthTest
{
    @Test
    void part1Test1() throws IOException {
        List<Integer> depths = testSetup("day1/test1.txt");
        int increases = CheckIncreasesInDepth.part1Counting(depths);
        assertEquals(7, increases);
    }

    @Test
    void part1Test2() throws IOException {
        List<Integer> depths = testSetup("day1/test2.txt");
        int increases = CheckIncreasesInDepth.part1Counting(depths);
        assertEquals(0, increases);
    }

    @Test
    void part1Test3() throws IOException {
        List<Integer> depths = testSetup("day1/test3.txt");
        int increases = CheckIncreasesInDepth.part1Counting(depths);
        assertEquals(7, increases);
    }

    @Test
    void part2Test1() throws IOException {
        List<Integer> depths = testSetup("day1/test1.txt");
        int increases = CheckIncreasesInDepth.part2Counting(depths);
        assertEquals(5, increases);
    }

    @Test
    void part2Test2() throws IOException {
        List<Integer> depths = testSetup("day1/test2.txt");
        int increases = CheckIncreasesInDepth.part2Counting(depths);
        assertEquals(0, increases);
    }

    @Test
    void part2Test3() throws IOException {
        List<Integer> depths = testSetup("day1/test3.txt");
        int increases = CheckIncreasesInDepth.part2Counting(depths);
        assertEquals(6, increases);
    }


    List<Integer> testSetup(String resourceName) throws IOException {
        String filePath = "";
        URL resource = CheckIncreasesInDepth.class.getClassLoader().getResource(resourceName);
        try{
            if (resource != null){
                filePath = new File(resource.toURI()).getAbsolutePath();
            }
        }
        catch (URISyntaxException e){
            System.out.println("Loading file error");
        }

        return CheckIncreasesInDepth.readInDepths(filePath);
    }
}