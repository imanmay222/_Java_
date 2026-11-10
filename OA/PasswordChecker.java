
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
     *    ignoring case.
     *
     * Otherwise, the password is STRONG.
     *
     * Example:
     *
     * passwords = {
     *     "123456",
     *     "HELLO",
     *     "hello",
     *     "hello123",
     *     "X7p@9kL2",
     *     "admin123",
     *     "AbC123"
     * };
     *
     * commonWords = {
     *     "hello",
     *     "admin",
     *     "password"
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

    public static String[] classifyPasswords(
            String[] passwords,
            String[] commonWords) {

        // WRITE YOUR CODE HERE
        for(int i=0;i<passwords.length;i++){
            
        }

        return new String[0];
    }
    public static void main(String[] args) {
        String[] passwords = {
            "123456",
            "HELLO",
            "hello",
            "hello123",
            "X7p@9kL2",
            "admin123",
            "AbC123"
        };

        String[] commonWords = {
            "hello",
            "admin",
            "password"
        };

        String[] result = classifyPasswords(passwords, commonWords);

        System.out.println(Arrays.toString(result));
    }
}
