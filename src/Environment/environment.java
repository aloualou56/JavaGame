package Environment;
import java.awt.image.BufferedImage;

import Main.MainPannel;
import java.awt.Graphics2D;

public class environment {

    public BufferedImage image;
    public String name;
    public int worldX, worldY;
    public int dierototilesizemeto;
    

    public void draw(Graphics2D g2, MainPannel gp) {
        int screenX = (int)(worldX - gp.player.WorldX + gp.player.screenX);
        int screenY = (int)(worldY - gp.player.WorldY + gp.player.screenY);

        if(worldX + gp.tileSize > gp.player.WorldX  - gp.player.screenX &&
           worldX - gp.tileSize < gp.player.WorldX  + gp.player.screenX &&
           worldY + gp.tileSize > gp.player.WorldY  - gp.player.screenY && 
           worldY - gp.tileSize < gp.player.WorldY  + gp.player.screenY) {

            g2.drawImage(image, screenX, screenY, gp.tileSize / dierototilesizemeto, gp.tileSize / dierototilesizemeto, null);
        }
    }
    
}
