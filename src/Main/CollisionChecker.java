package Main;

import Entity.Entity;

public class CollisionChecker {

    MainPannel gp;


    public CollisionChecker(MainPannel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity Entity, double dt) {

        int entityLeftWorldX = (int)(Entity.WorldX + Entity.solidArea.x);
        int entityRightWorldX = (int)(Entity.WorldX + Entity.solidArea.x + Entity.solidArea.width);
        int entityTopWorldY = (int)(Entity.WorldY + Entity.solidArea.y);
        int entityBottomWorldY = (int)(Entity.WorldY + Entity.solidArea.y + Entity.solidArea.height);

        int entityleftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopCol = entityTopWorldY/gp.tileSize;
        int entityBottomCol = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;
        double moveAmount = Entity.speed * dt;

        // Helper variables for checks
        boolean collisionDetected = false;

        // We check each component direction involved
        String directionsToCheck[] = {};

        switch(Entity.direction) {
            case "up": directionsToCheck = new String[]{"up"}; break;
            case "down": directionsToCheck = new String[]{"down"}; break;
            case "left": directionsToCheck = new String[]{"left"}; break;
            case "right": directionsToCheck = new String[]{"right"}; break;
            case "up-left": directionsToCheck = new String[]{"up", "left"}; break;
            case "up-right": directionsToCheck = new String[]{"up", "right"}; break;
            case "down-left": directionsToCheck = new String[]{"down", "left"}; break;
            case "down-right": directionsToCheck = new String[]{"down", "right"}; break;
        }

        for (String dir : directionsToCheck) {
             switch(dir) {
                case "up":
                int nextTopCol = (int)((entityTopWorldY - moveAmount)/gp.tileSize);
                if(nextTopCol >= 0 && nextTopCol < gp.maxWorldRow && entityleftCol >= 0 && entityleftCol < gp.maxWorldCol && entityRightCol >= 0 && entityRightCol < gp.maxWorldCol) {
                    tileNum1 = gp.tileM.mapTileNum[entityleftCol][nextTopCol];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][nextTopCol];
                    if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        collisionDetected = true;
                    }
                } else {
                    collisionDetected = true;
                }
                break;

                case "down":
                int nextBottomCol = (int)((entityBottomWorldY + moveAmount)/gp.tileSize);
                if(nextBottomCol >= 0 && nextBottomCol < gp.maxWorldRow && entityleftCol >= 0 && entityleftCol < gp.maxWorldCol && entityRightCol >= 0 && entityRightCol < gp.maxWorldCol) {
                    tileNum1 = gp.tileM.mapTileNum[entityleftCol][nextBottomCol];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][nextBottomCol];
                    if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        collisionDetected = true;
                    }
                } else {
                    collisionDetected = true;
                }
                break;

                case "left":
                int nextLeftCol = (int)((entityLeftWorldX - moveAmount)/gp.tileSize);
                if(nextLeftCol >= 0 && nextLeftCol < gp.maxWorldCol && entityTopCol >= 0 && entityTopCol < gp.maxWorldRow && entityBottomCol >= 0 && entityBottomCol < gp.maxWorldRow) {
                    tileNum1 = gp.tileM.mapTileNum[nextLeftCol][entityTopCol];
                    tileNum2 = gp.tileM.mapTileNum[nextLeftCol][entityBottomCol];
                    if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        collisionDetected = true;
                    }
                } else {
                    collisionDetected = true;
                }
                break;

                case "right":
                int nextRightCol = (int)((entityRightWorldX + moveAmount)/gp.tileSize);
                if(nextRightCol >= 0 && nextRightCol < gp.maxWorldCol && entityTopCol >= 0 && entityTopCol < gp.maxWorldRow && entityBottomCol >= 0 && entityBottomCol < gp.maxWorldRow) {
                    tileNum1 = gp.tileM.mapTileNum[nextRightCol][entityTopCol];
                    tileNum2 = gp.tileM.mapTileNum[nextRightCol][entityBottomCol];
                    if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                        collisionDetected = true;
                    }
                } else {
                    collisionDetected = true;
                }
                break;
            }
            if (collisionDetected) {
                Entity.playercollision = true;
                break; // If any direction collides, we consider it a collision
            }
        }
    }

    public int checkObjectCollition(Entity entity, boolean player, double dt) {
        int index = 999;
        double moveAmount = entity.speed * dt;

        for(int i = 0; i < gp.obj.length; i++) {

            if(gp.obj[i] != null) {
                // Get entity's solid area position
                entity.solidArea.x = (int)(entity.WorldX + entity.solidArea.x);
                entity.solidArea.y = (int)(entity.WorldY + entity.solidArea.y);

                // Get object's solid area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                // For object collision, we simplify and check the primary direction or both for diagonals.
                // Or simply check the intersection after applying moveAmount to the respective axes.
                // Since this method modifies entity.solidArea temporarily, handling diagonals is tricky if we do it one by one.
                // A better way is to move the rect and check intersection.

                int originalX = entity.solidArea.x;
                int originalY = entity.solidArea.y;

                if (entity.direction.contains("up")) {
                    entity.solidArea.y -= moveAmount;
                }
                if (entity.direction.contains("down")) {
                    entity.solidArea.y += moveAmount;
                }
                if (entity.direction.contains("left")) {
                    entity.solidArea.x -= moveAmount;
                }
                if (entity.direction.contains("right")) {
                    entity.solidArea.x += moveAmount;
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
