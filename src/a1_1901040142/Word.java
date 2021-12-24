package a1_1901040142;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @overview store each of strings which are split
 */
public class Word {

    public static Set<String> stopWords;

    String rawText;
    String prefix;
    String suffix;
    String textPart;
    boolean isValidWord;

    public Word() {
    }

    public Word(String rawText, String prefix, String suffix, String textPart, boolean isValidWord) {
        this.rawText = rawText;
        this.prefix = prefix;
        this.suffix = suffix;
        this.textPart = textPart;
        this.isValidWord = isValidWord;
    }

    /**
     * @param rawText
     * @return Word with params
     */
    public static Word createWord(String rawText) {
        /* PATTERN CHECK VALID */
        String PATTERN_WORD = "[('-<>«\",]{0,}[a-zA-Z-]{1,}['-<>».st\")]{0,}";

        String text = "";

        // Identity valid or invalid word
        Pattern pattern = Pattern.compile(PATTERN_WORD);
        Matcher matcher = pattern.matcher(rawText);

        /* Invalid Word */
        if (!matcher.matches() || rawText.matches(".*\\d.*") ||
                (rawText.length() == 1 && (rawText.charAt(0) < 'A' ||
                        (rawText.charAt(0) > 'Z' && rawText.charAt(0) < 'a') || rawText.charAt(0) > 'z'))) {
            return new Word(rawText, "", "", rawText, false);
        }

        String prefix = "";
        int begin = 0;
        int end = rawText.length();

        for (int i = 0; i < rawText.length(); i++) {
            if (rawText.charAt(i) < 'A' || (rawText.charAt(i) > 'Z'
                    && rawText.charAt(i) < 'a') || rawText.charAt(i) > 'z') {
                prefix += rawText.charAt(i);
            } else {
                begin = i;
                break;
            }
        }

        String suffix = "";
        for (int i = rawText.length() - 1; i >= 0; i--) {
            if (rawText.charAt(i) < 'A' || (rawText.charAt(i) > 'Z' && rawText.charAt(i) < 'a') ||
                    rawText.charAt(i) > 'z') {
                suffix = rawText.charAt(i) + suffix;
            } else {
                end = i;
                break;
            }
        }

        /* Exception 's */
        if (rawText.contains("'s")) {
            for (int i = rawText.length() - 2; i >= 1; i--) {
                if (rawText.substring(i, i + 2).equals("'s")) {
                    text = rawText.substring(begin, i);
                    suffix = rawText.substring(i);
                    break;
                }
            }
            return new Word(rawText, prefix, suffix, text, true);
        }

        text = rawText.substring(begin, end + 1);

        return new Word(rawText, prefix, suffix, text, true);
    }

    /**
     * @return Check of key word
     */
    public boolean isKeyword() {
        if (stopWords.contains(textPart.toLowerCase()) || !isValidWord) {
            return false;
        }
        return true;
    }

    /**
     * @return text part of Word
     */
    public String getText() {
        return textPart;
    }

    /**
     * @param fileName
     * @return Check folder is existed
     * @throws FileNotFoundException
     */
    public static boolean loadStopWords(String fileName) throws FileNotFoundException {
        stopWords = new HashSet<>();
        File myObj = new File(".\\" + fileName);
        if (!myObj.exists()) {
            return false;
        }
        Scanner sc = new Scanner(myObj);
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            stopWords.add(data);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return textPart.toLowerCase().equals(word.textPart.toLowerCase());
    }

    /**
     * @return prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @return suffix
     */
    public String getSuffix() {
        return suffix;
    }

    @Override
    public String toString() {
        return rawText;
    }

}