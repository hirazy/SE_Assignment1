package a1_1901040142;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 * @author hirazy2001
 */
public class Test {

    Set<String> st;

    public ArrayList<String> test(String s) {

        ArrayList<String> list = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '`') {

            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input String: ");
            String s = sc.nextLine();
            String[] terms = s.split("[\\s@&.?$'+-]+");
            for (int i = 0; i < terms.length; i++) {
                System.out.print(terms[i] + ' ');
            }
            System.out.println();
        }

    }
}
