package Main;

import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.AWTException;

public class ScreenshotMain {
    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        JFrame window = new JFrame();

        BufferedImage icon = null;
        
        window.setTitle("GamePrototype");
        try {
            icon = ImageIO.read(ScreenshotMain.class.getResourceAsStream("/icon_main/icon.png"));
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
        
        // Wait for game to render
        Thread.sleep(3000);
        
        // Take screenshot
        Robot robot = new Robot();
        Rectangle bounds = window.getBounds();
        BufferedImage screenshot = robot.createScreenCapture(bounds);
        
        // Save screenshot
        File outputfile = new File("/tmp/game_screenshot.png");
        ImageIO.write(screenshot, "png", outputfile);
        System.out.println("Screenshot saved to: " + outputfile.getAbsolutePath());
        
        // Wait a bit more
        Thread.sleep(2000);
        
        System.exit(0);
    }
}
