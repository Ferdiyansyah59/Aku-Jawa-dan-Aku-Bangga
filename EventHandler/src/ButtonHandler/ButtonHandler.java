/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ButtonHandler;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.*;
import javax.swing.*;
public class ButtonHandler extends JFrame {
    private final JButton red, blue, white;
    
    public ButtonHandler (String title) {
        super(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        red = new JButton("Red");
        blue = new JButton("Blue");
        white = new JButton("White");
        
        JPanel content = new JPanel();
        content.add(red);
        content.add(blue);
        content.add(white);
        
        Container contentPane = this.getContentPane();
        contentPane.add(content, BorderLayout.SOUTH);
        ColorChanger changer = new ColorChanger(this);
        
        red.addActionListener(changer);
        blue.addActionListener(changer);
        white.addActionListener(changer); 
    }
    
    public static void main(String[] args) {
        JFrame f = new ButtonHandler("Ferdiyansyah");
        f.setSize(300, 300);
        f.setVisible(true);
    }
    
}
