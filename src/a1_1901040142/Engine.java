package a1_1901040142;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hirazy2001
 */
public class Engine {

    public int loadDocs(String dirName) {
        final File folder = new File(dirName);
        return folder.listFiles().length;
    }

    public Doc[] getDocs() throws FileNotFoundException {
        final File folder = new File(".\\docs" );

        int n = folder.listFiles().length;

        Doc[] docs = new Doc[n];

        for (int i = 0; i < n; i++) {
            File myObj = new File(folder.listFiles()[i].getPath());
            Scanner sc = new Scanner(myObj);
            String s = "";
            int cnt = 0;
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                s += data;
                if(cnt == 0){
                    s += '\n';
                    cnt++;
                }
            }
            docs[i] = new Doc(s);
        }

        return docs;
    }

    /**
     *
     * @param q
     * @return
     * @throws FileNotFoundException
     */
    public List<Result> search(Query q) throws FileNotFoundException {
        List<Result> listSearch = new ArrayList<>();

        Doc[] docs = getDocs();

        for(int i = 0; i < docs.length;i++){
            listSearch.add(new Result(docs[i], q.matchAgainst(docs[i])));
        }

        return listSearch;
    }

    public String htmlResult(List<Result> results) {
        String html = "";
        for(int i = 0; i < results.size();i++){
            html += results.get(i).htmlHighlight();
        }
        return html;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Engine e = new Engine();
        // Doc[] docs = e.getDocs("docs");

        // System.out.println(docs[0].title);
    }
}
