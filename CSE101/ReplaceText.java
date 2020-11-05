package CSE101;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class ReplaceText {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter source file name, target filename, source text and target text\n" +
                "in specified pattern:\n" +
                "sourceFile targetFile sourceText targetText\n");
        String source = input.next();
        String target = input.next();
        String search = input.next();
        String newText = input.next();
        input.close();

        if(!(source.toLowerCase().endsWith(".txt")))
            source = source + ".txt";
        if (!(target.toLowerCase().endsWith(".txt")))
            target = target + ".txt";
        File sourceFile = new File(source);
        if (!sourceFile.exists()){
            System.out.println("ERROR There is no such file: "+source+", exiting...");
            System.exit(1);
        }
        File destFile = new File(target);
        if (destFile.exists()){
            System.out.println("ERROR: The file "+target+" is already exists, exiting...");
            System.exit(1);
        }
        System.out.println("Searching in file "+source+" the text '"+search+
                "' to change to '"+newText+"' in a new file, named "+target);
        Scanner fromFile = new Scanner(sourceFile);
        String data = "";
        int counter = 0;
        String read;
        while (fromFile.hasNext()){
            read = fromFile.nextLine();
            read = read.replaceAll(search, newText);
            data += read +"\n";
        }
        try (FileWriter toFile = new FileWriter(destFile);
        ){
            toFile.write(data);
            System.out.println("File created successfully.");
        }



    }
}
