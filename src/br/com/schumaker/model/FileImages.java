package br.com.schumaker.model;

import java.util.ArrayList;

/**
 *
 * @author Hudson Schumaker
 */
public class FileImages {

    private static final FileImages INSTANCE = new FileImages();
    private ArrayList<String> path;
    private int index;

    private FileImages() {
        index = 0;
        path = new ArrayList<>();
    }

    public static FileImages getInstance() {
        return INSTANCE;
    }

    public void add(String p) {
        path.add(p);
    }

    public String getPath(int n) {
        return path.get(n);
    }

    public String next() {
        if (index < path.size() - 1) {
            index++;
        }
        return getPath(index);
    }

    public String back() {
        if (index > 0) {
            index--;
        }
        return path.get(index);
    }

    public int getIndex() {
        return index;
    }

    public String end() {
        return getPath(path.size()-1);
    }

    public String start() {
        return getPath(0);
    }
    
    public void clean(){
        index =0;
        path.clear();
    }
}
