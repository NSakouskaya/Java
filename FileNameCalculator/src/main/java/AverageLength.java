import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Comparator.comparingInt;

public class AverageLength {

    private List<String> files;

    public AverageLength(String dirPath) {

        files = getFiles(dirPath);
        Collections.sort(files, comparingInt(String::length));
    }

    private List<String> getFiles(String dirPath) {
        List<String> result = null;

        try (Stream<Path> paths = Files.walk(Paths.get(dirPath))) {

            result = paths.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(x -> x.toString()).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public double calculateAverageLength() {
        double averageValue;
        if (this.files.size() % 2 == 1) {
            averageValue = this.files.get(this.files.size() / 2).length();
        } else {
            averageValue = (this.files.get(this.files.size() / 2).length()
                    + this.files.get(this.files.size() / 2 - 1).length()) / 2.0;
        }
        return averageValue;
    }

    public List<String> getFilesWithLimitLength(int limit) {
        return this.files.stream()
                .filter(s -> s.length() == limit)
                .collect(Collectors.toList());
    }
}