
import java.util.*;

public class PasswordChecker {

    /*
     * Problem: Password Strength Checker
     *
     * Given a list of passwords and a list of common words,
     * classify each password as "Strong" or "Weak".
     *
     * A password is WEAK if ANY of these conditions hold:
     *
     * 1. Its length is less than 6.
     * 2. It contains only digits (0-9).
     * 3. It contains only uppercase letters (A-Z).
     * 4. It contains only lowercase letters (a-z).
     * 5. It contains any common word as a substring,
     * ignoring case.
     *
     * Otherwise, the password is STRONG.
     *
     * Example:
     *
     * passwords = {
     * "123456",
     * "HELLO",
     * "hello",
     * "hello123",
     * "X7p@9kL2",
     * "admin123",
     * "AbC123"
     * };
     *
     * commonWords = {
     * "hello",
     * "admin",
     * "password"
     * };
     *
     * Expected Output:
     *
     * [Weak, Weak, Weak, Weak, Strong, Weak, Strong]
     *
     * Constraints:
     *
     * 1 <= passwords.length <= 10^4
     * 0 <= commonWords.length <= 10^3
     * 1 <= password.length <= 10^5
     * 1 <= commonWord.length <= 10^3
     *
     * Passwords and common words contain printable ASCII characters.
     */

    public static boolean countLength(String pass) {
        return pass.length() < 6 ? true : false;
    }

    public static boolean checkDigit(String pass) {
        boolean flag = true;
        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if (!Character.isDigit(ch)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean checkUpper(String pass) {
        boolean flag = true;
        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if (!Character.isUpperCase(ch)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean checkSubStr(String pass, String[] words) {
        for (int i = 0; i < words.length; i++) {
            String w = words[i].toLowerCase();
            pass=pass.toLowerCase();
            if (pass.contains(w)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLower(String pass) {
        boolean flag = true;
        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if (!Character.isLowerCase(ch)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static String[] classifyPasswords(String[] passwords, String[] commonWords) {

        // WRITE YOUR CODE HERE
        String res[] = new String[passwords.length];
        for (int i = 0; i < res.length; i++) {
            if (countLength(passwords[i])) {
                res[i] = "Weak";
                continue;
            } else if (checkDigit(passwords[i])) {
                res[i] = "Weak";
                continue;
            } else if (checkUpper(passwords[i])) {
                res[i] = "Weak";
                continue;
            } else if (checkLower(passwords[i])) {
                res[i] = "Weak";
                continue;
            } else if (checkSubStr(passwords[i], commonWords)) {
                res[i] = "Weak";
                continue;
            } else {
                res[i] = "Strong";
            }
        }
        return res;

    }

    public static void main(String[] args) {
        // String[] passwords = {
        // "123456",
        // "HELLO",
        // "hello",
        // "hello123",
        // "X7p@9kL2",
        // "admin123",
        // "AbC123"
        // };

        // String[] commonWords = {
        // "hello",
        // "admin",
        // "password"
        // };

        // String[] result = classifyPasswords(passwords, commonWords);

        // System.out.println(Arrays.toString(result));

        String[][] testCases = {
                { "123456" }, { "HELLO" }, { "hello" }, { "AbC123" },
                { "X7p@9kL2" }, { "12345" }, { "1234567" }, { "ABC123" },
                { "abc123" }, { "@@@@@@" },

                { "A" }, { "Ab" }, { "Ab1" }, { "Ab12" }, { "Ab123" },
                { "Ab1234" }, { "A1@b2C" }, { "123456" }, { "ABCDEF" },
                { "abcdef" },

                { "hello123" }, { "123hello" }, { "12hello34" },
                { "HELLO123" }, { "HeLlO123" }, { "admin123" },
                { "ADMIN123" }, { "myPassword123" }, { "mypassword123" },
                { "pass123word" },

                { "@#$%^&" }, { "123@#$" }, { "ABC@#$" }, { "abc@#$" },
                { "123Ab@" }, { "123456@" }, { "ABCDEF@" }, { "abcdef@" },
                { "       " }, { "Ab1 23" },

                { "Ab1234" }, { "Ab1234" }, { "Ab1234" }, { "Ab1234" },
                { "Ab1234" }, { "Ab1234" }, { "Ab1234" }, { "Ab1234" },
                { "123456" }, { "ABCDEF" }
        };

        String[][] commonWords = {
                { "hello" }, {}, {}, {}, {}, {}, {}, {}, {}, {},
                {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                { "hello", "admin", "password" },
                {}, {}, {}, {}, {}, {}, {}, {}, {}, {},
                {}, { "xyz" }, { "Ab1234" }, { "AB1234" },
                { "ab" }, { "123" }, { "", "hello" },
                { "HELLO", "ADMIN" }, { "123" }, { "abc" }
        };

        String[] expected = {
                "Weak", "Weak", "Weak", "Strong", "Strong",
                "Weak", "Weak", "Strong", "Strong", "Strong",
                "Weak", "Weak", "Weak", "Weak", "Weak",
                "Strong", "Strong", "Weak", "Weak", "Weak",
                "Weak", "Weak", "Weak", "Weak", "Weak",
                "Weak", "Weak", "Weak", "Weak", "Strong",
                "Strong", "Strong", "Strong", "Strong", "Strong",
                "Strong", "Strong", "Strong", "Strong", "Strong",
                "Strong", "Strong", "Weak", "Weak", "Weak",
                "Weak", "Weak", "Strong", "Weak", "Weak"
        };

        int passed = 0;

        for (int i = 0; i < testCases.length; i++) {
            String actual = classifyPasswords(
                    testCases[i],
                    commonWords[i])[0];

            if (actual.equals(expected[i])) {
                passed++;
                System.out.println("Test " + (i + 1) + ": PASS");
            } else {
                System.out.println(
                        "Test " + (i + 1) + ": FAIL | Expected: "
                                + expected[i] + " | Actual: " + actual);
            }
        }

        System.out.println("\nPassed: " + passed + "/" + testCases.length);

    }
}
