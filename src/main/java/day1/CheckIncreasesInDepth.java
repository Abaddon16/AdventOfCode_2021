package day1;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CheckIncreasesInDepth
{
    private static final URL resource = CheckIncreasesInDepth.class.getClassLoader().getResource("day1/Day1Input.txt");

    public static void main(String[] args) throws URISyntaxException, IOException {
        String filePath = new File(resource.toURI()).getAbsolutePath();
        List<Integer> depths = readInDepths(filePath);
        int pt1Increases = part1Counting(depths);
        int pt2Increases = part2Counting(depths);
        System.out.println("Pt1: "+pt1Increases);
        System.out.println("Pt2: "+pt2Increases);
    }

    public static List<Integer> readInDepths(String filePath) throws IOException
    {
        List<Integer> depths = new ArrayList<>();
        Files.lines(Path.of(filePath).toAbsolutePath()).forEach(s->depths.add(Integer.parseInt(s)));
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
