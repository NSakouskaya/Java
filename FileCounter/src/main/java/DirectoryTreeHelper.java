import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public final class DirectoryTreeHelper {

    public static void mapToStringArray(DirectoryTree from, ArrayList<String> to, int level) {
        if (level > 0)
            to.add(" |---" + from.getDirectoryName());
        else
            to.add(from.getDirectoryName());

        for (String fn: from.getFileNames()) {
            to.add(" |   " + fn);
        }
        for (DirectoryTree subDirectory: from.getNode()) {
            int nextLevel = level + 1;
            mapToStringArray(subDirectory, to, nextLevel);
        }
    }


    public static DirectoryTree buildTree(File folder) {
        File[] listOfFiles = folder.listFiles();
        DirectoryTree directoryTree = new DirectoryTree(folder.getName());
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                directoryTree.addFileName(listOfFile.getName());
            } else if (listOfFile.isDirectory()) {
                directoryTree.addNode(buildTree(listOfFile));
            }
        }

        return directoryTree;
    }
}