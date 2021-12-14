package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Word {

    public static Set<String> stopWords;

    public static Word createWord(String rawText){
        String[] split = rawText.split("");

        return new Word();
    }

    public boolean isKeyword(){

        return true;
    }

    public String getText(){
        return "";
    }

    public static boolean loadStopWords(String fileName) throws FileNotFoundException {
        File myObj = new File(".\\" + fileName);
        Scanner sc = new Scanner(myObj);
        while (sc.hasNextLine()){
            String data = sc.nextLine();
            stopWords.add(data);
            System.out.println(data);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(stopWords, word.stopWords);
    }

    public String getPrefix(){
        return "";
    }

    public String getSuffix(){
        return "";
    }

    @Override
    public String toString() {
        return "Word{" +
                "stopWords=" + stopWords +
                '}';
    }
}
