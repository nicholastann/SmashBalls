import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Lives extends Actor{
    private int p1lives;
    private int p2lives;
    public Lives(){
        p1lives = 5;
        p2lives = 5;
    }
    
    public void decP1Lives(){
        p1lives--;
    }
    public void decP2Lives(){
        p2lives--;
    }
    
    public int getP1Lives(){
        return p1lives;
    }
    public int getP2Lives(){
        return p2lives;
    }
    
    public void act() {
        // Add your action code here.
    }    
    public void resetLives(){
        p1lives=5;
        p2lives=5;
    }
}
