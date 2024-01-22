package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_door extends object {
    
    public obj_door() {
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Object_texttures/door.png"));
        
        }catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
