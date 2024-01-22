package Environment;

import javax.imageio.ImageIO;
import java.io.IOException;

public class thamnos_tonia extends environment {

    public thamnos_tonia() {
        name = "thamnos_tonia";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/sprites/objects/thamnos_tonia.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
