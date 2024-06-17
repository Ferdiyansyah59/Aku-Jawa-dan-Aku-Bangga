/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuBarDemo;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;
public class MenuBarDemo extends JFrame{
    JMenu fileMenu = new JMenu("File");
    JMenu impMenu = new JMenu("Import");
    JMenu Crl = new JMenu("Color");
    JMenu help = new JMenu("Help");
    JMenu tip = new JMenu("Tip of the day");
    public MenuBarDemo(){
        initUI();
    }
    private void initUI(){
        createMenuBar();
        setTitle("Ferdiyansyah");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        
        JMenuItem mi1 = new JMenuItem("Import newfeed list...");
        JMenuItem mi2 = new JMenuItem("Import bookmarks...");
        JMenuItem mi3 = new JMenuItem("Import mail");
        
        impMenu.add(mi1);
        impMenu.add(mi2);
        impMenu.add(mi3);
        
        JMenuItem neww = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("save");
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setToolTipText("Exit Application");
        
        exit.addActionListener((e) -> System.exit(0));
        
        fileMenu.add(neww);
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.addSeparator();
        fileMenu.add(impMenu);
        fileMenu.add(exit);
        
        JMenuItem about = new JMenuItem("About MenuDemo");
        
        JCheckBox cb = new JCheckBox("Show");
        tip.add(cb);
        
        help.add(about);
        help.add(tip);
        
        menuBar.add(fileMenu);
        menuBar.add(Crl);
        menuBar.add(help);
        
        setJMenuBar(menuBar);
    }
    
      
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
           MenuBarDemo mb = new MenuBarDemo();
           mb.setVisible(true);
        });
    }
}
