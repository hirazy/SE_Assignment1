package a1_1901040142;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void main(String[] args) throws FileNotFoundException {
        Doc d = new Doc("Object-oriented \"design\": with UML's diagrams\n" +
                "Definition: An object-oriented system's context made up of (interacting) objects.");
//        String t = "\"[hey]\"";
//
//        String s1 = "[hey]";
//
//        String s = "c";
//
//        Word w = Word.createWord(s);
//
//        String PATTERN_WORD = "[('-<>«\"*,]{0,}[a-zA-Z-]{1,}['-<>».st\")]{0,}";
//
//        // Identity valid or invalid word
//        Pattern pattern = Pattern.compile(PATTERN_WORD);
//        Matcher matcher = pattern.matcher(s);
//
//        System.out.println("Valid Word1: " + matcher.matches());
//        System.out.println("Valid Word2: " + w.isValidWord);
//        System.out.println("Prefix: " + w.prefix);
//        System.out.println("Text Part: " + w.textPart);
//        System.out.println("Suffix: " + w.suffix);

        boolean canLoadStopWords = Word.loadStopWords("stopwords.txt");

        Query q = new Query("the <context> of observer: design");

        Engine e = new Engine();
        // docs folder contains: 1.txt, 2.txt... 10.txt
        int loadedDocs = e.loadDocs("docs");
        List<Match> matches = q.matchAgainst(d);

        List<Result> results = e.search(q);

        System.out.println(results.get(0).avgFirstIndex);

//        Scanner sc = new Scanner(new File("testCases.html"));
//
//        String firstResultHTML = sc.nextLine();
//        String secondResultHTML = sc.nextLine();
//        String thirdResultHTML = sc.nextLine();
//        System.out.println(e.htmlResult(results).trim());
//        if (!thirdResultHTML.equals(e.htmlResult(results).trim())) {
//            System.out.println("Result.htmlHighlight(): incorrect output for first result");
//        }

    }
}
