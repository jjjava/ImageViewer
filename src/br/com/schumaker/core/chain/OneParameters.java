package br.com.schumaker.core.chain;

import br.com.schumaker.gfx.FrMain2;
import br.com.schumaker.io.HsFileFilter;
import br.com.schumaker.model.FileImages;
import java.io.File;

/**
 *
 * @author Hudson Schumaker
 */
public class OneParameters implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }

    @Override
    public void executeProgram(String[] params) {
        if (params.length == 1) {
            File file = new File(params[0]);
            if (file.isFile()) {
                FrMain2.getInstance().draw(file);
                FrMain2.getInstance().setVisible(true);
            } else {
                File[] files = file.listFiles(new HsFileFilter());
                FileImages fileImages = FileImages.getInstance();
                for (File f : files) {
                    fileImages.add(f.getAbsolutePath());
                }
                FrMain2.getInstance().draw(new File(fileImages.getPath(0)));
            }
        } else {
            System.out.println("O Programa funciona com 0 e  1 parametro para path.");
        }
    }
}
