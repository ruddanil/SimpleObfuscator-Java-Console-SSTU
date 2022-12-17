package obfuscator;

import java.util.ArrayList;

public class AddRandomComments {

    public static String createComments(String str) {
        StringBuffer sb;
        int add_info = 0;
        boolean isTextFlag = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '"') {
                isTextFlag = true;
            }
            if (!isTextFlag) {
                if (str.charAt(i) == ' ') {
                    add_info++;
                    if (add_info % 3 == 0 && getRandomBoolean()) {
                        sb = new StringBuffer(str);
                        sb.insert(i, " /*" + AddRandomComments.addRandomText(10) + "*/ ");
                        str = sb.toString();
                    }
                    if (add_info % 5 == 0 && getRandomBoolean()) {
                        sb = new StringBuffer(str);
                        sb.insert(i, " \n");
                        str = sb.toString();
                    }
                    if (add_info % 7 == 0 && getRandomBoolean()) {
                        sb = new StringBuffer(str.toString());
                        sb.insert(i, " //" + AddRandomComments.addRandomText(15) + " \n");
                        str = sb.toString();
                    }
                }
            }
            if (i < str.length()-1) {
                if(str.charAt(i+1) == '"' && isTextFlag) isTextFlag = false;
            }
        }
        return str;
    }

    public static boolean getRandomBoolean() {
        return Math.random() > 0.5;
    }

    private static String addRandomText(int length) {
        ArrayList<String> alphabet = new ArrayList<String>();
        StringBuilder result = new StringBuilder();

        for (char c = 'A'; c <= 'z'; c++) {
            String s = "";
            s += c;
            alphabet.add(s);
        }

        for (int c = 0; c < 10; c++) {
            String s = "";
            s += c;
            alphabet.add(s);
        }

        if (length > 0) {
            for (int i = 0; i < length; i++)
                result.append(alphabet.get((int) (Math.random() * alphabet.size())));
        } else {
            result = new StringBuilder("All rights reserved");
        }
        return result.toString();
    }
}
