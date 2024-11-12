import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter File:");
        String fileName = scnr.nextLine();
        System.out.print("Enter the string length limit: ");
        int stringLength = scnr.nextInt();
        FileProcessor fileProcessor = new FileProcessor(fileName, stringLength);
        fileProcessor.processFile();
    }
}