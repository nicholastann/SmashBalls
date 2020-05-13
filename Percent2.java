import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Percent2 extends Actor{
    private int percent2;
    public void act() {
        // Add your action code here.
    }    
    public Percent2(){
        percent2 = 0;
        setImage(new GreenfootImage(percent2+" % ",30,Color.BLACK,Color.WHITE));
    }
    public void updatePercent(){
        setImage(new GreenfootImage(percent2+" % ",30,Color.BLACK,Color.WHITE));
    }
    public void addPercent(int n){
        percent2+=n;
        this.updatePercent();
    }
    public int getPercent(){
        return percent2;
    }
    
    public void resetpercent() {
        percent2 = 0;
        this.updatePercent();
    }
}
