package br.com.schumaker.io;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Hudson Schumaker
 */
public class HsFile {

    public static Image readFromDisk(String path) {
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return image;
    }

    public static Image readFromDisk(File file) {
        Image image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return image;
    }
}
