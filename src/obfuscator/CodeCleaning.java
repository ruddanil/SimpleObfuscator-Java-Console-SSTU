package obfuscator;

public class CodeCleaning {
    public static String cleanCode(String code) {
        String cleanCode = code;
        cleanCode = commentsDel(cleanCode);
        cleanCode = enterDel(cleanCode);
        cleanCode = spaceDel(cleanCode);
        return "/*i2EuesSMS4riq55*/" + cleanCode;
    }

    // Deleting Comments
    public static String commentsDel(String clearCode) {
        clearCode = clearCode.replaceAll("\\//.+", "");
        clearCode = clearCode.replaceAll("/\\*(?s).*?\\*/", "");
        return clearCode;
    }

    // Deleting line breaks
    private static String enterDel(String clearCode) {
        return clearCode.replaceAll("\r\n", " ");
    }

    // Removing extra spaces
    private static String spaceDel(String clearCode) {
        String[] replacements = {"\\{", "\\}", "\\(", "\\)", "\\[", "\\]", "\\,", "\\.", "\\|", "\\*", "\\+", "\\&", "\\|\\|", "\\&\\&", "==", "=", "-", "<", ">", "<=", ">=", "!", "/", "%", ";"};
        clearCode = clearCode.replaceAll(" +", " ");
        for (String str : replacements) {
            clearCode = clearCode.replaceAll(("\\s*" + str + "\\s*"), str);
        }
        return clearCode;
    }
}
