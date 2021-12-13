package day5;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5{
    public static void main(String[] args){
        List<String> ventLines = parseData("Day5Input.txt");
        int pt1 = part1(ventLines);
        int pt2 = part2(ventLines);
        System.out.println("Pt1: "+pt1);
        System.out.println("Pt2: "+pt2);
    }
    
    public static List<String> parseData(String input) {
        return new ArrayList<>(Utils.readInLines(input));
    }
    public static int[] parseLine(String ventLine){
        return Arrays.stream(ventLine.split(",| -> ")).mapToInt(Integer::parseInt).toArray();
    }
    
    public static int[] getMaxXY(List<int[]> coords){
        int maxX = 0;
        int maxY = 0;
        for(int[] coord:coords){
            maxX = Math.max(Math.max(maxX, coord[0]), coord[2]);
            maxY = Math.max(Math.max(maxY, coord[1]), coord[3]);
        }
        return new int[]{maxX, maxY};
    }
    
    public static int part1(List<String> ventLines){
        List<int[]> coords = new ArrayList<>();
        ventLines.forEach(s->coords.add(parseLine(s)));
        int[] maxCoords = getMaxXY(coords);
        int[][] oceanFloor = new int[maxCoords[0]+1][maxCoords[1]+1]; // to account for edge cases, literally
        
        incrementVents(coords, oceanFloor, false);
//        for(int[] x:oceanFloor){
//            for(int y:x){
//                if(y==0) System.out.print(". ");
//                else System.out.print(y+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        
        return countCrosses(oceanFloor);
    }
    public static int part2(List<String> ventLines){
        List<int[]> coords = new ArrayList<>();
        ventLines.forEach(s->coords.add(parseLine(s)));
        int[] maxCoords = getMaxXY(coords);
        int[][] oceanFloor = new int[maxCoords[0]+1][maxCoords[1]+1]; // to account for edge cases, literally
    
        incrementVents(coords, oceanFloor, true);
        return countCrosses(oceanFloor);
    }
    
    public static void incrementVents(List<int[]> coords, int[][] oceanFloor, boolean diagonals){
        for(int[] coord: coords){ // coord = [x,y -> x,y]
            if(coord[0]==coord[2]){ //vertical
                int maxY = Math.max(coord[1], coord[3]);
                int minY = Math.min(coord[1], coord[3]);
            
                for(int i=minY; i<=maxY; i++){
                    oceanFloor[i][coord[0]]++;
                }
            }
            else if(coord[1]==coord[3]){ //horizontal
                int maxX = Math.max(coord[0], coord[2]);
                int minX = Math.min(coord[0], coord[2]);
            
                for(int i=minX; i<=maxX; i++){
                    oceanFloor[coord[1]][i]++;
                }
            }
            else if(diagonals){ // 45* diagonal
                int maxY = Math.max(coord[1], coord[3]);
                int minY = Math.min(coord[1], coord[3]);
                int maxX = Math.max(coord[0], coord[2]);
                int minX = Math.min(coord[0], coord[2]);
                
                if((coord[0]<coord[2] && coord[1]<coord[3]) || (coord[0]>coord[2] && coord[1]>coord[3])){ // top left || bottom right
                    for(int i=0; i<=(maxY-minY); i++){
                        for(int j=0; j<=(maxX-minX); j++){
                            if(i==j) oceanFloor[i+minY][j+minX]++;
                        }
                    }
                }
                else{ // bottom left || top right
                    for(int i=0; i<=(maxY-minY); i++){
                        for(int j=0; j<=(maxX-minX); j++){
                            if(i==(maxX-minX)-j) oceanFloor[maxY-i][maxX-j]++;
                        }
                    }
                }
            }
        }
        System.out.println();
    }
    
    public static int countCrosses(int[][] oceanFloor){
        int crosses=0;
        for(int[] x:oceanFloor){
            for(int y: x){
                if(y>1) crosses++;
            }
        }
        return crosses;
    }
    
    public static void print2dArray(int[][] array){
        System.out.print("  ");
        for(int i=0; i<array.length; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        int i=0;
        for(int[] x:array){
            System.out.print((i++)+" ");
            for(int y:x){
                if(y==0) System.out.print(". ");
                else System.out.print(y+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
