package obfuscator;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RenameVariables {
    private static int ReplacedNameCounter = 0;
    private static final Map<String, String> idNames = new HashMap<>();
    private static final String[] newIdName = new String[1000000];

    private static final String[] typesOfIdentifier = {"String", "int", "boolean", "double", "float", "Random", "int\\[\\]", "String\\[\\]"};
    private static final int[] LengthsOfTypesNamesOfIdentifiers = {7, 4, 8, 7, 6, 7, 5, 8};

    public static String IdentifierNameReplacing(String code) {
        String result = code;

        for (int i = 0; i < typesOfIdentifier.length; i++) {
            Pattern identifierPattern = Pattern.compile(typesOfIdentifier[i] + "\\s*(\\w{2,})(\\=|;)");
            Matcher identifierMatcher = identifierPattern.matcher(result);
            //Поиск и замена имён переменных
            while (identifierMatcher.find()) {
                String pattern = identifierMatcher.group();
                String oldName = pattern.substring(LengthsOfTypesNamesOfIdentifiers[i], pattern.length() - 1);
                String newName = giveNewIdName(oldName);
                result = replacer(result, oldName, newName);
            }
        }

        return result;
    }

    private static String giveNewIdName(String oldName) {
        nameGenerator();
        if (!idNames.containsKey(oldName)) {
            idNames.put(oldName, newIdName[ReplacedNameCounter]);
        }
        ReplacedNameCounter++;
        return idNames.get(oldName);
    }

    private static String replacer(String code, String oldName, String newName) {
        String result = code;
        result = result.replaceAll(oldName, newName);

        return result;
    }

    //Генератор имён переменных
    static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    static SecureRandom rnd = new SecureRandom();
    private static void nameGenerator() {
        int size = 0;
        for (int i = 0; i < alphabet.length + 1; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                newIdName[size] = randomString(6);
            }
            size++;
        }
    }

    //Генератор рандомной строки
    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(alphabet[rnd.nextInt(alphabet.length)]);
        return sb.toString();
    }
}
