import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) throws IOException {

        String directoryPath = args[0];
        String destinationPath = args[1];
        int level = 1;

        try {

            File folder = new File(directoryPath);
            DirectoryTree di = DirectoryTreeHelper.buildTree(folder);

            Path path = Paths.get(destinationPath);

            ArrayList<String> items = new ArrayList<>();
            DirectoryTreeHelper.mapToStringArray(di, items, level);

            Files.write(path, items, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);


            CalculationsFunction calculationsFunction = new CalculationsFunction();
            calculationsFunction.countDirectoriesAndFiles(destinationPath);
            calculationsFunction.countMiddleFiles();
            calculationsFunction.averageLengthOfFileName(destinationPath);

        } catch (NullPointerException e) {
            System.err.println("Directory not existing: " + e.getMessage());
        } catch (FileAlreadyExistsException e) {
            System.err.println("File already exists" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unhandled exception" + e.getMessage());
        }
    }
}


