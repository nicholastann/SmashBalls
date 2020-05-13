import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WinScreen extends World{
    public WinScreen(int n){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,800,1); 
        GreenfootImage bg = new GreenfootImage(1000,800);
        bg.setColor(new Color(0,0,0));
        bg.fill();
        bg.setColor(new Color(200,60,200));
        bg.setFont(new Font("Arial",false,false,100));
        bg.drawString("Winner",200,200);
        bg.setFont(new Font("Arial",false,false,50));
        if(n==1){
            bg.drawString("P2 wins",200,350);
        }
        else{
            bg.drawString("P1 wins",200,350);
        }
        
        
        
        setBackground(bg); 
    }
}
