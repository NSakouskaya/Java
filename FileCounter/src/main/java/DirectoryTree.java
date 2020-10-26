import java.util.ArrayList;

public class DirectoryTree {

    private String directoryName;
    private ArrayList<String> fileNames;
    private ArrayList<DirectoryTree> node;

    public DirectoryTree(String directoryName) {
        this.directoryName = directoryName;
        this.fileNames = new ArrayList<>();
        this.node = new ArrayList<>();
    }

    public String getDirectoryName() {
        return this.directoryName;
    }

    public ArrayList<String> getFileNames() {
        return this.fileNames;
    }

    public void addFileName(String fileName) {
        this.fileNames.add(fileName);
    }

    public void addNode(DirectoryTree di) {
        this.node.add(di);
    }

    public ArrayList<DirectoryTree> getNode() {
        return this.node;
    }

}