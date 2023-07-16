# SimpleObfuscator-Java-Console-SSTU
A simple code obfuscator (console): adding random comments and unreachable code, clearing formatting, renaming variables.

![image](https://github.com/ruddanil/SimpleObfuscator-Java-Console-SSTU/assets/25799951/7f7b6347-79b6-4517-9c55-5035e4936044)

The obfuscator is unstable and, in some cases, implemented with workarounds. In rare cases, after obfuscation, the code may stop compiling. 

**DO NOT USE IN REAL PROJECTS.**

Code example before using the obfuscator:

```
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
```

The resulting obfuscated code:
```
/*i2EuesSMS4riq55*/package obfuscator;import java.io.*;import /*Yoj`r`epCK*/  java.util.Scanner;public /*QUCopDP[Nx*/ //yMwB47ljgtwXK_I 
  class Main{String /*lSA]tTqpGj*/  zTdCL(){String 
 /*uZxIMGHOjJ*/  /*f[jsC8vK`5*/  fwLwDA="Daniil";String IhSjms="Rud";while(fwLwDA!=""){System.out.println(fwLwDA+IhSjms);}return IhSjms;}public static void main(String[]args){Scanner scanner=new Scanner(System.in);String HSFRZZ="";while(HSFRZZ.isEmpty()){System.out.println("Enter the path to the file to open:");HSFRZZ=scanner.nextLine();try(FileReader fr=new FileReader(HSFRZZ)){StringBuilder stringBuffer=new StringBuilder();int vCJqPj;while((vCJqPj=fr.read())!=-1){stringBuffer.append((char)vCJqPj);}String CDIaPb=AddUnreachableCode.addUnreachCode(stringBuffer.toString());CDIaPb=CodeCleaning.cleanCode(CDIaPb);CDIaPb=RenameVariables.IdentifierNameReplacing(CDIaPb);CDIaPb=AddRandomComments.createComments(CDIaPb);writeInFile(CDIaPb);}catch(IOException e){System.out.println("File not found");HSFRZZ="";}}scanner.close();}private static void writeInFile(String str)throws IOException{String TNPYSg=System.getProperty("user.home")+"/Desktop";String HSFRZZ=TNPYSg+"/output.txt";FileWriter writer=new FileWriter(HSFRZZ,false);writer.append(str);writer.flush();writer.close();System.out.println("The obfuscated code has been successfully saved to the desktop.");}}
```
