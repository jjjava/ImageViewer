package br.com.schumaker.core;

import br.com.schumaker.gfx.FrMain;
import br.com.schumaker.io.HsFileFilter;
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
                new FrMain(file);
            } else {
                File []files = file.listFiles(new HsFileFilter());
            }
        } else {
            System.out.println("O Programa funciona com 0 e  1 parametro para path.");
        }
    }
}
