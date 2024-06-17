/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pert5_npm;

/**
 *
 * @author ferdi
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class Pert5_npm extends Applet implements ActionListener, Runnable{
    int x, y, arahX, arahY;
    Button btnVertical, btnHorizontal;
    
    int pilihan = 1;
    
    @Override
    public void init(){
        btnHorizontal = new Button("Horizontal");
        btnHorizontal.setBounds(300, 40, 80, 30);
        btnHorizontal.addActionListener(this);
        
        btnVertical = new Button("Vertical");
        btnVertical.setBounds(300, 40, 80, 30);
        btnVertical.addActionListener(this);
        
        add(btnHorizontal);
        add(btnVertical);
        
        x = y = 50;
        arahX = arahY = 2;
        
        Thread t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run(){
        while(true){
            try{
                cekBola(pilihan);
                Thread.sleep(5);
                repaint();
            }catch(InterruptedException e){
                System.err.printf("Erro ", e);
            }
        }
    }
    
    private void cekBola(int arah){
        switch(arah){
            case 1:
                if(x > 255 || x < 5){
                    arahX = -arahX;
                }
                x += arahX;
                break;
            case 2:
                if(y > 255 || y < 5){
                    arahY = -arahY;
                }
                y += arahY;
                break;
            case 3: 
                if(x > 255 || y < 5){
                    arahY = -arahX;
                    arahX = -arahY;
                }
                x += arahX;
                y += arahY;
                break;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String actionCommand = e.getActionCommand();
        switch(actionCommand){
            case "Horizontal":
                pilihan = 1;
                break;
            case "Vertical":
                pilihan = 2;
                break;
            default:
                pilihan = 3;
                break;
        }
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.drawRect(5, 5, 255, 355);
        
        g.setColor(Color.red);
        g.fillOval(x, y, 20, 20);
    }
    
}
