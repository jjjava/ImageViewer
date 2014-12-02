package br.com.schumaker.core.chain;

/**
 *
 * @author Hudson Schumaker
 */
public class HelpParameters implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }

    @Override
    public void executeProgram(String[] params) {
        if (params.length == 1 && (params[0].equalsIgnoreCase("-h") || params[0].equalsIgnoreCase("-help"))) {
            System.out.println("*** O programa aceita 0 e 1 parametros ***");
            System.out.println("-0 parametros: programa executa e abre em branco.");
            System.out.println("-1 parametro: path de uma imagem, programa exibe a imagem.");
            System.out.println("-1 parametros: path de um diretorio, programa exibe as imagem do mesmo.");
        } else {
            nextInChain.executeProgram(params);
        }
    }
}
