package Environment;

import javax.imageio.ImageIO;
import java.io.IOException;

public class env_grass4 extends environment {

    public env_grass4() {
        name = "grass4";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/grass4.png"));
            System.out.println("Grass4 success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
