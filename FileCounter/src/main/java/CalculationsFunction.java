import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculationsFunction {

    public int directoryCount;
    public int fileCount;

    public void  countDirectoriesAndFiles(String destinationPath) throws IOException {

        List<String> stringList = Files.readAllLines(Paths.get(destinationPath));
        stringList.stream().forEach(s -> {
            if (s.startsWith(" |------"))
               directoryCount++;
            if (s.endsWith(".txt"))
                fileCount++; });
            System.out.println("Directories in path: " + directoryCount + '\n' + "Files in path: " + fileCount);
    }

    public void  countMiddleFiles() {

        double middleFiles = fileCount / directoryCount;
        System.out.println("Average amount of files: " + middleFiles);
    }

    public void averageLengthOfFileName(String destinationPath) {

        List<String> result = null;

        try (Stream<String> paths = Files.lines(Paths.get(destinationPath))) {

            result = paths.filter(f -> f.endsWith(".txt"))
                    .sorted(Comparator.comparingInt(String::length))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Finding middle length

        double middle;
        if (result.size() % 2 == 1) {
            middle = result.get(result.size() / 2).length();
        } else {
            middle = (result.get(result.size() / 2).length()
                    + result.get(result.size() / 2 - 1).length()) / 2.0;
        }
        System.out.println("Average length of filename: " + middle);
    }
}