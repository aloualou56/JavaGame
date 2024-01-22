package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



// VALE TO MOUSE VLAKA





public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, up_leftPressed, attack;

    



  
   

    
    

    @Override
    public void keyPressed(KeyEvent e) {
        
        
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W: upPressed = true; break;
            case KeyEvent.VK_S: downPressed = true; break;
            case KeyEvent.VK_A: leftPressed = true; break;
            case KeyEvent.VK_D: rightPressed = true; break;

            case KeyEvent.VK_R: attack = true; System.out.println("true"); break;
            case KeyEvent.BUTTON1_DOWN_MASK: attack = true; System.out.println("true"); break;
        }
 
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

       switch(e.getKeyCode()) {
        case KeyEvent.VK_W: upPressed = false; break;
        case KeyEvent.VK_S: downPressed = false; break;
        case KeyEvent.VK_A: leftPressed = false; break;
        case KeyEvent.VK_D: rightPressed = false; break;

        case KeyEvent.VK_R: attack = false; break;
        case KeyEvent.BUTTON1_DOWN_MASK: attack = false; break;
       }
        
        
    }





    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }
    
    
    
}