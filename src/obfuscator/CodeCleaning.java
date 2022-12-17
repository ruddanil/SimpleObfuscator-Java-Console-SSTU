package obfuscator;

public class CodeCleaning {
    public static String cleanCode(String code) {
        String cleanCode = code;
        cleanCode = commentsDel(cleanCode);
        cleanCode = enterDel(cleanCode);
        cleanCode = spaceDel(cleanCode);
        return "/*i2EuesSMS4riq55*/" + cleanCode;
    }
    //Удаление комментариев
    public static String commentsDel(String clearCode){
        clearCode = clearCode.replaceAll("\\//.+","");
        clearCode = clearCode.replaceAll("/\\*(?s).*?\\*/","");
        return clearCode;
    }
    //Удаление переносов на новую строку
    private static String enterDel(String clearCode){
        return clearCode.replaceAll("\r\n", " ");
    }
    //Удаление лишних пробелов
    private static String spaceDel(String clearCode){
        int counter = 0;
        String[] replacements = {"\\{", "\\}", "\\(", "\\)", "\\[", "\\]", "\\,", "\\.", "\\|","\\*", "\\+", "\\&", "\\|\\|", "\\&\\&", "==", "=", "-", "<", ">", "<=", ">=", "!", "/", "%", ";"};
        clearCode = clearCode.replaceAll(" +", " ");
        for (String str:replacements) {
            clearCode = clearCode.replaceAll(("\\s*" + str + "\\s*"), str);
        }
        return clearCode;
    }
}
