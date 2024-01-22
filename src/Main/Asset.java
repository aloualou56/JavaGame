package Main;

import object.obj_boots;
import object.obj_chest;
import object.obj_door;
import object.obj_key;


public class Asset {
    MainPannel gp;

    public Asset(MainPannel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new obj_key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new obj_door();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 9 * gp.tileSize;

        gp.obj[2] = new obj_chest();
        gp.obj[2].worldX = 23 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new obj_boots();
        gp.obj[3].worldX = 23 * gp.tileSize;
        gp.obj[3].worldY = 10 * gp.tileSize;
    }
    
}
