/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextComponent;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TextComponent extends JFrame{
    private Button enter, clear;
    private TextField tf;
    private TextArea ta;
    public TextComponent(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enter = new Button("Enter");
        clear = new Button("Clear");
        tf   = new TextField(25);
        ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setEditable(false);
        
        JPanel content = new JPanel();
        content.add(tf);
        content.add(enter);
        content.add(clear);
        
        Container c = this.getContentPane();
        c.add(ta, BorderLayout.NORTH);
        c.add(content, BorderLayout.SOUTH);
        
        CreateList listener = new CreateList(tf, ta);
        tf.addActionListener(listener);
        enter.addActionListener(listener);
        clear.addActionListener(listener);
    }
    
    
    public static void main(String[] args) {
        JFrame f = new TextComponent("Ferdiyansyah");
        f.setSize(350, 300);
        f.setVisible(true);
    }
}
