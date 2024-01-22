package object;
import java.awt.image.BufferedImage;

import Main.MainPannel;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class object {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreadefaultX = 5;   
    public int solidAreadefaultY = 5; 
    
    public void draw(Graphics2D g2, MainPannel gp) {

        int screenX = worldX - gp.player.WorldX + gp.player.screenX;
        int screenY = worldY - gp.player.WorldY + gp.player.screenY;
        if(worldX + gp.tileSize > gp.player.WorldX  - gp.player.screenX && 
           worldX - gp.tileSize < gp.player.WorldX  + gp.player.screenX && 
           worldY + gp.tileSize > gp.player.WorldY  - gp.player.screenY && 
           worldY - gp.tileSize < gp.player.WorldY  + gp.player.screenY ) {

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
               
           }

    }
    
}
