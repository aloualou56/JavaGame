package TexturesTiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

import Main.MainPannel;

public class TileManager {

    MainPannel gp;
    public Tiles[] tile;
    //gia na ta vazo os txt ta maps
    public int mapTileNum[][];


    public TileManager(MainPannel gp) {
        
        this.gp = gp;

        tile = new Tiles[35]; //mporo na valo max 35 tiles
        //gia to txt
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("map01.txt");
    }

    public void getTileImage() {

        try {

            tile[0] = new Tiles();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/grass1.png"));

            tile[1] = new Tiles();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/grass2.png"));

            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/grass3.png"));

            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/grass.png"));
            
            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/grass4.png"));

            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/dirt1.png"));

            tile[6] = new Tiles();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/dirt2.png"));

            tile[7] = new Tiles();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/dirt3.png"));

            tile[8] = new Tiles();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/sprites/tilesets/16x16 set/dirt4.png"));

            tile[9] = new Tiles();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road03.png"));
            tile[9].collision = true;

            tile[10] = new Tiles();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road04.png"));
            tile[10].collision = true;

            tile[11] = new Tiles();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road05.png"));
            tile[11].collision = true;

            tile[12] = new Tiles();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road06.png"));
            tile[12].collision = true;

            tile[13] = new Tiles();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road07.png"));
            tile[13].collision = true;

            tile[14] = new Tiles();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road08.png"));
            tile[14].collision = true;

            tile[15] = new Tiles();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road09.png"));
            tile[15].collision = true;

            tile[16] = new Tiles();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road10.png"));

            tile[17] = new Tiles();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road11.png"));

            tile[18] = new Tiles();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/road12.png"));

            tile[19] = new Tiles();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/table01.png"));

            tile[20] = new Tiles();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/tree.png"));

            tile[21] = new Tiles();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/wall.png"));
            tile[21].collision = true;

            tile[22] = new Tiles();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water00.png"));
            tile[22].collision = true;

            tile[23] = new Tiles();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water01.png"));
            tile[23].collision = true;

            tile[24] = new Tiles();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water02.png"));
            tile[24].collision = true;

            tile[24] = new Tiles();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water03.png"));
            tile[24].collision = true;

            tile[25] = new Tiles();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water04.png"));
            tile[25].collision = true;

            tile[26] = new Tiles();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water05.png"));
            tile[26].collision = true;

            tile[27] = new Tiles();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water06.png"));
            tile[27].collision = true;

            tile[28] = new Tiles();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water07.png"));
            tile[28].collision = true;

            tile[29] = new Tiles();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water08.png"));
            tile[29].collision = true;

            tile[30] = new Tiles();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water09.png"));
            tile[30].collision = true;

            tile[31] = new Tiles();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water10.png"));
            tile[31].collision = true;

            tile[32] = new Tiles();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water11.png"));
            tile[32].collision = true;

            tile[33] = new Tiles();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water12.png"));
            tile[33].collision = true;

            tile[34] = new Tiles();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/texture_sprites/water13.png"));
            tile[34].collision = true;


        }catch(IOException e) {
            e.printStackTrace();
        }

    }
    //gia ta txt
    public void loadMap(String map) { //me to string orizo to file pou einai to map
        try {
            InputStream is = getClass().getResourceAsStream(("/maps/" + map)); //anti gia "/maps/map01.txt" kalo to map apo to function
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol  && row < gp.maxWorldRow) {
                String line = br.readLine();

                while(col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row ++;
                }
            }
            br.close();

        }catch(IOException e) {
            e.printStackTrace();
            
        }
    }

    public void draw(Graphics2D g2) {
        //kade ena tile einai 48x48 opote prosoxi sta noumera

        int worldCol = 0;
        int worldRow = 0;

        //edo kato einai gia tin camera na kineite kai o pextis sto kentro
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;                                            
            int worldY = worldRow * gp.tileSize;                                            
            int screenX = worldX - gp.player.WorldX + gp.player.screenX;                    
            int screenY = worldY - gp.player.WorldY + gp.player.screenY;                    
            
            //gia kalitero rendering efficiency code start

            if(worldX + gp.tileSize > gp.player.WorldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.WorldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.WorldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.WorldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }

            //telos to improved code gia efficiency sto rendering
            
            worldCol++;
            
            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
               
                worldRow++;
                

            }
        }
    
    }

    
}
