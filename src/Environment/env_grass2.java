package Environment;

import javax.imageio.ImageIO;
import java.io.IOException;

public class env_grass2 extends environment {
    
    public env_grass2() {
        name = "grass2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/grass2.png"));
            System.out.println("Grass2 success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
