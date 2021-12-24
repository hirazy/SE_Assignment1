package a1_1901040142;

import java.util.ArrayList;
import java.util.List;

/**
 * @overview
 */
public class Doc {

    String content;
    String title;
    String body;

    /**
     *
     * @param content
     * @implSpec Create Object Doc with content of Doc
     */
    public Doc(String content){
        int indMid = content.indexOf('\n');
        this.content = content;
        this.title = content.substring(0, indMid);
        this.body = content.substring(indMid + 1);
    }

    /**
     *
     * @return List Word of Title
     */
    public List<Word> getTitle(){
        // Split Words by space
        String[] titleWords = title.split(" ");
        List<Word> words = new ArrayList<>();
        for(int i = 0; i < titleWords.length;i++){
            words.add(Word.createWord(titleWords[i]));
        }
        return words;
    }

    /**
     *
     * @return List Word of Body
     */
    public List<Word> getBody(){
        String[] bodyWords = body.split(" ");
        List<Word> words = new ArrayList<>();
        for(int i = 0; i < bodyWords.length;i++){
            words.add(Word.createWord(bodyWords[i]));
        }
        return words;
    }

    /**
     * @param obj
     * @return Equals
     */
    @Override
    public boolean equals(Object obj) {
        Doc temp = (Doc) obj;
        List<Word> tempTitle = temp.getTitle();
        List<Word> tempBody = temp.getBody();

        List<Word> titleWord = getTitle();
        List<Word> bodyWord = getBody();

        if(tempTitle.size() != titleWord.size() || tempBody.size() != bodyWord.size()){
            return false;
        }

        // Compare Title
        for (int i = 0; i < tempTitle.size(); i++) {
            if (!tempTitle.get(i).equals(titleWord.get(i))) {
                return false;
            }
        }

        // Compare Body
        for (int i = 0; i < tempBody.size(); i++) {
            if (!tempBody.get(i).equals(bodyWord.get(i))) {
                return false;
            }
        }

        return true;
    }
}
