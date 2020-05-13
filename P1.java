import greenfoot.*;  
public class P1 extends Obstacle{
    GreenfootImage redball, flash;
    boolean isOnGround;
    int hSpeed = 0;
    int hSpeedMax = 15;
    int hFriction = 2;
    int hAccel = 4;
    int vSpeed = 0;
    int vSpeedMax = 25;
    boolean isonGround = false;
    boolean isJumping = false;
    int timer = 0;
    int aTimer = 0;
    int fTimer = 0;
    int health = 0;
    int jcooldown = 0;
    boolean k = false;
    int kcooldown = 25;
    GreenfootSound jump = new GreenfootSound("jump1.wav");
    GreenfootSound attack = new GreenfootSound("MMX_item8.wav");
    GreenfootSound special = new GreenfootSound("MMX_item2.wav");

    public P1() {
        redball = new GreenfootImage("red.png");
        flash = new GreenfootImage("red.png");
        //turningR.mirrorHorizontally();
    }

    public void act() 
    {
        timer++;
        groundCheck();
        respawn();
        controls();
        friction();
        maxspeed();
        setLocation(getX()+hSpeed, getY()+vSpeed);
        collisions();
        kcooldown++;
        jcooldown++;
        if (kcooldown > 25) {
            setImage(redball);
        }
        else {
            setImage(flash);
        }
    }

    public void groundCheck(){
        int width = getImage().getWidth();
        int height = getImage().getHeight();
        Actor BL = getOneObjectAtOffset(-width/4,height/2+1, Obstacle.class);
        Actor BR = getOneObjectAtOffset(width/4,height/2+1, Obstacle.class);
        if(BL == null && BR == null){
            isonGround = false;
            if (timer % 2 == 0){
                vSpeed++;
            }
        }
        else{  
            isonGround = true;
            k = false;
        }
    }

    public void respawn() {
        if ((getY()>1200) ||(getX() > 1400) || (getX() < -400)) {
            setLocation(World1.respawnPoint.getX(),World1.respawnPoint.getY());
            World1.mylives.decP1Lives();
            World1.lifecount1.updateScore();
            Greenfoot.playSound("explosion3.wav");
            World1.percent1.resetpercent();
        }

    }
    public void hit (boolean toRight) {
        int addSpeed = 2+(int)(.5*World1.percent1.getPercent());
        if (toRight) {
            hSpeed += addSpeed;
        }
        else {
            hSpeed -= addSpeed;
        }
        vSpeed = -2-(int)(.5*World1.percent1.getPercent());
    }

    public void controls() { 
        if((Greenfoot.isKeyDown("d"))&&(!Greenfoot.isKeyDown("s"))&&(!Greenfoot.isKeyDown("a"))) {

            if (hSpeed == 0){
                hSpeed = 2;
            }
            if (timer % hAccel == 0){
                hSpeed++;
            }
        }
        if ((Greenfoot.isKeyDown("k")) && ((Greenfoot.isKeyDown("w")))) {
            if (kcooldown  >= 50){
                if (k == false) {
                    kcooldown = 0;
                    vSpeed = -15;
                    k = true;
                    special.play();
                }
            }
        }
        if ((Greenfoot.isKeyDown("k")) && ((Greenfoot.isKeyDown("a")))) {
            if (kcooldown  >= 50){
                if (k == false) {
                    kcooldown = 0;
                    hSpeed = -25;
                    k = true;
                    special.play();
                }
            }
        }
        if ((Greenfoot.isKeyDown("k")) && ((Greenfoot.isKeyDown("s")))) {
            Actor P2 = getWorld().getObjects(P2.class).get(0);
            if (timer % 250 == 0) { 
                if ((getY() > getWorld().getObjects(P2.class).get(0).getY() && (getX() > getWorld().getObjects(P2.class).get(0).getX()))) { 
                    vSpeed = -15;
                    hSpeed = -15;
                }
                if ((getY() <getWorld().getObjects(P2.class).get(0).getY() && (getX() > getWorld().getObjects(P2.class).get(0).getX()))) { 
                    vSpeed = 15;
                    hSpeed = -15;
                }
                if ((getY() >getWorld().getObjects(P2.class).get(0).getY() && (getX() < getWorld().getObjects(P2.class).get(0).getX()))) { 
                    vSpeed = -15;
                    hSpeed = 15;
                }
                if ((getY() <getWorld().getObjects(P2.class).get(0).getY() && (getX() < getWorld().getObjects(P2.class).get(0).getX()))) { 
                    vSpeed = 15;
                    hSpeed = 15;
                }
                k = true;
                special.play();
            }
        }
        if ((Greenfoot.isKeyDown("k")) && ((Greenfoot.isKeyDown("d")))) {
            if (kcooldown  >= 50) {
                if (k == false) {
                    kcooldown=0;
                    hSpeed = 25;
                    k = true;
                    special.play();
                }
            }
        }
        if ((Greenfoot.isKeyDown("j")) && ((Greenfoot.isKeyDown("w")))) {
            if (jcooldown  >= 50){
                jcooldown = 0;
                getWorld().addObject(new redspike(0),getX(),getY() );
                attack.play();
            }
        }
        if ((Greenfoot.isKeyDown("j")) && ((Greenfoot.isKeyDown("a")))) {
            if (jcooldown  >= 50){

                jcooldown = 0;
                getWorld().addObject(new redspike(1),getX(),getY() );
                attack.play();
            }
        }
        if ((Greenfoot.isKeyDown("j")) && ((Greenfoot.isKeyDown("s")))) {
            if (jcooldown  >= 50){
                jcooldown = 0;
                getWorld().addObject(new redspike(2),getX(),getY() );
                attack.play();
            }
        }
        if ((Greenfoot.isKeyDown("j")) && ((Greenfoot.isKeyDown("d")))) {
            if (jcooldown  >= 50){
                jcooldown = 0;
                getWorld().addObject(new redspike(3),getX(),getY() );
                attack.play();
            }
        }

        if((Greenfoot.isKeyDown("a"))&&(!Greenfoot.isKeyDown("s"))&&(!Greenfoot.isKeyDown("d"))) {
            if (hSpeed == 0){
                hSpeed = -2;
            }
            if (timer % hAccel == 0){
                hSpeed--;
            }
        }
        if(Greenfoot.isKeyDown("w")&&(isonGround == true)) {
            vSpeed = -15;
            isonGround = false;
            isJumping = true;
            Greenfoot.playSound("jump1.wav");        
        }
        if((!Greenfoot.isKeyDown("w"))&&(isJumping == true)) {
            vSpeed = vSpeed/4;  
            isJumping = false;
        }
        if(isonGround == true){
            isJumping = false;
        }        

        if((Greenfoot.isKeyDown("s"))&&(isonGround == false)) {
            if (timer % 2 == 0) {
                vSpeed++;
            }
        }

    }

