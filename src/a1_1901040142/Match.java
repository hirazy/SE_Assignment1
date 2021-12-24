package a1_1901040142;

/**
 * @overview represents a situation in which a Doc contains a Word
 */
public class Match implements Comparable {

    Word w;
    Doc d;
    int freq;
    int firstIndex;

    public Match(Doc d, Word w, int freq, int firstIndex) {
        this.d = d;
        this.w = w;
        this.freq = freq;
        this.firstIndex = firstIndex;
    }

    /**
     *
     * @return Frequencies of word in doc
     */
    public int getFreq() {
        return freq;
    }

    /**
     *
     * @return first index of word which appear in doc
     */
    public int getFirstIndex()   {
        return firstIndex;
    }

    /**
     *
     * @return word
     */
    public Word getWord() {
        return w;
    }

    @Override
    public int compareTo(Object o) {
        Match temp = (Match) o;
        return firstIndex > temp.firstIndex ? 1 : (firstIndex < temp.firstIndex) ? -1 : 0;
    }
}
