import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LifeCount2 extends Actor{
    public void act() {
        // Add your action code here.
    }    

    public LifeCount2(){
        setImage(new GreenfootImage("P2 lives "+World1.mylives.getP2Lives(),30,greenfoot.Color.BLACK,greenfoot.Color.WHITE));
    }
    public void updateScore(){
        setImage(new GreenfootImage("P2 lives "+World1.mylives.getP2Lives(),30,greenfoot.Color.BLACK,greenfoot.Color.WHITE));
        }
}