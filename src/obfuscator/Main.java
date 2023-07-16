package obfuscator;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Reading the source code
        Scanner scanner = new Scanner(System.in);
        String filePath = "";

        while (filePath.isEmpty()) {
            System.out.println("Enter the path to the file to open:");
            filePath = scanner.nextLine();

            try (FileReader fr = new FileReader(filePath)) {
                StringBuilder stringBuffer = new StringBuilder();
                int textChar;

                while ((textChar = fr.read()) != -1) {
                    stringBuffer.append((char) textChar);
                }

                // Adding unreachable and dead code
                String newStr = AddUnreachableCode.addUnreachCode(stringBuffer.toString());

                // Clearing the code from comments, tabs, line breaks and extra spaces
                newStr = CodeCleaning.cleanCode(newStr);

                // Changing the names of variables and classes
                newStr = RenameVariables.IdentifierNameReplacing(newStr);

                // Inserting random comments of two types and line breaks
                newStr = AddRandomComments.createComments(newStr);

                writeInFile(newStr);
            } catch (IOException e) {
                System.out.println("File not found");
                filePath = "";
            }
        }

        scanner.close();
    }

    // Writing code to a file
    private static void writeInFile(String str) throws IOException {
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String filePath = desktopPath + "/output.txt";

        FileWriter writer = new FileWriter(filePath, false);
        writer.append(str);
        writer.flush();
        writer.close();

        System.out.println("The obfuscated code has been successfully saved to the desktop.");
    }
}