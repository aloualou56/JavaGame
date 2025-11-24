package Main;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;



import Entity.Player;


import TexturesTiles.TileManager;
import object.object;
import Environment.environment;


public class MainPannel extends JPanel implements Runnable {

    //Settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 6; //original 3e

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 8; //arxiko 16
    public final int MaxScreenRow = 6; //arxiko 12
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * MaxScreenRow; // 576 pixels

    //WORLD SETTINGS

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    //Setting FPS

    int FPS = 30;
    public int Gamespeed = 1; // einai gia otan o paixtis pigainei plagia, anti gia na einai 2 fores pio argo afou den ginete h kinisi kano pio agro to game loop



    TileManager tileM = new TileManager(this); //kaloume to tilManager class apo ta TextureTiles

    KeyHandler keyH = new KeyHandler(); //start keyhandler to game panel
    MouseHandler MouseH = new MouseHandler();

    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public Asset asset = new Asset(this);
    public Environment_Assets env_Assets = new Environment_Assets(this);
    Thread gameThread;

    //to kano public oste na to pernei sto tileManager me tin camera movement
    public Player player = new Player(this, keyH, MouseH);
    public object obj[] = new object[10];
    public environment env[] = new environment[400];


    public MainPannel () {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); //adding keyhandler to game panel
        this.addMouseListener(MouseH);
        this.setFocusable(true);
    }

    public void setupGame() {
        asset.setObject();
        env_Assets.setEnvironment();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();

        while(gameThread != null) {

            long currentTime = System.nanoTime();
            double dt = (currentTime - lastTime) / 1000000000.0;
            lastTime = currentTime;

            update(dt);

            repaint();

            // Optional: minimal sleep to avoid 100% CPU usage if not vsynced,
            // but for pure delta time loop, usually we just run as fast as possible
            // or let vsync handle it.
            // Here I'll add a small sleep to be safe for this environment.
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void update(double dt) {
     player.update(dt);
     //System.out.println(player.WorldX + " " + player.WorldY);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        //gia ta tiles
        tileM.draw(g2);

        //gia ta object
        for(int i = 0; i < obj.length; i++) {
            if(obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        //Gia to environment

        for(int i = 0; i < env.length; i++) {
            if(env[i] != null) {
                env[i].draw(g2, this);
            }
        }



        //gia ton player
        player.draw(g2);
        g2.dispose();
    }

}