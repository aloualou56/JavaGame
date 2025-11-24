package Main;

import Entity.Entity;

public class CollisionChecker {

    MainPannel gp;


    public CollisionChecker(MainPannel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity Entity) {

        int entityLeftWorldX = Entity.WorldX + Entity.solidArea.x;                                          //Edo kanoume se int to poso da einai
        int entityRightWorldX = Entity.WorldX + Entity.solidArea.x + Entity.solidArea.width;                //to collitionbox tou pexti
        int entityTopWorldY = Entity.WorldY + Entity.solidArea.y;                                           //oste na to xrisimopoiisoume meta
        int entityBottomWorldY = Entity.WorldY + Entity.solidArea.y + Entity.solidArea.height;              // einai to pano-kato-dexia-aristera

        int entityleftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopCol = entityTopWorldY/gp.tileSize;
        int entityBottomCol = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(Entity.direction) {
            case "up":
            entityTopCol = (entityTopWorldY - Entity.speed)/gp.tileSize;
            if(entityTopCol >= 0 && entityTopCol < gp.maxWorldRow && entityleftCol >= 0 && entityleftCol < gp.maxWorldCol && entityRightCol >= 0 && entityRightCol < gp.maxWorldCol) {
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityTopCol];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopCol];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    Entity.playercollision = true;
                }
            } else {
                Entity.playercollision = true;
            }
            break;

            case "down":
            entityBottomCol = (entityBottomWorldY + Entity.speed)/gp.tileSize;
            if(entityBottomCol >= 0 && entityBottomCol < gp.maxWorldRow && entityleftCol >= 0 && entityleftCol < gp.maxWorldCol && entityRightCol >= 0 && entityRightCol < gp.maxWorldCol) {
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityBottomCol];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomCol];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    Entity.playercollision = true;
                }
            } else {
                Entity.playercollision = true;
            }
            break;

            case "left":
            entityleftCol = (entityLeftWorldX - Entity.speed)/gp.tileSize;
            if(entityleftCol >= 0 && entityleftCol < gp.maxWorldCol && entityTopCol >= 0 && entityTopCol < gp.maxWorldRow && entityBottomCol >= 0 && entityBottomCol < gp.maxWorldRow) {
                tileNum1 = gp.tileM.mapTileNum[entityleftCol][entityTopCol];
                tileNum2 = gp.tileM.mapTileNum[entityleftCol][entityBottomCol];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    Entity.playercollision = true;
                }
            } else {
                Entity.playercollision = true;
            }
            break;

            case "right":
            entityRightCol = (entityRightWorldX + Entity.speed)/gp.tileSize;
            if(entityRightCol >= 0 && entityRightCol < gp.maxWorldCol && entityTopCol >= 0 && entityTopCol < gp.maxWorldRow && entityBottomCol >= 0 && entityBottomCol < gp.maxWorldRow) {
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopCol];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomCol];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    Entity.playercollision = true;
                }
            } else {
                Entity.playercollision = true;
            }

            break;
        }
    }
    public int checkObjectCollition(Entity entity, boolean player) {
        int index = 999;

        for(int i = 0; i < gp.obj.length; i++) {

            if(gp.obj[i] != null) {
                // Get entity's solid area position
                entity.solidArea.x = entity.WorldX + entity.solidArea.x;
                entity.solidArea.y = entity.WorldY + entity.solidArea.y;

                // Get object's solid area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                    entity.solidArea.y -= entity.speed;
                    break;
                    case "down":
                    entity.solidArea.y += entity.speed;
                    break;
                    case "left":
                    entity.solidArea.x -= entity.speed;
                    break;
                    case "right":
                    entity.solidArea.x += entity.speed;
                    break;
                }

                if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                    if(gp.obj[i].collision == true) {
                        entity.playercollision = true;
                    }
                    if(player == true) {
                        index = i;
                    }
                }

                entity.solidArea.x = entity.solidAreadefaultX;
                entity.solidArea.y = entity.solidAreadefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreadefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreadefaultY;
            }
        }

        return index;
    }
}
