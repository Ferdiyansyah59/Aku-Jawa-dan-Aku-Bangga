/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextComponent;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.event.*;
import java.awt.*;
class CreateList implements ActionListener{
    
    private int counter;
    private TextField source;
    private TextArea destination;
    public CreateList(TextField s, TextArea d){
        source = s;
        destination = d;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object component = e.getSource();
        String action = e.getActionCommand();
        if(component instanceof TextField || action.equals("Enter")){
            String text = source.getText();
            counter++;
            destination.append(counter + ". " + text + "\n");
            source.setText("");
        }else if(action.equals("Clear")){
            destination.setText("");
            counter = 0;
        }
    }
    
}
