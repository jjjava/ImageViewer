package br.com.schumaker.core;

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
           
        } else {
            nextInChain.executeProgram(params);
        }
    }
}
