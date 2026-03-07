package structural.compositePattern;


import java.util.ArrayList;
import java.util.List;

interface FileSystem {
    void printInfo();
    Integer size();
}

class FFile implements FileSystem {

    private String filename;
    private Integer size;

    public FFile(String filename, Integer size){
        this.filename = filename;
        this.size = size;
    }

    @Override
    public void printInfo() {
        System.out.println("File Name: " + filename);
    }

    @Override
    public Integer size() {

        return size;
    }
}


class FFolder implements FileSystem {

    private List<FileSystem> fileSystems = new ArrayList<>();

    private String filename;
    private Integer size;

    public FFolder(String filename, Integer size){
        this.filename = filename;
        this.size = size;
    }

    @Override
    public void printInfo() {
        System.out.println("File Name: " + filename);
    }

    @Override
    public Integer size() {

        return size;
    }


    public void addFile(FileSystem fileSystem){
        fileSystems.add(fileSystem);
    }
}
public class App {
    static void main() {
        FileSystem file1 = new FFile("name.txt",1);
        FileSystem file2 = new FFile("test.txt",1);
        FileSystem folder1 = new FFolder("folder",file1.size() + file2.size());
    }
}
