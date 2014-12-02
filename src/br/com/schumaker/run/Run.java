package br.com.schumaker.run;

import br.com.schumaker.core.chain.Chain;
import br.com.schumaker.core.chain.HelpParameters;
import br.com.schumaker.core.chain.OneParameters;
import br.com.schumaker.core.chain.ZeroParameters;
import br.com.schumaker.gfx.FrMain;

/**
 *
 * @author Hudson Schumaker
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Chain zeroParam = new ZeroParameters();
                Chain helpParam = new HelpParameters();
                Chain oneParam = new OneParameters();
                zeroParam.setNextChain(helpParam);
                helpParam.setNextChain(oneParam);
                zeroParam.executeProgram(args);
            }
        });
    }
}
