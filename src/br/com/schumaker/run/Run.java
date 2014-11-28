/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.schumaker.run;

import br.com.schumaker.core.Chain;
import br.com.schumaker.core.HelpParameters;
import br.com.schumaker.core.OneParameters;
import br.com.schumaker.core.ZeroParameters;
import br.com.schumaker.gfx.FrMain;

/**
 *
 * @author hudson.sales
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
