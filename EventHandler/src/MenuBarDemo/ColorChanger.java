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
import java.awt.*;
import java.awt.event.*;
class ColorChanger implements ActionListener{
    private final Container container;
    public ColorChanger(JFrame c) {
        container = c.getContentPane();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();    
        switch (label) {
            case "Red":
                container.setBackground(Color.RED);
                break;
            case "Blue":
                container.setBackground(Color.BLUE);
                break;
            default:
                container.setBackground(Color.WHITE);
                break;
        }
    }   
}
