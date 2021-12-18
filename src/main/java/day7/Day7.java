package day7;

import utils.Utils;

import java.util.Arrays;
import java.util.List;

public class Day7{
    
    public static void main(String[] args){
        List<Integer> horizontalPositions = parseData("Day7Input.txt");
        int pt1 = part1(horizontalPositions);
        int pt2 = part2(horizontalPositions);
        System.out.println("Pt1: "+pt1);
        System.out.println("Pt2: "+pt2);
    }
    
    public static List<Integer> parseData(String input) {
        return Arrays.stream(Utils.readInLines(input).get(0).split(",")).map(Integer::parseInt).sorted().toList();
    }
    
    public static int part1(List<Integer> horizontalPositions){
        int median = getMedian(horizontalPositions);
    
        int fuelCount = 0;
        for(int i: horizontalPositions) fuelCount+=Math.abs(i-median);
        return fuelCount;
    }
    public static int part2(List<Integer> horizontalPositions){
        int mean = getMean(horizontalPositions);
    
        int fuelCount = 0;
        for(int i: horizontalPositions) fuelCount+=calculateSumUnderN(Math.abs(i-mean));
        return fuelCount;
    }
    
    public static int getMean(List<Integer> positions){
        return positions.stream().reduce(0, Integer::sum)/positions.size();
    }
    public static int getMedian(List<Integer> positions){
        return positions.get(positions.size()/2);
    }
    public static int calculateSumUnderN(int n){
        return (n*(n+1))/2;
    }
}
