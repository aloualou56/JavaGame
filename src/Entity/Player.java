package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


import Main.MainPannel;
import Main.KeyHandler;

public class Player extends Entity {

    MainPannel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    int hasKey = 0;

    int width;
    int height;
    int ScreenY_for_drawing_player;
    int ScreenX_for_drawing_player;
    String previous_direction;


    public Player(MainPannel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);  //Gia to camera
        screenY = gp.screenHeight/2 - (gp.tileSize/2); // movement

        solidArea = new Rectangle(); //to rectagle einai gia to collision. To box tou colosion tou player einai 32x32 anti gia 48x48 pou einai to texture tou gia na uparxei perithorio na xoraei eukolotera se meri
        solidArea.x = 8;
        solidArea.y = 8;
        solidAreadefaultX = solidArea.x;
        solidAreadefaultY = solidArea.y;
        solidArea.width = 32; // 32 htan to default
        solidArea.height = 32; // 32 htan to default

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues () {

        //Default settings of player

        WorldX = gp.tileSize * 25;  //anti gia 100; mporo na kano to gp.tileSize * epi poso delo gia na pao se kapoio sigekrimeno simeio/tale    
        WorldY = gp.tileSize * 25;
        speed = 4;  //posa pixel da paei se kade direction
        direction = "left"; 

        
        
    }
    
