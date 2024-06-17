import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class Bola1 extends Applet implements Runnable{
    
    int x, arahX;
    public void init(){
        x = 50;
        arahX = 2;
        
        Thread t = new Thread(this);
        t.start();
    }
    
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.drawRect(5, 5, 240, 240);
        g.setColor(Color.red);
        g.fillOval(x, 50, 20, 20);
        
    }
    
    public void cekBola(){
        if(x > 255 || x < 55){
            arahX = -arahX;
        }
        x = x + arahX;
    }
    
    public void run(){
        while(true){
            try{
                cekBola();
                Thread.sleep(5);
                repaint();
            }catch(Exception e){
                System.err.println(e);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bola1 b = new Bola1();
        b.run();
    }
    
}
