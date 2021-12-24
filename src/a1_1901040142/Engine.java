package a1_1901040142;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @overview  represents the search engine and implement Search
 */
public class Engine {

    String dirName;
    Doc[] docs;

    /**
     * @param dirName
     * @return
     * @implSpec Load Docs From File DirName
     */
    public int loadDocs(String dirName) {
        this.dirName = dirName;
        final File folder = new File(dirName);
        try {
            docs = getDocs();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return folder.listFiles().length;
    }

    /**
     * @return
     * @throws FileNotFoundException
     * @implSpec Get Docs From original order
     */
    public Doc[] getDocs() throws FileNotFoundException {

        final File folder = new File(".\\" + dirName);

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
                if (cnt == 0) {
                    s += '\n';
                    cnt++;
                }
            }
            docs[i] = new Doc(s);
        }
        return docs;
    }

    /**
     * @param q
     * @return List Result search by docs in order
     * @throws FileNotFoundException
     */
    public List<Result> search(Query q) throws FileNotFoundException {
        List<Result> listSearch = new ArrayList<>();

        for (int i = 0; i < docs.length; i++) {
            List<Match> matches = q.matchAgainst(docs[i]);
            if(matches.size() > 0){
                listSearch.add(new Result(docs[i], matches));
            }
        }

        // Sort List Search
        Collections.sort(listSearch);
        return listSearch;
    }

    /**
     * @param results
     * @return Result HTML of results
     */
    public String htmlResult(List<Result> results) {
        String html = "";

        for (int i = 0; i < results.size(); i++) {
            html += results.get(i).htmlHighlight();
        }
        return html;
    }
}
