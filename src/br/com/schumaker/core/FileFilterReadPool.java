package br.com.schumaker.core;

import br.com.schumaker.core.chain.Pool;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Hudson Schumaker 
 * Singleton Eager
 */
public class FileFilterReadPool implements Pool<FileNameExtensionFilter> {

    private static final FileFilterReadPool INSTANCE = new FileFilterReadPool();
    private final ArrayList<FileNameExtensionFilter> fileFilter;
    private int initialSize;

    private FileFilterReadPool() {
        fileFilter = new ArrayList<>();
        fileFilter.add(new FileNameExtensionFilter("JPG", "jpg"));
        fileFilter.add(new FileNameExtensionFilter("JPEG", "jpeg"));
        fileFilter.add(new FileNameExtensionFilter("PNG", "PNG"));
        fileFilter.add(new FileNameExtensionFilter("BMP", "bmp"));
        initialSize = fileFilter.size();
    }

    public static FileFilterReadPool getInstance() {
        return INSTANCE;
    }

    @Override
    public FileNameExtensionFilter aquire() {
        if (fileFilter.size() > 0) {
            return fileFilter.remove(0);
        } else {
            return null;
        }
    }

    @Override
    public void release(FileNameExtensionFilter w) {
        fileFilter.add(w);
    }

    public int getSizePool() {
        return fileFilter.size();
    }

    public int getInitialSize() {
        return initialSize;
    }
}