    public void friction() {
        if (((!Greenfoot.isKeyDown("d"))&&(!Greenfoot.isKeyDown("a")))||((Greenfoot.isKeyDown("d"))&&(Greenfoot.isKeyDown("a")))){
            if(hSpeed > 0) {
                if(timer % hFriction == 0){
                    hSpeed--;
                }
            }
            if(hSpeed < 0) {
                if(timer % hFriction == 0){
                    hSpeed++;
                }
            }
        }
    }

    public void maxspeed() {
        if (hSpeed > hSpeedMax){
            hSpeed = hSpeedMax;
        }
        if (hSpeed < -hSpeedMax){
            hSpeed = -hSpeedMax;
        }
        if (vSpeed > vSpeedMax){
            vSpeed = vSpeedMax;
        }
        if (vSpeed < -vSpeedMax){
            vSpeed = -vSpeedMax;
        }
    }

    public void collisions(){
        int width = getImage().getWidth();
        int height = getImage().getHeight();
        Actor B = getOneObjectAtOffset(0,height/2, Obstacle.class);
        Actor R = getOneObjectAtOffset(width/2,0, Obstacle.class);
        Actor L = getOneObjectAtOffset(-width/2,0, Obstacle.class);
        Actor T = getOneObjectAtOffset(0,-height/2, Obstacle.class);

        if(B != null){
            vSpeed-= 2;
            vSpeed*= -1;
            int obsY = B.getY();
            int obsH = B.getImage().getHeight();
            setLocation(getX(),obsY-obsH/2-height/2);
        }

        if(T != null){
            vSpeed+= 2;
            vSpeed*= -1/2; 
            int obsY = T.getY();
            int obsH = T.getImage().getHeight();
            setLocation(getX(),obsY+obsH/2+height/2);
        }

        if(L != null){
            hSpeed+= 2;
            hSpeed*= -1;
            int obsX = L.getX();
            int obsW = L.getImage().getWidth();
            setLocation(obsX+obsW/2+width/2,getY());
        }
        if(R != null){
            hSpeed-= 2;
            hSpeed*= -1;
            int obsX = R.getX();
            int obsW = R.getImage().getWidth();
            setLocation(obsX-obsW/2-width/2,getY());
        }

        Actor Bx = getOneObjectAtOffset(0,height/2, P2.class);
        Actor Rx = getOneObjectAtOffset(width/2,0, P2.class);
        Actor Lx = getOneObjectAtOffset(-width/2,0, P2.class);
        Actor Tx = getOneObjectAtOffset(0,-height/2, P2.class);

        if(Bx != null){
            vSpeed = (vSpeed+World1.p2.getvSpeed())/2; 
        }
        if(Tx != null){
            vSpeed = (vSpeed+World1.p2.getvSpeed())/2; 
        }
        if(Lx != null){
            hSpeed = (hSpeed+World1.p2.gethSpeed())/2; 
        }
        if(Rx != null){
            hSpeed = (hSpeed+World1.p2.gethSpeed())/2; 
        }

    }

    public int getvSpeed() {
        return vSpeed;
    }

    public int gethSpeed() {
        return hSpeed;
    }
}

