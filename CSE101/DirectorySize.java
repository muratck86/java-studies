package CSE101;

import java.io.File;

public class DirectorySize {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\kurtm\\Desktop\\Lab01Section01");
        int dirsize = directorySize(file);
        System.out.println("\nTotal Directory size: "+dirsize+"bytes");

    }
    public static int directorySize(File file) throws Exception{
        int size = 0;
        for (File f:file.listFiles()) {
            if (f.isFile()) {
                size += f.length();
                System.out.println("Size: "+f.length()+"\tFile: "+f.getPath());
            }else size += directorySize(f);
        }
        return size;
    }
}
