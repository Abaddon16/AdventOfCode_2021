package day2;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args){
        List<String> movements = parseData("day2", "Day2Input.txt");
        int pt1Product = part1(movements);
        int pt2Product = part2(movements);
        System.out.println("Pt1: "+pt1Product);
        System.out.println("Pt2: "+pt2Product);
    }

    public static List<String> parseData(String day, String input) {
        return new ArrayList<>(Utils.readInLines(day, input));
    }

    public static int part1(List<String> movements){
        int forward = 0;
        int depth = 0;

        for(String movement:movements){
            String[] commandCombined = movement.split(" ");
            String command = commandCombined[0];
            int value = Integer.parseInt(commandCombined[1]);
            switch (command){
                case "forward":
                    forward+=value;
                    break;
                case "down":
                    depth+=value;
                    break;
                case "up":
                    depth-=value;
                    break;
            }
        }
        return forward*depth;
    }

    public static int part2(List<String> movements){
        int forward = 0;
        int depth = 0;
        int aim = 0;

        for(String movement:movements){
            String[] commandCombined = movement.split(" ");
            String command = commandCombined[0];
            int value = Integer.parseInt(commandCombined[1]);
            switch (command){
                case "forward":
                    forward+=value;
                    depth+=aim*value;
                    break;
                case "down":
                    aim+=value;
                    break;
                case "up":
                    aim-=value;
                    break;
            }
        }
        return forward*depth;
    }
}
