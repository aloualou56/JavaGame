package Environment;

import javax.imageio.ImageIO;
import java.io.IOException;

public class env_grass3 extends environment {

    public env_grass3() {
        name = "grass3";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/grass3.png"));
            System.out.println("Grass3 success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
