package utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Utils
{
    public static final ClassLoader resources = Utils.class.getClassLoader();

    public static List<String> readInLines(String day, String input) {
        List<String> strings = new ArrayList<>();
        String filePath = getResourceFilePath(day, input);
        try(Stream<String> s = Files.lines(Path.of(filePath).toAbsolutePath())){
            s.forEach(strings::add);
        }
        catch(IOException e){
            System.out.println("This went poorly");
        }
        return strings;
    }

    public static String getResourceFilePath(String day, String input){
        String filePath = null;
        try{
            URL inputUrl = resources.getResource(day+"/"+input);
            if(inputUrl!=null) {
                filePath = new File(inputUrl.toURI()).getAbsolutePath();
            }
            else{
                throw new URISyntaxException("", "The URL is invalid");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
