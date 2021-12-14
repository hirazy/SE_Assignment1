package engine;

import java.util.List;

public class Result implements Comparable{

    public Doc d;
    public List<Match> matches;

    public int matchCount;
    public double avgFirstIndex;
    public int totalFreq;

    public Result(Doc d, List<Match> matches){
        this.d = d;
        this.matches = matches;
        int n = matches.size();

        double sumFreq = 0;
        double sumFirstIndex = 0;

        for(int i = 0; i < n;i++){
            sumFreq += matches.get(i).freq;
            sumFirstIndex += matches.get(i).firstIndex;
        }

        this.totalFreq = (int) sumFreq;
        this.avgFirstIndex = sumFirstIndex / n;
    }

    public List<Match> getMatches(){
        return null;
    }

    public int getTotalFrequency(){
        return 0;
    }

    public double getAverageFirstIndex(){
        double res = 0;
        return 0;
    }

    public String htmlHighLight(){
        return "";
    }

    public int compareTo(Result o){
        return 0;
    }

    public Doc getDoc(){
        return null;
    }

    public String htmlHighlight(){
        String strHighlight = "<u></u>";
        String str = "<b></b>";
        return "";
    }

    @Override
    public int compareTo(Object o) {
        Result res = (Result) o;
        int n = matches.size();

        /**
         * Match Count (Greater)
         */
        if(n > res.matches.size()){
            return 1;
        }
        else if(n < res.matches.size()){
            return -1;
        }

        /**
         * Total Frequency (Greater)
         */
        if(totalFreq > res.totalFreq){
            return 1;
        }
        else if(totalFreq < res.totalFreq){
            return -1;
        }

        /**
         * Average First Index (Lower)
         */
        if(avgFirstIndex < res.avgFirstIndex){
            return 1;
        }
        else if(avgFirstIndex > res.avgFirstIndex){
            return -1;
        }

        return 0;
    }
}
