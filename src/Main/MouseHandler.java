package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener{
   public boolean Mattack;


    @Override
    public void mouseClicked(MouseEvent arg0) {
        
        
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
        
        



        if(arg0.getButton() == MouseEvent.BUTTON1) {
            Mattack = true;
          //  System.out.println("ATTACK_MOUSE == true");
        }   
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

        if (arg0.getButton() == MouseEvent.BUTTON1) {
            Mattack = false;
           // System.out.println("ATTACK_MOUSE == false");
        } 
    }
    
}
