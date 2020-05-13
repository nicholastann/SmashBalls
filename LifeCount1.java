import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LifeCount1 extends Actor{
    public void act() {
        // Add your action code here.
    }    

    public LifeCount1(){
        setImage(new GreenfootImage("P1 lives "+World1.mylives.getP1Lives(),30,greenfoot.Color.BLACK,greenfoot.Color.WHITE));
    }
    public void updateScore(){
        setImage(new GreenfootImage("P1 lives "+World1.mylives.getP1Lives(),30,greenfoot.Color.BLACK,greenfoot.Color.WHITE));
        }
}
