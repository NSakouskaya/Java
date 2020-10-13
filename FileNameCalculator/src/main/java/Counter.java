import java.io.File;

public class Counter {

    public long[] calculateDirectoryInfo(String dirPath) {
        long[] result = new long[] {0, 0};
        int totalFiles = 0;
        int totalDirs = 0;

        File dir = new File(dirPath);

        if (!dir.exists()) {
            throw new IllegalArgumentException("Path does not exist.");
        }

        if (dir.isFile()) {
            throw new IllegalArgumentException("The given path is not a directory. It is a file.");
        }
        File[] subFiles = dir.listFiles();

        if (subFiles != null && subFiles.length > 0) {
            for (File aFile : subFiles) {
                if (aFile.isFile()) {
                    totalFiles++;

                } else {
                    totalDirs++;
                    long[] info = calculateDirectoryInfo(aFile.getAbsolutePath());
                    totalDirs += info[0];
                    totalFiles += info[1];
                }
            }
            result[0] = totalDirs;
            result[1] = totalFiles;
        }
        return result;
    }
}