package br.com.schumaker.gfx;

import br.com.schumaker.core.CoreFrMain;
import br.com.schumaker.io.HsFile;
import br.com.schumaker.model.FileImages;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Hudson Schumaker
 */
public class FrMain2 extends JFrame {

    private JScrollPane jsp;
    private JLabel label;
    private ImageIcon ii;
    private static final FrMain2 INSTANCE = new FrMain2();

    private FrMain2() {
        super("Viewer");
        this.initComponents();
        // this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }

    public static FrMain2 getInstance() {
        return INSTANCE;
    }

    public void draw(File file) {
        flush();
        ii = new ImageIcon(HsFile.readFromDisk(file));
        label = new JLabel(ii);
        jsp = new JScrollPane(label);
        jsp.getVerticalScrollBar().setUnitIncrement(16);//velocidade da whell do mouse
        this.getContentPane().removeAll();
        this.getContentPane().add(jsp);
        this.reDraw();
        this.repaint();
    }

    private void flush() {
        ii = null;
        label = null;
        jsp = null;
    }

    private void reDraw() {
        this.setSize(getWidth() + 1, getHeight() + 1);
        this.setSize(getWidth() - 1, getHeight() - 1);
    }

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {
        CoreFrMain.getInstance().openFile();
    }

    private void jMenuItemOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {
        CoreFrMain.getInstance().openFolder();
    }

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void formKeyReleased(java.awt.event.KeyEvent evt) {
        if (java.awt.event.KeyEvent.VK_RIGHT == evt.getKeyCode()) {
            FrMain2.getInstance().draw(new File(FileImages.getInstance().next()));
        } else if (java.awt.event.KeyEvent.VK_LEFT == evt.getKeyCode()) {
            FrMain2.getInstance().draw(new File(FileImages.getInstance().back()));
        } else if (java.awt.event.KeyEvent.VK_UP == evt.getKeyCode()) {
            FrMain2.getInstance().draw(new File(FileImages.getInstance().end()));
        } else if (java.awt.event.KeyEvent.VK_DOWN == evt.getKeyCode()) {
            FrMain2.getInstance().draw(new File(FileImages.getInstance().start()));
        }
    }

    private void initComponents() {
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemOpenFolder = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuEditar = new javax.swing.JMenu();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jMenuFile.setText("Arquivo");
        jMenuItemOpen.setText("Abrir");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });

        jMenuFile.add(jMenuItemOpen);
        jMenuItemOpenFolder.setText("Abrir pasta");
        jMenuItemOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenFolderActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpenFolder);
        jMenuItemSaveAs.setText("Salvar como");
        jMenuFile.add(jMenuItemSaveAs);
        jMenuFile.add(jSeparator1);
        jMenuItemExit.setText("Sair");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);
        jMenuBar1.add(jMenuFile);
        jMenuEditar.setText("Editar");
        jMenuBar1.add(jMenuEditar);
        
        jMenuHelp.setText("Ajuda");
        jMenuItem1.setText("Tópicos de Ajuda");
        jMenuHelp.add(jMenuItem1);
        jMenuItem2.setText("Sobre");
        jMenuHelp.add(jMenuItem2);
        jMenuBar1.add(jMenuHelp);
        
        setJMenuBar(jMenuBar1);
    }

    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuEditar;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemOpenFolder;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JPopupMenu.Separator jSeparator1;
}
