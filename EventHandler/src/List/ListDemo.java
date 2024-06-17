/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*;
import java.awt.*;
public class ListDemo extends JFrame {
    private Label label;
    private List items;
    public ListDemo(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new Label();
        items = new List(5);
        items.add("Sunday");
        items.add("Monday");
        items.add("Tuesday");
        items.add("Wednesday");
        items.add("Thusrsday");
        items.add("Friday");
        items.add("Saturday");
        
        JPanel contain = new JPanel();
        contain.add(items);
        Container c = this.getContentPane();
        c.add(label, BorderLayout.NORTH);
        c.add(contain, BorderLayout.SOUTH);
        
        ShowSelection listener = new ShowSelection(label);
        items.addActionListener(listener);
    }
    
    public static void main(String[] args) {
        JFrame f = new ListDemo("Ferdiyansyah");
        f.pack();
        f.setVisible(true);
    }
}
