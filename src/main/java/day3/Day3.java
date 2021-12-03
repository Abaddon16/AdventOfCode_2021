package day3;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3
{
    public static void main(String[] args){
        List<String> diagnostics = parseData("day3", "Day3Input.txt");
        int pt1Product = part1(diagnostics);
        int pt2Product = part2(diagnostics);
        System.out.println("Pt1: "+pt1Product);
        System.out.println("Pt2: "+pt2Product);
    }

    public static List<String> parseData(String day, String input) {
        return new ArrayList<>(Utils.readInLines(day, input));
    }

    public static int part1(List<String> diagnostics){
        String[] gammaEpsilon = getGammaEpsilon(diagnostics);
        int gammaInteger = Integer.parseInt(gammaEpsilon[0], 2);
        int epsilonInteger = Integer.parseInt(gammaEpsilon[1], 2);
        return gammaInteger*epsilonInteger;
    }

    public static int part2(List<String> diagnostics){
        int bitLength = diagnostics.get(0).length();

        List<String> filteredOxygen = new ArrayList<>(diagnostics);
        List<String> filteredCo2 = new ArrayList<>(diagnostics);

        for(int i = 0; i<bitLength; i++){
            final int j = i;
            if(filteredOxygen.size()>1)
            {
                String oxygenCommonBits = getMostLeastCommonBits(filteredOxygen)[0];
                filteredOxygen = filteredOxygen.stream().filter((s) -> s.charAt(j) == oxygenCommonBits.charAt(j)).collect(Collectors.toList());
            }
            if(filteredCo2.size()>1)
            {
                String co2CommonBits = getMostLeastCommonBits(filteredCo2)[1];
                filteredCo2 = filteredCo2.stream().filter((s) -> s.charAt(j) == co2CommonBits.charAt(j)).collect(Collectors.toList());
            }
        }
        int oxygenInteger = Integer.parseInt(filteredOxygen.get(0), 2);
        int co2Integer = Integer.parseInt(filteredCo2.get(0), 2);
        return oxygenInteger*co2Integer;
    }

    public static String[] getGammaEpsilon(List<String> diagnostics){
        return getMostLeastCommonBits(diagnostics);
    }

    public static String[] getMostLeastCommonBits(List<String> diagnostics){
        int bitsLength = diagnostics.get(0).length();
        int[] oneCounts = new int[bitsLength];
        StringBuilder mostCommon = new StringBuilder();
        StringBuilder leastCommon = new StringBuilder();

        for(String row:diagnostics){
            String[] bits = row.split("");
            for(int i=0; i<oneCounts.length; i++){
                if(bits[i].equals("1")) oneCounts[i]++;
            }
        }
        for(int count:oneCounts){
            if (count == diagnostics.size() - count){
                mostCommon.append("1");// if equal oxygen wants a 1
                leastCommon.append("0");// if equal co2 wants a 0
            }
            else if (count > diagnostics.size() - count)
            {
                mostCommon.append("1");
                leastCommon.append("0");
            } else
            {
                mostCommon.append("0");
                leastCommon.append("1");
            }
        }
        return new String[]{mostCommon.toString(), leastCommon.toString()};
    }
}
