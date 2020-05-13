import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class StartScreen extends World{
    public StartScreen(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        GreenfootImage bg = new GreenfootImage(1000,800);
        bg.setColor(new Color(0,0,0));
        bg.fill();
        bg.setColor(new Color(200,60,200));
        bg.setFont(new Font("Arial",false,false,100));
        bg.drawString("Smash Balls",200,200);
        bg.setFont(new Font("Arial",false,false,50));
        bg.drawString("By,",200,350);
        bg.drawString("Harrison Collins,",200,450);
        bg.drawString("Nicholas Tann,",200,550);
        bg.drawString("Randall Davis",200,650);
        setBackground(bg); 
        addObject(new P1(),700,400);
        addObject(new P2(),800,400);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new World1());
        }
    }
}
