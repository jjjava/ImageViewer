package br.com.schumaker.gfx;

import br.com.schumaker.core.CoreFrMain;
import br.com.schumaker.io.HsFile;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Hudson Schumaker
 */
public class FrMain extends javax.swing.JFrame {

    /**
     * Creates new form FrMain
     */
    private JScrollPane jsp;
    private JLabel label;
    private ImageIcon ii;
    private static final FrMain INSTANCE = new FrMain();

    private FrMain() {
        this.initComponents();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
    }

    public static FrMain getInstance() {
        return INSTANCE;
    }

    public void draw(File file) {
        flush();
        ii = new ImageIcon(HsFile.readFromDisk(file));
        label = new JLabel(ii);
        jsp = new JScrollPane(label);
        jsp.getVerticalScrollBar().setUnitIncrement(16);//velocidade da whell do mouse
        this.getContentPane().add(jsp);
        setSize(getWidth() - 1, getHeight() - 1);
        setSize(getWidth() + 1, getHeight() + 1);
       //repaint();
    }

    private void flush() {
        ii = null;
        label = null;
        jsp = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemOpenFolder = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenuItemOpen.setText("Abrir");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemOpen);

        jMenuItemOpenFolder.setText("Abrir pasta");
        jMenuItemOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenFolderActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemOpenFolder);

        jMenuItemSaveAs.setText("Salvar como");
        jMenu1.add(jMenuItemSaveAs);
        jMenu1.add(jSeparator1);

        jMenuItemExit.setText("Sair");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        CoreFrMain.getInstance().openFile();
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenFolderActionPerformed
        CoreFrMain.getInstance().openFolder();
    }//GEN-LAST:event_jMenuItemOpenFolderActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (jsp != null) {
            jsp.setSize(this.getWidth(), this.getHeight());
        }
    }//GEN-LAST:event_formComponentResized

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemOpenFolder;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
