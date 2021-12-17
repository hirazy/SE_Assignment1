package a1_1901040142;

/**
 * @author hirazy2001
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

    public int getFreq() {
        return freq;
    }

    public int getFirstIndex()   {
        return firstIndex;
    }

    public Word getWord() {
        return w;
    }

    @Override
    public int compareTo(Object o) {
        Match temp = (Match) o;
        return firstIndex > temp.firstIndex ? 1 : (firstIndex < temp.firstIndex) ? -1 : 0;
    }
}
