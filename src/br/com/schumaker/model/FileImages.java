package br.com.schumaker.model;

import java.util.ArrayList;

/**
 *
 * @author Hudson Schumaker
 */
public class FileImages {

    private static final FileImages INSTANCE = new FileImages();
    private ArrayList<String> path;

    private FileImages() {
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
}
