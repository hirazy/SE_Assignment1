package a1_1901040142;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hirazy2001
 */
public class Query {

    String searchQuery;
    List<Word> keyWords;

    public Query(String searchPhrase){
        this.searchQuery = searchPhrase;
        keyWords = new ArrayList<>();

        String[] str = searchPhrase.split("");
        for(int i = 0; i < str.length;i++){
            keyWords.add(Word.createWord(str[i]));
        }
    }

    /**
     *
     * @param d Document
     * @return list Match
     */
    public List<Match> matchAgainst(Doc d){
        List<Match> matches = new ArrayList<>();

        String[] content = d.content.split("");

        for(int i = 0; i < keyWords.size();i++){
            Word word = keyWords.get(i);

            int firstIndex = -1;
            int freqWord = 0;

            for(int j = 0; j < content.length;j++){
                // Compare ignoreCase
                if(word.equals(Word.createWord(content[i]))){
                    if(freqWord == 0){
                        firstIndex = i;
                    }
                    freqWord++;
                }
            }

            if(freqWord > 0){ /* remove keywords that not appear in doc*/
                Match match = new Match(d, word, freqWord, firstIndex);
                matches.add(match);
            }
        }

        // Sort matches by comparable
        Collections.sort(matches);
        return matches;
    }

    /**
     * @return a list of the query’s keywords
     */
    public List<Word> getKeywords(){
        return keyWords;
    }
}
