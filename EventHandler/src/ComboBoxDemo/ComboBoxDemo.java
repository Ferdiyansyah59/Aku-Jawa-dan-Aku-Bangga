/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComboBoxDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.*;
import javax.swing.*;
public class ComboBoxDemo extends JFrame {
    private Label label;
    private Choice co;
    public ComboBoxDemo(){
        super("Ferdiyansyah");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new Label();
        co = new Choice();
        co.add("");
        co.add("Sunday");
        co.add("Monday");
        co.add("Tuesday");
        co.add("Wednesday");
        co.add("Thurstday");
        co.add("Friday");
        co.add("Saturday");
        
        JPanel content = new JPanel();
        content.add(co);
        Container c = this.getContentPane();
        c.add(label, BorderLayout.NORTH);
        c.add(content, BorderLayout.SOUTH);
        
        ShowChoice listener = new ShowChoice(label);
        co.addItemListener(listener);
    }
    public static void main(String[] args) {
        JFrame f = new ComboBoxDemo();
        f.pack();
        f.setVisible(true);
    }
}
