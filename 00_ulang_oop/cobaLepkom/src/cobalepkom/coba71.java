/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
//package cobalepkom;

/**
 *
 * @author ferdi
 */
public class coba71 extends JFrame{
    public coba71(){
        JPanel p = new JPanel();
        
        p.add(new JButton("One"));
        p.add(new JButton("2"));
        p.add(new JButton("3"));
        p.add(new JButton("4"));
        p.add(new JButton("5"));
        
        this.add(p);
        this.setTitle("Flow");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 75);
        this.setLocation(200, 200);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        coba71 c = new coba71();
        
    }
}
