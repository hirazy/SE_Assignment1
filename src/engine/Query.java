package engine;

import java.util.ArrayList;
import java.util.List;

public class Query {

    String searchQuery;
    List<Word> keyWords;

    public Query(String searchPhrase){
        this.searchQuery = searchPhrase;
        keyWords = new ArrayList<>();

        String[] str = searchPhrase.split("");
        for(int i = 0; i < str.length;i++){

        }
    }

    public List<Word> getKeyWords(){

        return keyWords;
    }

    public List<Match> matchAgainst(Doc d){

        return null;
    }

    public List<Word> getKeywords(){
        return null;
    }


}
