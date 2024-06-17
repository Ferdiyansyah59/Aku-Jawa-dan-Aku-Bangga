/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tumbalscroll;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TumbalScroll {
      private JFrame f; //Main frame
      private JTextArea ta; // Text area
      private JScrollPane sbrText; // Scroll pane for text area
      private JButton btnQuit; // Quit Program
      
      public TumbalScroll () {
          // Create Frame
          f = new JFrame("Swing Demo");
          f.getContentPane().setLayout(new FlowLayout());
          
          // Create Scrolling Text Area in Swing
         ta = new JTextArea("", 5, 50);
         ta.setLineWrap(true);
         sbrText = new JScrollPane(ta);
          sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         
          // Create Quit Button
          btnQuit = new JButton("Quit");
          btnQuit.addActionListener(
              new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                      System.exit(0);         
                }
            }
          );
      }
      
      public void launchFrame(){ // Create Layout
        // Add text area and button to frame
         f.getContentPane().add(sbrText);
         f.getContentPane().add(btnQuit);
          
         // Close when the close button is clicked
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        //Display Frame
          f.pack(); // Adjusts frame to size of components
         f.setVisible(true);
      }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         TumbalScroll gui = new TumbalScroll();
         gui.launchFrame();
    }
    
}
