package engine;

import java.util.List;

public class Doc {

    String title;
    String body;

    public Doc(String content){
        int indMid = content.indexOf('\n');
        this.title = content.substring(0, indMid);
        this.body = content.substring(indMid + 1);
    }

    public List<Word> getTitle(){
        return null;
    }

    public List<Word> getBody(){
        return null;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Doc temp = (Doc) obj;
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
