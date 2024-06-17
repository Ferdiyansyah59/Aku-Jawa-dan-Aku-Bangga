/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newButtonHandler;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class newButtonHandler extends JFrame{
    JButton bt;
    Container c = getContentPane();
    public newButtonHandler(){
        super("Ferdiyansyah");
        
        c.setLayout(new BorderLayout());
        
        Panel p = new Panel();
        p.setBackground(Color.WHITE);
        c.add(p, BorderLayout.CENTER);
        Icon ic = new ImageIcon("C:\\Users\\ferdiyansyah\\Downloads\\IKONS\\PNG\\32\\drop.png");
        bt = new JButton("Elemen Air",ic);
        c.add(bt, BorderLayout.PAGE_END);
       
    }
    class Panel extends JPanel implements MouseListener {
        public Panel(){
            addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           this.setBackground(Color.BLUE);              
        }

        @Override
        public void mouseExited(MouseEvent e) {
           this.setBackground(Color.WHITE);

          
        }
    }
    
    public static void main(String[] args) {
        newButtonHandler bh = new newButtonHandler();
        bh.setSize(500, 500);
        bh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bh.setVisible(true);
    }
}
