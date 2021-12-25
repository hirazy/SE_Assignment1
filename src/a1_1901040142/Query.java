package a1_1901040142;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @overview represent a user’s search query
 */
public class Query {

    String searchQuery;
    List<Word> keyWords;

    /**
     * @param searchPhrase
     * @implSpec Construct Query with user's search phrase
     */
    public Query(String searchPhrase){
        this.searchQuery = searchPhrase;
        keyWords = new ArrayList<>();

        String[] str = searchPhrase.split(" ");
        for(int i = 0; i < str.length;i++){
            if(Word.createWord(str[i]).isKeyword()){
                keyWords.add(Word.createWord(str[i]));
            }
        }
    }

    /**
     *
     * @param d Document
     * @return List Match of Query with Doc d
     */
    public List<Match> matchAgainst(Doc d){
        List<Match> matches = new ArrayList<>();

        // Split the space
        String[] titles = d.title.split(" ");
        String[] bodies = d.body.split(" ");

        for(int i = 0; i < keyWords.size();i++){
            Word word = keyWords.get(i);

            int firstIndex = -1;
            int freqWord = 0;

            // Compare Title
            for(int j = 0; j < titles.length;j++){
                // Compare Word
                if(word.equals(Word.createWord(titles[j]))){
                    if(freqWord == 0){
                        firstIndex = j;
                    }
                    freqWord++;
                }
            }

            // Compare Body
            for(int j = 0; j < bodies.length;j++){
                // Compare Word
                if(word.equals(Word.createWord(bodies[j]))){
                    if(freqWord == 0){
                        firstIndex = j + titles.length;
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
