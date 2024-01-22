package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class obj_boots extends object {

    public obj_boots() {
        name = "boots";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Object_texttures/boots.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
