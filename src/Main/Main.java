package Main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args)  {
        JFrame window = new JFrame();
        
        window.setTitle("GamePrototype");
        
        MainPannel gamepanel = new MainPannel();
        window.add(gamepanel);
        window.pack();

        window.setResizable(false);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamepanel.setupGame();
        gamepanel.startGameThread();
    }
}
