package Entity;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Entity {

    public double WorldX, WorldY;
    public double speed;

    public BufferedImage standing1, standing2, standing3,standing4, standing5, standing6, up1, up2, up3, up4, up5, up6, down1, down2, down3, down4, down5, down6, left1, left2, left3, left4, left5, left6, right1, right2, right3, right4, right5, right6, fight1, fight2, fight3, fight4;
    public String direction;


    public int spriteCounter = 0;
    public int spriteCounter_for_idle = 0;
    public int spriteCounter_for_attack = 0;

    public int spriteNum = 1;
    public int spriteNum_for_standing_animation = 1;
    public int spriteNum_for_attack = 1;

    public Rectangle  solidArea;
    public int solidAreadefaultX, solidAreadefaultY;
    public boolean playercollision = false;

}
