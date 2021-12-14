package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {

    public int loadDocs(String dirName) {
        final File folder = new File(dirName);
        return folder.listFiles().length;
    }

    public Doc[] getDocs(String folderName) throws FileNotFoundException {
        final File folder = new File(".\\" + folderName);

        int n = folder.listFiles().length;

        Doc[] docs = new Doc[n];

        for (int i = 0; i < n; i++) {

            File myObj = new File(folder.listFiles()[i].getPath());
            Scanner sc = new Scanner(myObj);
            String s = "";
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                s += data;
            }
            docs[i] = new Doc(s);
        }

        return docs;
    }

    public List<Result> search(Query q) {
        List<Result> listSearch = new ArrayList<>();

        List<Word> keyWords = q.keyWords;

        for(Word w: keyWords){

        }
        return null;
    }

    public String htmlResult(List<Result> results) {
        return "";
    }
}
