/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.schumaker.io;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author hudson.sales
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
