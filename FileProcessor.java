import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {

    private String fileName;
    private int stringLength;
    private ArrayList<String> stringList;
    private Scanner input;

    public FileProcessor(String fileName, int stringLength) {
        setFileName(fileName);
        setStringLength(stringLength);
        stringList = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public int getStringLength() {
        return stringLength;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setStringLength(int stringLength) {
        if (stringLength < 5) {
            this.stringLength = 5; 
            } 
        else {
            this.stringLength = stringLength;
        }
    }

    public int getArrayListSize() {
        return stringList.size();
    }

    public void processFile() {
        try {
            StringToLongException tooLongException = new StringToLongException("String is too long!");

            input = new Scanner(new File(fileName));

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.length() > stringLength) {
                    throw tooLongException; 
                }
                stringList.add(line);
            }
            input.close();
            
        } 
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } 
        catch (StringToLongException e) {
            System.out.println(e.getMessage());
        }
    }
}
