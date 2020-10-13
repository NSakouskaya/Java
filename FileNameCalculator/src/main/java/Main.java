public class Main {

    public static void main(String[] args) {

        Counter counter = new Counter();
        String dirPath  = args[0];

        long[] dirInfo = counter.calculateDirectoryInfo(dirPath);

        System.out.println("Total sub directories: " + dirInfo[0]);
        System.out.println("Total files: " + dirInfo[1]);

        double middleFiles = dirInfo[1] / dirInfo[0];
        System.out.println("Average amount of files: " + middleFiles);

        AverageLength averageLength = new AverageLength(dirPath);
        System.out.println("Average length of filename: " + averageLength.calculateAverageLength());
        System.out.println("Strings with average length:");
        System.out.println(averageLength.getFilesWithLimitLength(20));
    }
}