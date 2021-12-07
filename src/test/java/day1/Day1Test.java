package day1;


import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1Test
{
    @Test
    void part1Test1(){
        List<Integer> depths = Day1.parseData("day1/test1.txt");
        int increases = Day1.part1(depths);
        assertEquals(7, increases);
    }

    @Test
    void part1Test2(){
        List<Integer> depths = Day1.parseData("day1/test2.txt");
        int increases = Day1.part1(depths);
        assertEquals(0, increases);
    }

    @Test
    void part1Test3(){
        List<Integer> depths = Day1.parseData("day1/test3.txt");
        int increases = Day1.part1(depths);
        assertEquals(7, increases);
    }

    @Test
    void part2Test1(){
        List<Integer> depths = Day1.parseData("day1/test1.txt");
        int increases = Day1.part2(depths);
        assertEquals(5, increases);
    }

    @Test
    void part2Test2(){
        List<Integer> depths = Day1.parseData("day1/test2.txt");
        int increases = Day1.part2(depths);
        assertEquals(0, increases);
    }

    @Test
    void part2Test3(){
        List<Integer> depths = Day1.parseData("day1/test3.txt");
        int increases = Day1.part2(depths);
        assertEquals(6, increases);
    }
}