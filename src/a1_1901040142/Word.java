package a1_1901040142;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hirazy2001
 */
public class Word {

    public static Set<String> stopWords;

    String rawText;
    String prefix;
    String suffix;
    String textPart;
    boolean isKeyword;

    public Word() {
    }

    public Word(String rawText, String prefix, String suffix, String textPart, boolean isKeyword) {
        this.rawText = rawText;
        this.prefix = prefix;
        this.suffix = suffix;
        this.textPart = textPart;
        this.isKeyword = isKeyword;
    }

    public static Word createWord(String rawText) {
        String PATTERN_WORD = "";

        String prefixText = "";
        String suffixText = "";
        String text = "";
        boolean isKeyWord = true;

        // Identity valid or invalid word
        Pattern pattern = Pattern.compile(PATTERN_WORD);
        Matcher matcher = pattern.matcher(rawText);

        /* Invalid Word */
        if (!matcher.matches()) {
            return new Word(rawText, "", "", rawText, false);
        }

        for (int i = 0; i < rawText.length(); i++) {
            if(rawText.charAt(i) == ' '){

            }
        }

        for (int i = rawText.length() - 1; i >= 0; i--) {

        }

        return new Word(rawText, prefixText, suffixText, text, isKeyWord);
    }

    public boolean isKeyword() {
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(rawText);
        return matcher.matches();
    }

    public String getText() {
        return textPart;
    }

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
        return textPart.toLowerCase().equals(word.textPart);
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    @Override
    public String toString() {
        return "Word{" +
                "rawText=" + rawText +
                '}';
    }

}
