package Main;


import Environment.env_grass1;
import Environment.env_grass2;
import Environment.env_grass3;
import Environment.env_grass4;
import Environment.thamnos_tonia;
import java.util.Random;



public class Environment_Assets {
    MainPannel gp;
    Random rand = new Random();
   
    

    public Environment_Assets(MainPannel gp) {
        this.gp = gp;

    }

    public void setEnvironment() {

        
        int max_numbg = 4;
        



        for(int y = 1; y < 49; y ++) {

            int random0, random1, random2, random3, random4, random5, random6, random7;
            
            //vale na ginete randomized o ta 4 eidi fiton
            random0 = rand.nextInt(max_numbg);
            //gp.env[0 + y * 18] = new env_grass1();
            randomtile(0 + y * 8);
            gp.env[0 + y * 8].worldX = (4 + random0) * gp.tileSize;
            gp.env[0 + y * 8].worldY = y * gp.tileSize;
            gp.env[0 + y * 8].dierototilesizemeto = 2;

            random1 = rand.nextInt(max_numbg);
            //gp.env[1 + y * 18] = new env_grass4();
            randomtile(1 + y * 8);
            gp.env[1 + y * 8].worldX = (10 + random1) * gp.tileSize;
            gp.env[1 + y * 8].worldY = y * gp.tileSize;
            gp.env[1 + y * 8].dierototilesizemeto = 2;

            random2 = rand.nextInt(max_numbg);
            //gp.env[2 + y * 18] = new env_grass1();
            randomtile(2 + y * 8);
            gp.env[2 + y * 8].worldX = (16 + random2) * gp.tileSize;
            gp.env[2 + y * 8].worldY = y * gp.tileSize;
            gp.env[2 + y * 8].dierototilesizemeto = 2;

            random3 = rand.nextInt(max_numbg);
            //gp.env[3 + y * 18] = new env_grass2();
            randomtile(3 + y * 8);
            gp.env[3 + y * 8].worldX = (22 + random3) * gp.tileSize;
            gp.env[3 + y * 8].worldY = y * gp.tileSize;
            gp.env[3 + y * 8].dierototilesizemeto = 2;

            random4 = rand.nextInt(max_numbg);
            //gp.env[4 + y * 18] = new env_grass3();
            randomtile(4 + y * 8);
            gp.env[4 + y * 8].worldX = (28 + random4) * gp.tileSize;
            gp.env[4 + y * 8].worldY = y * gp.tileSize;
            gp.env[4 + y * 8].dierototilesizemeto = 2;

            random5 = rand.nextInt(max_numbg);
            //gp.env[5 + y * 18] = new env_grass4();
            randomtile(5 + y * 8);
            gp.env[5 + y * 8].worldX = (34 + random5) * gp.tileSize;
            gp.env[5 + y * 8].worldY = y * gp.tileSize;
            gp.env[5 + y * 8].dierototilesizemeto = 2;

            random6 = rand.nextInt(max_numbg);
            //gp.env[6 + y * 18] = new env_grass1();
            randomtile(6 + y * 8);
            gp.env[6 + y * 8].worldX = (40  + random6) * gp.tileSize;
            gp.env[6 + y * 8].worldY = y * gp.tileSize;
            gp.env[6 + y * 8].dierototilesizemeto = 2;

            random7 = rand.nextInt(max_numbg);
            //gp.env[7 + y * 18] = new env_grass2();
            randomtile(7 + y * 8);
            gp.env[7 + y * 8].worldX = (46 + random7) * gp.tileSize;
            gp.env[7 + y * 8].worldY = y * gp.tileSize;
            gp.env[7 + y * 8].dierototilesizemeto = 2;

            

            y = y + 3;
            System.out.println(y);
        } // to loop auto vazei AKRIVOS 368 pragmata

        gp.env[369] = new thamnos_tonia();
        gp.env[369].worldX = 24 * gp.tileSize;
        gp.env[369].worldY = 24 * gp.tileSize;
        gp.env[369].dierototilesizemeto = 1;

        
        


    }

    private void randomtile(int numoft) {
        int num = rand.nextInt(4); // to value 4 kanei to random na dinei apo 0 eos 3, dld kapos einai to upper limit -> upperlimit - 1
        switch (num) {
            case 0:
            gp.env[numoft] = new env_grass1();
            break;

            case 1: 
            gp.env[numoft] = new env_grass2(); 
            break;

            case 2:
            gp.env[numoft] = new env_grass3();
            break;

            case 3:
            gp.env[numoft] = new env_grass4();
            break;
        }
    }
    





    
}

