import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Percent1 extends Actor{
    private int percent1;
    public void act() {
        // Add your action code here.
    }    
    public Percent1(){
        percent1 = 0;
        setImage(new GreenfootImage(percent1+" % ",30,Color.BLACK,Color.WHITE));
    }
    public void updatePercent(){
        setImage(new GreenfootImage(percent1+" % ",30,Color.BLACK,Color.WHITE));
    }
    public void addPercent(int n){
        percent1+=n;
        this.updatePercent();
    }
    public int getPercent(){
        return percent1;
    }
    
    public void resetpercent() {
        percent1 = 0;
        this.updatePercent();
    }
}