    public void getPlayerImage() {
        try {

            standing1 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/standing_sprites/standing_1.png"));
            System.out.println("loaded standing1");
            standing2 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/standing_sprites/standing_2.png"));
            System.out.println("loaded standing2");
            standing3 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/standing_sprites/standing_3.png"));
            System.out.println("loaded standing3");
            standing4 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/standing_sprites/standing_4.png"));
            System.out.println("loaded standing4");
            standing5 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/standing_sprites/standing_5.png"));
            System.out.println("loaded standing5");
            standing6 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/standing_sprites/standing_6.png"));
            System.out.println("loaded standing6");
            
            
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_1.png"));
            System.out.println("loaded up1");
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_2.png"));
            System.out.println("loaded up2");
            up3 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_3.png"));
            System.out.println("loaded up3");
            up4 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_4.png"));
            System.out.println("loaded up4");
            up5 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_5.png"));
            System.out.println("loaded up5");
            up6 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_6.png"));
            System.out.println("loaded up6");

            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_1.png"));
            System.out.println("loaded down1");
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_2.png"));
            System.out.println("loaded down2");
            down3 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_3.png"));
            System.out.println("loaded down3");
            down4 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_4.png"));
            System.out.println("loaded down4");
            down5 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_5.png"));
            System.out.println("loaded down5");
            down6 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_6.png"));
            System.out.println("loaded down6");

            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_1.png"));
            System.out.println("loaded left1");
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_2.png"));
            System.out.println("loaded left2");
            left3 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_3.png"));
            System.out.println("loaded left3");
            left4 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_4.png"));
            System.out.println("loaded left4");
            left5 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_5.png"));
            System.out.println("loaded left5");
            left6 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_6.png"));
            System.out.println("loaded left6");

            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_1.png"));
            System.out.println("loaded right1");
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_2.png"));
            System.out.println("loaded right2");
            right3 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_3.png"));
            System.out.println("loaded right3");
            right4 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_4.png"));
            System.out.println("loaded right4");
            right5 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_5.png"));
            System.out.println("loaded right5");
            right6 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/walking_sprites/walking_6.png"));
            System.out.println("loaded right6");

            fight1 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/fight_sprites/fight_1.png"));
            System.out.println("loaded fight1");
            fight2 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/fight_sprites/fight_2.png"));
            System.out.println("loaded fight2");
            fight3 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/fight_sprites/fight_3.png"));
            System.out.println("loaded fight3");
            fight4 = ImageIO.read(getClass().getResourceAsStream("/sprites/characters/cutted-character/fight_sprites/fight_4.png"));
            System.out.println("loaded fight4");


        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void upleft() {
        
        WorldX = WorldX - (speed / 1); //Για 60fps πρεπει να ειναι (speed / 2)
        WorldY = WorldY - (speed / 1);
        direction = "left";
    }
    public void upright() {
        gp.Gamespeed = 1;
        WorldX = WorldX + (speed / 1);
        WorldY = WorldY - (speed / 1);
        direction = "right";
    }
    public void downleft() {
        
        WorldX = WorldX - (speed / 1);
        WorldY = WorldY + (speed / 1);
        direction = "left";
    }
    public void downright() {
        
        WorldX = WorldX + (speed / 1);
        WorldY = WorldY + (speed / 1);
        direction = "right";
    }
    
    public void update() {   

        //test gia to attack mode
        if(keyH.attack == true) {
            
            direction = "attack";

            spriteCounter_for_attack++;
            if(spriteCounter_for_attack > 3) {

                switch(spriteNum_for_attack) {
                    case 1: 
                    spriteNum_for_attack = 2;
                    break;

                    case 2:
                    spriteNum_for_attack = 3;
                    break;

                    case 3: 
                    spriteNum_for_attack = 4;
                    break;

                    case 4:
                    spriteNum_for_attack = 1;
                    break;
                }

                spriteCounter_for_attack = 0;

            
            }
                         
        } else if(keyH.attack == false) {
            spriteNum_for_attack = 4; //kanei reset to animation se ena sigekrimeno image, edo evala to 4
        }
        //test gia to attack mode
        
        if(keyH.upPressed == false || keyH.downPressed == false || keyH.leftPressed == false || keyH.rightPressed == false ) 
        if(keyH.attack == false) {
            //Edo vale to standing animation na paizei
            direction = "none";
            
            
            spriteCounter_for_idle++;
            if(spriteCounter_for_idle > 5) {

                switch(spriteNum_for_standing_animation) {
                    case 1:
                    spriteNum_for_standing_animation = 2;
                    //System.out.println("spriteNum_for_standing_animation = " + spriteNum_for_standing_animation);
                    break;

                    case 2:
                    spriteNum_for_standing_animation = 3;
                    //System.out.println("spriteNum_for_standing_animation = " + spriteNum_for_standing_animation);
                    break;

                    case 3:
                    spriteNum_for_standing_animation = 4;
                    //System.out.println("spriteNum_for_standing_animation = " + spriteNum_for_standing_animation);
                    break;

                    case 4:
                    spriteNum_for_standing_animation = 5;
                    //System.out.println("spriteNum_for_standing_animation = " + spriteNum_for_standing_animation);
                    break;

                    case 5:
                    spriteNum_for_standing_animation = 6;
                    //System.out.println("spriteNum_for_standing_animation = " + spriteNum_for_standing_animation);
                    break;

                    case 6:
                    spriteNum_for_standing_animation = 1;
                    //System.out.println("spriteNum_for_standing_animation = " + spriteNum_for_standing_animation);
                    break;
                }

                spriteCounter_for_idle = 0;
            }
        }
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
        if(keyH.attack == false) {
            if(keyH.upPressed == true) {
                direction ="up";  //to 0,0 se x,y sto JPanel einai h pano goneia aristera
                //Den xreiazete pleon einai sto switch kato -> WorldY = WorldY - speed;      //an paei pano tote to Y mikrenei
            }
            if(keyH.upPressed == true && keyH.leftPressed == true) {
                upleft();
                
            }
            if(keyH.upPressed == true && keyH.rightPressed == true) {
                upright();
            }
            if(keyH.downPressed == true) {
                direction = "down";
                //Den xreiazete pleon einai sto switch kato -> WorldY = WorldY + speed;
            }
            if(keyH.downPressed == true && keyH.leftPressed == true) {
                downleft();
            }
            if(keyH.downPressed == true && keyH.rightPressed == true) {
                downright();
            }
            if(keyH.leftPressed == true) {
              
                direction = "left";
                //Den xreiazete pleon einai sto switch kato -> WorldX = WorldX - speed;
            }
            if(keyH.rightPressed == true) {
               
                direction = "right";
                //Den xreiazete pleon einai sto switch kato -> WorldX = WorldX + speed;
            }

            // // edo vlepoume an ginete collision tou player(to rectagle) me tile to ensomati
            playercollision = false; //einai sto Entity.Entity class to boolean 
            gp.collisionChecker.checkTile(this);

            //elenxoume to collition me ta objects
            int objindex = gp.collisionChecker.checkObjectCollition(this, true); //to ...this... leei dixnei oti to entity einai o player kai to ....true.... einai to boolean tou player. Gia na katalaveis des to funciton
            pickUpObject(objindex);
            // an to colition einai lados tote o player mporei na kinidei

            

            if(playercollision == false && keyH.attack == false) {
                switch(direction) {
                    case "up":
                    
                    WorldY = WorldY - (speed * 2); //Για 60fps πρεπει να ειναι (speed x 1)
                    break;

                    case "down":
                    
                    WorldY = WorldY + (speed * 2);
                    break;

                    case "left":
                    
                    WorldX = WorldX - (speed * 2);
                    break;

                    case "right":
                    
                    WorldX = WorldX + (speed * 2);
                    break;

                    case "none":
                    
                    //epeidi einai to standing apla den kinite lol
                    break;
               }
            }


            spriteCounter++;
            if(spriteCounter > 5) {

                switch(spriteNum) {
                    case 1:
                    spriteNum = 2;
                    //System.out.println("spriteNum = " + spriteNum);
                    break;

                    case 2:
                    spriteNum = 3;
                    //System.out.println("spriteNum = " + spriteNum);
                    break;

                    case 3:
                    spriteNum = 4;
                    //System.out.println("spriteNum = " + spriteNum);
                    break;

                    case 4:
                    spriteNum = 5;
                    //System.out.println("spriteNum = " + spriteNum);
                    break;

                    case 5:
                    spriteNum = 6;
                    //System.out.println("spriteNum = " + spriteNum);
                    break;

                    case 6:
                    spriteNum = 1;
                    //System.out.println("spriteNum = " + spriteNum);
                    break;
                }

                spriteCounter = 0;
            }
            
        } 
            
    }

    public void pickUpObject(int i) {
        if(i != 999) {

            String objectName = gp.obj[i].name;
            switch(objectName) {
                case "key":
                hasKey++;
                gp.obj[i] = null;
                System.out.println("Player has " + hasKey + " keys");
                break;

                case "door":
                if(hasKey > 0) {
                    gp.obj[i] = null;
                    hasKey--;
                }
                System.out.println("Player has " + hasKey + " keys");
                break;
            }
        }
    }

    public void draw(Graphics2D g2) {

        

        

        BufferedImage image = null;
        
        switch(direction) {
            
            case "up":
            switch(previous_direction) {
                case "left":
                width = -gp.tileSize;
                ScreenX_for_drawing_player = screenX + gp.tileSize;
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                if(spriteNum == 3) {
                    image = left3;
                }
                if(spriteNum == 4) {
                    image = left4;
                }
                if(spriteNum == 5) {
                    image = left5;
                }
                if(spriteNum == 6) {
                    image = left6;
                }
                break;

                case "right":
                width = gp.tileSize;
                ScreenX_for_drawing_player = screenX;
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                if(spriteNum == 3) {
                    image = right3;
                }
                if(spriteNum == 4) {
                    image = right4;
                }
                if(spriteNum == 5) {
                    image = right5;
                }
                if(spriteNum == 6) {
                    image = right6;
                }
                break;
            }
            break;

            case "down":
            switch(previous_direction) {
                case "left":
                width = -gp.tileSize;
                ScreenX_for_drawing_player = screenX + gp.tileSize;
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                if(spriteNum == 3) {
                    image = left3;
                }
                if(spriteNum == 4) {
                    image = left4;
                }
                if(spriteNum == 5) {
                    image = left5;
                }
                if(spriteNum == 6) {
                    image = left6;
                }
                break;

                case "right":
                width = gp.tileSize;
                ScreenX_for_drawing_player = screenX;
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                if(spriteNum == 3) {
                    image = right3;
                }
                if(spriteNum == 4) {
                    image = right4;
                }
                if(spriteNum == 5) {
                    image = right5;
                }
                if(spriteNum == 6) {
                    image = right6;
                }
                break;
            }
            break;
            

            case "left":
            case "up-left":
            width = -gp.tileSize;
            ScreenX_for_drawing_player = screenX + gp.tileSize;
            previous_direction = "left";
            if(spriteNum == 1) {
                image = left1;
                
            }
            if(spriteNum == 2) {
                image = left2;
                
            }
            if(spriteNum == 3) {
                image = left3;
                
            }
            if(spriteNum == 4) {
                image = left4;
                
            }
            if(spriteNum == 5) {
                image = left5;
                
            }
            if(spriteNum == 6) {
                image = left6;
                
            }
            break;

            case "right":
            width = gp.tileSize;
            ScreenX_for_drawing_player = screenX;
            previous_direction = "right";
            if(spriteNum == 1) {
                image = right1;
                
            }
            if(spriteNum == 2) {
                image = right2;
                
            }
            if(spriteNum == 3) {
                image = right3;
                
            }
            if(spriteNum == 4) {
                image = right4;
                
            }
            if(spriteNum == 5) {
                image = right5;
                
            }
            if(spriteNum == 6) {
                image = right6;
                
            }
            break;

            case "none":
            switch(previous_direction) {
                case "left":
                width = -gp.tileSize;
                ScreenX_for_drawing_player = screenX + gp.tileSize;
                if(spriteNum_for_standing_animation == 1) {
                    image = standing1;
                }
                if(spriteNum_for_standing_animation == 2) {
                    image = standing2;
                }
                if(spriteNum_for_standing_animation == 3) {
                    image = standing3;
                }
                if(spriteNum_for_standing_animation == 4) {
                    image = standing4;
                }
                if(spriteNum_for_standing_animation == 5) {
                    image = standing5;
                }
                if(spriteNum_for_standing_animation == 6) {
                    image = standing6;
                }
                break;

                case "right":
                width = gp.tileSize;
                ScreenX_for_drawing_player = screenX;
                if(spriteNum_for_standing_animation == 1) {
                    image = standing1;
                }
                if(spriteNum_for_standing_animation == 2) {
                    image = standing2;
                }
                if(spriteNum_for_standing_animation == 3) {
                    image = standing3;
                }
                if(spriteNum_for_standing_animation == 4) {
                    image = standing4;
                }
                if(spriteNum_for_standing_animation == 5) {
                    image = standing5;
                }
                if(spriteNum_for_standing_animation == 6) {
                    image = standing6;
                }
                break;
            }
            break;

            case "attack":
                switch(previous_direction) {
                    case "left":
                    width = -gp.tileSize;
                    ScreenX_for_drawing_player = screenX + gp.tileSize;
                    if(spriteNum_for_attack == 1) {
                        image = fight1;
                    }
                    if(spriteNum_for_attack == 2) {
                        image = fight2;
                    }
                    if(spriteNum_for_attack == 3) {
                        image = fight3;
                    }
                    if(spriteNum_for_attack == 4) {
                        image = fight4;
                    }
                    break;
                    
                    case "right":
                    width = gp.tileSize;
                    ScreenX_for_drawing_player = screenX;
                    if(spriteNum_for_attack == 1) {
                        image = fight1;
                    }
                    if(spriteNum_for_attack == 2) {
                        image = fight2;
                    }
                    if(spriteNum_for_attack == 3) {
                        image = fight3;
                    }
                    if(spriteNum_for_attack == 4) {
                        image = fight4;
                    }
                    break;
                }
            break;
        }

        height = gp.tileSize;

        g2.drawImage(image, ScreenX_for_drawing_player, screenY, width, height, null);
    }

    
}
