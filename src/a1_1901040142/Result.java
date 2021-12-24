package a1_1901040142;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @overview stores information about a related a document, a list of matches found in that document
 */
public class Result implements Comparable {

    public Doc d;
    public List<Match> matches;

    public int matchCount;
    public double avgFirstIndex;
    public int totalFreq;

    /**
     * @param matches
     */
    public Result(Doc d, List<Match> matches) {
        this.d = d;

        this.matches = matches;
        int n = matches.size();

        this.matchCount = n;
        double sumFreq = 0;
        double sumFirstIndex = 0;

        for (int i = 0; i < n; i++) {
            sumFreq += matches.get(i).freq;
            sumFirstIndex += matches.get(i).firstIndex;
        }

        this.totalFreq = (int) sumFreq;
        this.avgFirstIndex = sumFirstIndex / n;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public int getTotalFrequency() {
        return totalFreq;
    }

    public double getAverageFirstIndex() {
        return avgFirstIndex;
    }

    public int compareTo(Result o) {
        return 0;
    }

    public Doc getDoc() {
        return d;
    }

    /**
     * @return
     */
    public String htmlHighlight() {
        String preTitle = "<u>";
        String sufTitle = "</u>";
        String preBody = "<b>";
        String sufBody = "</b>";

        String title = d.title;
        String[] titleWords = title.split(" ");
        String body = d.body;
        String[] bodyWords = body.split(" ");

        Set<String> keyWord = new HashSet<>();
        for (int i = 0; i < matches.size(); i++) {
            keyWord.add(matches.get(i).getWord().textPart.toLowerCase());
        }

        String html = "";

        /* Title */
        html += "<h3>";
        for (int i = 0; i < titleWords.length; i++) {
            Word word = Word.createWord(titleWords[i]);
            /* word is keyWord */
            if (keyWord.contains(word.textPart.toLowerCase())) {
                String addText = word.prefix + preTitle + word.textPart + sufTitle + word.suffix;
                html += addText;
            } else {
                html += titleWords[i];
            }
            if (i != titleWords.length - 1) {
                html += " ";
            }
        }
        html += "</h3>";

        /* Body */
        html += "<p>";
        for (int i = 0; i < bodyWords.length; i++) {
            Word word = Word.createWord(bodyWords[i]);
            /* word is keyWord */
            if (keyWord.contains(word.textPart.toLowerCase())) {
                String addText = word.prefix + preBody + word.textPart + sufBody + word.suffix;
                html += addText;
            } else {
                html += bodyWords[i];
            }

            if (i != bodyWords.length - 1) {
                html += " ";
            }
        }

        html += "</p>";
        return html;
    }

    @Override
    public int compareTo(Object o) {
        Result res = (Result) o;
        int n = matches.size();

        /**
         * Match Count (Greater)
         */
        if (n > res.matches.size()) {
            return -1;
        } else if (n < res.matches.size()) {
            return 1;
        }

        /**
         * Total Frequency (Greater)
         */
        if (totalFreq > res.totalFreq) {
            return -1;
        } else if (totalFreq < res.totalFreq) {
            return 1;
        }

        /**
         * Average First Index (Lower)
         */
        if (avgFirstIndex < res.avgFirstIndex) {
            return -1;
        } else if (avgFirstIndex > res.avgFirstIndex) {
            return 1;
        }
        return 0;
    }
}
