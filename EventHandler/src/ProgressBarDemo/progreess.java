/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgressBarDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
public class progreess  {
    public static void main(String[] args) {
        final Timer timer;
        final JProgressBar pb = new JProgressBar();
        final JButton bt = new JButton("Start");
        JFrame f = new JFrame();
        f.setLayout(new FlowLayout());
        f.add(pb);
        f.add(bt);
        
        ActionListener updatePB = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int val = pb.getValue();
                if(val >= 100){
                    bt.setText("End");
                    return;
                }
                pb.setValue(++val);
            }
        };
        timer = new Timer(50, updatePB);
        bt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning()){
                    timer.stop();
                    bt.setText("Start");
                }else if(bt.getText() != "End"){
                    timer.start();
                    bt.setText("Stop");
                }
            }
        });
        
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
    }
}

