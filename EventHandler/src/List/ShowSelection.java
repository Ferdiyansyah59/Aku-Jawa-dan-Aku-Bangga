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
import java.awt.*;
import java.awt.event.*;
class ShowSelection implements ActionListener {
    private Label display;
    public ShowSelection(Label d){
        display = d;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(!(source instanceof List)){
            return;
        }
        List list = (List)source;
        String selected = list.getSelectedItem();
        display.setText(selected);
    }
    
}
