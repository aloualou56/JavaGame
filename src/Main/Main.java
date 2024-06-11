package Main;

import javax.swing.JFrame;


import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;


import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        JFrame window = new JFrame();

        BufferedImage icon = null;
        
        window.setTitle("GamePrototype");
        try {
            icon = ImageIO.read(Main.class.getResourceAsStream("/icon_main/icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(icon != null) {
            window.setIconImage(icon);
        }
        
        
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
