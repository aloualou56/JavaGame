package Environment;

import javax.imageio.ImageIO;
import java.io.IOException;

public class env_grass1 extends environment {

    public env_grass1() {
        name = "grass1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/grass1.png"));
            System.out.println("Grass1 success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
