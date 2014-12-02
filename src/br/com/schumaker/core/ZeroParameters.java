package br.com.schumaker.core;

import br.com.schumaker.gfx.FrMain;
import br.com.schumaker.gfx.FrMain2;

/**
 *
 * @author Hudson Schumaker
 */
public class ZeroParameters implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }

    @Override
    public void executeProgram(String[] params) {
        if (params.length == 0) {
            FrMain2.getInstance().setVisible(true);
        } else {
            nextInChain.executeProgram(params);
        }
    }
}
