package obfuscator;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Считывание исходного кода
        StringBuffer stringBuffer = new StringBuffer();
        boolean correctInput = false;
        while (!correctInput) {
            File file = new File("C:/Users/rudda/IdeaProjects/SSTU-OOP/src/ru/rud/geometry/Point.java");
            try (FileReader fr = new FileReader(file)) {
                int textChar;
                while ((textChar = fr.read()) != -1) {
                    stringBuffer.append((char) textChar);
                    correctInput = true;
                }
            } catch (IOException e) {
                System.out.println("The file was not found");
            }
        }

        // Добавляем недостижимый и мертвый код
        String newStr = AddUnreachableCode.addUnreachCode(stringBuffer.toString());
        // Очищаем код от комментариев, табуляций, переносов строк и лишних пробелов
        newStr = CodeCleaning.cleanCode(newStr);
        // Изменяем имена переменных и классов
        newStr = RenameVariables.IdentifierNameReplacing(newStr);
        // Вставляем рандомные комментарии двух типов и переносы строки
        newStr = AddRandomComments.createComments(newStr);

        writeInFile(newStr);
    }

    // Запись кода в файл
    private static void writeInFile(String str) throws IOException {
        FileWriter writer = new FileWriter("C:/Users/rudda/IdeaProjects/SSTU-OOP/src/ru/rud/geometry/Point.java", false);
        writer.append(str);
        writer.flush();
    }
}