package a1_1901040142;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hirazy2001
 */
public class Doc {

    String content;
    String title;
    String body;

    public Doc(String content){
        int indMid = content.indexOf('\n');
        this.content = content;
        this.title = content.substring(0, indMid);

        System.out.println();
        this.body = content.substring(indMid + 1);
    }

    public List<Word> getTitle(){
        // Split Words by space
        String[] titleWords = title.split("");
        List<Word> words = new ArrayList<>();
        for(int i = 0; i < titleWords.length;i++){
            words.add(Word.createWord(titleWords[i]));
        }
        return words;
    }

    public List<Word> getBody(){
        String[] bodyWords = body.split("");
        List<Word> words = new ArrayList<>();
        for(int i = 0; i < bodyWords.length;i++){
            words.add(Word.createWord(bodyWords[i]));
        }
        return words;
    }

    /**
     * @param obj
     * @return
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

        for(int i = 0; i < tempTitle.size();i++){
            if(!tempTitle.get(i).equals(titleWord.get(i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "Object-oriented design using the UML\n" +
                "An object-oriented system is made up of interacting objects that maintain their own local state and provide operations on that state. The representation of the state is private and cannot be accessed directly from outside the object. Object-oriented design processes involve designing object classes and the relationships between these classes. These classes define the objects in the system and their interactions. When the design is realized as an executing program, the objects are created dynamically from these class definitions. Objects include both data and operations to manipulate that data. They may therefore be understood and modified as stand-alone entities. Changing the implementation of an object or adding services should not affect other system objects. Because objects are associated with things, there is often a clear mapping between real-world entities (such as hardware components) and their controlling objects in the system. This improves the understandability, and hence the maintainability, of the design.";

        Doc doc = new Doc(s);

        System.out.println(doc.title);
        System.out.println(doc.body);
    }
}
