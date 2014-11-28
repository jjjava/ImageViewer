package br.com.schumaker.core;

import br.com.schumaker.io.HsFileFilter;
import br.com.schumaker.model.FileImages;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author Hudson Schumaker
 */
public class CoreFrMain {
    
    private static final CoreFrMain INSTANCE = new CoreFrMain();
    
    private CoreFrMain() {
    }
    
    public static CoreFrMain getInstance() {
        return INSTANCE;
    }
    
    public void openFile() {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        for (int k = 0; k < FileFilterReadPool.getInstance().getInitialSize(); k++) {
            chooser.addChoosableFileFilter(FileFilterReadPool.getInstance().aquire());
        }
        chooser.setAcceptAllFileFilterUsed(false);//support all files
        chooser.setDialogTitle("Abrir arquivo");
        chooser.setApproveButtonText("Abrir");
        int sf = chooser.showOpenDialog(null);
        if (sf == JFileChooser.APPROVE_OPTION) {
            try {
                Image image = ImageIO.read(chooser.getSelectedFile());
                //ScrollPaneDemo scrollPaneDemo = new ScrollPaneDemo(image);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
    
    public void openFolder() {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Abrir pasta");
        chooser.setApproveButtonText("Abrir");
        int sf = chooser.showOpenDialog(null);
        if (sf == JFileChooser.APPROVE_OPTION) {
            System.out.println(chooser.getSelectedFile().getAbsolutePath());
            File dir = new File(chooser.getSelectedFile().getAbsolutePath());
            File[] files = dir.listFiles(new HsFileFilter());
            for (File f : files) {
                FileImages.getInstance().add(f.getAbsolutePath());
            }
        }
    }
    
    public void exit() {
        System.exit(0);
    }
}
