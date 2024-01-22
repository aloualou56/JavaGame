package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_chest extends object {

    public obj_chest() {
        name = "chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Object_texttures/chest.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
