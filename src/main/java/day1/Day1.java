package day1;

import java.util.ArrayList;
import java.util.List;
import utils.Utils;

public class Day1 {

    public static void main(String[] args){
        List<Integer> depths = parseData("day1", "Day1Input.txt");
        int pt1Increases = part1Counting(depths);
        int pt2Increases = part2Counting(depths);
        System.out.println("Pt1: "+pt1Increases);
        System.out.println("Pt2: "+pt2Increases);
    }

    public static List<Integer> parseData(String day, String input) {
        List<Integer> depths = new ArrayList<>();
        Utils.readInLines(day, input).forEach(s->depths.add(Integer.parseInt(s)));
        return depths;
    }

    public static int part1Counting(List<Integer> depths){
        int increases = 0;
        int lastDepth = depths.get(0);
        for(int depth:depths){
            if(depth>lastDepth) increases++;
            lastDepth = depth;
        }
        return increases;
    }

    public static int part2Counting(List<Integer> depths){
        int increases = 0;

        for(int i=0; i+3+1<=depths.size(); i++){
            int sum1 = depths.subList(i, i+3).stream().reduce(0, Integer::sum);
            int sum2 = depths.subList(i+1, i+1+3).stream().reduce(0, Integer::sum);

            if(sum2>sum1) increases++;
        }
        return increases;
    }
}
