package day6;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day6{
    
    public static void main(String[] args){
        List<Long> lanternFish = parseData("Day6Input.txt");
        long pt1 = part1(lanternFish, 80);
        long pt2 = part2(lanternFish, 256);
        System.out.println("Pt1: "+pt1);
        System.out.println("Pt2: "+pt2);
    }
    
    public static List<Long> parseData(String input) {
        List<Long> initial =Arrays.stream(Utils.readInLines(input).get(0).split(",")).map(Long::parseLong).sorted().toList();
        List<Long> lanternFish =new ArrayList<>(Collections.nCopies(9, 0L));
        for(long i = 0; i<lanternFish.size(); i++){
            lanternFish.set((int)i, (long)Collections.frequency(initial, i));
        }
        return lanternFish;
    }
    
    public static long part1(List<Long> inputFish, int numDays){
        List<Long> lanternFish = new ArrayList<>(List.copyOf(inputFish));
        for(int i=0; i<numDays; i++){
            passDay(lanternFish);
        }
        return lanternFish.stream().mapToLong(n->n).sum();
    }
    public static long part2(List<Long>  lanternFish, int numDays){
        return part1(lanternFish, numDays);
    }
    
    public static void passDay(List<Long> lanternFish){
        long newFish = lanternFish.get(0);
        lanternFish.set(0, 0L);
        for(int i = 1; i<lanternFish.size(); i++){
            lanternFish.set(i-1, lanternFish.get(i));
            lanternFish.set(i, 0L);
        }
        lanternFish.set(6, newFish+lanternFish.get(6));
        lanternFish.set(8, newFish+lanternFish.get(8));
    }
}
