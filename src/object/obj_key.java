package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_key extends object {

    public obj_key() {
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Object_texttures/key.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
