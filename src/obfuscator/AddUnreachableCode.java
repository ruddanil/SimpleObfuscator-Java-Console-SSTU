package obfuscator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static obfuscator.RenameVariables.randomString;

public class AddUnreachableCode {
    public static String addUnreachCode(String code) {
        String result = code;
        Pattern identifierPattern = Pattern.compile("public class(.*?)\\{");
        Matcher identifierMatcher = identifierPattern.matcher(result);
        if (identifierMatcher.find() && !Objects.equals(result.substring(0, 18), "/*i2EuesSMS4riq55*/")) {
            int start = identifierMatcher.start();
            int end = identifierMatcher.end();
            String pattern = result.substring(start, end);
            String newPattern = pattern + getRandomCode();
            result = result.replaceAll(Pattern.quote(pattern), newPattern);
        }
        return result;
    }

    public static String getRandomCode() {
        int number = 1 + (int) (Math.random() * ((3 - 1) + 1));
        switch (number) {
            case 1:
                return "double " + randomString(5) + " (int a){double b = a*2*Math.random();if (b < 10){b += 10;}return b;}";
            case 2:
                return "double " + randomString(5) + " (){double a = 101;double b = a*2/14*3.14*Math.random();if (b < a){b += 10;}return b;}";
            case 3:
                return "String " + randomString(5) + " (){String firstName = \"Daniil\";String secondName = \"Rud\";while(firstName != \"\"){System.out.println(firstName+secondName);}return secondName;}";
            default:
                return "";
        }
    }
}
