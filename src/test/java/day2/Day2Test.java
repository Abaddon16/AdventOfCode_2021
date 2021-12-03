package day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void part1ProductTest1() {
        List<String> movements = Day2.parseData("day2", "exampleInput.txt");
        assertEquals(150, Day2.part1(movements));
    }
    @Test
    void part1ProductTest2() {
        List<String> movements = Day2.parseData("day2", "test1.txt");
        assertEquals(0, Day2.part1(movements));
    }
    @Test
    void part1ProductTest3() {
        List<String> movements = Day2.parseData("day2", "test2.txt");
        assertEquals(9, Day2.part1(movements));
    }
    @Test
    void part1ProductTest4() {
        List<String> movements = Day2.parseData("day2", "test3.txt");
        assertEquals(0, Day2.part1(movements));
    }
    @Test
    void part1ProductTest5() {
        List<String> movements = Day2.parseData("day2", "test4.txt");
        assertEquals(200, Day2.part1(movements));
    }

    @Test
    void part2ProductTest1() {
        List<String> movements = Day2.parseData("day2", "exampleInput.txt");
        assertEquals(900, Day2.part2(movements));
    }
}