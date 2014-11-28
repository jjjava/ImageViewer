package br.com.schumaker.core;

/**
 *
 * @author Hudson Schumaker
 */
public interface Chain {
    void setNextChain(Chain c);
    void executeProgram(String[] params);
}
