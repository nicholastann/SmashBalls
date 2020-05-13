import greenfoot.*;
public class World1 extends World{
    public static Respawn respawnPoint = new Respawn();
    public static Lives mylives = new Lives();
    public static LifeCount1 lifecount1 = new LifeCount1();
    public static LifeCount2 lifecount2 = new LifeCount2();
    public static Percent1 percent1 = new Percent1();
    public static Percent2 percent2 = new Percent2();
    public static P2 p2 = new P2();
    public static P1 p1 = new P1();
    boolean k = false;
    int jcooldown = 25;
    GreenfootSound backgroundMusic = new GreenfootSound("Kahoot Lobby Music.mp3");
    public World1() {
        super(1000, 800, 1, false);
        backgroundMusic.playLoop();
        mylives.resetLives();
        percent1.updatePercent();
        percent2.updatePercent();
        lifecount1.updateScore();
        lifecount2.updateScore();
        addObject(percent1,250,750);
        addObject(percent2,900,750);
        addObject(lifecount1,100,750);
        addObject(lifecount2,750,750);
        addObject(p1,500,300);
        addObject(p2,500,300);
        addObject(respawnPoint, 500, 200);
        int y = 675;
        int x = 300;
        int xy = 230;
        int xx = 700;
        for(int i = 0; i<10; i++){
            addObject(new Ground(),x,y);
            x = x + 50;
        }
        y = 220;
        x = 450;

        for(int i = 0; i<5; i++){
            addObject(new MovingWall(),xx,xy);
            xx = xx + 50;
        }
        xx = 300;
        for(int i = 0; i<5; i++){
            addObject(new MovingWall(),xx,xy);
            xx = xx - 50;
        }

    }

    public void act(){
        Actor P2 = getObjects(P2.class).get(0);
        Actor P1 = getObjects(P1.class).get(0);
        if(mylives.getP1Lives()<1){
            Greenfoot.setWorld(new WinScreen(1));
        }
        else if(mylives.getP2Lives()<1){
            Greenfoot.setWorld(new WinScreen(2));
        }


        jcooldown++;
    }
}

