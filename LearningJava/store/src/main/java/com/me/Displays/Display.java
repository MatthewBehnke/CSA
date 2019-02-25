package com.me.Displays;

import com.me.Main;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Display extends JFrame {

    public Display() {
        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Store");
        setSize(720, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        // if we want to put an icon on the menu item
//        var exitIcon = new ImageIcon("src/resources/exit.png");

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(eMenuItem);
        menubar.add(fileMenu);

        JMenu devTools = new JMenu("Dev Tools");
        devTools.setMnemonic(KeyEvent.VK_C);
        JMenuItem eResetItem = new JMenuItem("Rest");
        eResetItem.setMnemonic(KeyEvent.VK_C);
        eResetItem.setToolTipText("Rest Application");
        eResetItem.addActionListener((event) -> {
            Main.reset();
        });

        devTools.add(eResetItem);
        menubar.add(devTools);

        setJMenuBar(menubar);
    }


}
