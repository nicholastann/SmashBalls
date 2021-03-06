import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class bluespike extends Actor
{
    private int x;
    int timer = 0;
    boolean first = true;
     GreenfootSound hit = new GreenfootSound("MMX_stomp3.wav");
    public bluespike(int rotate) {
        if (rotate == 0) {turn(270);};
        if (rotate == 1) {turn(180);};
        if (rotate == 2) {turn(90);}
        if (rotate == 3) {}
        x = rotate;
    }
    public void act() 
    {
        timer++;
       if (x == 0) {
           setLocation(World1.p2.getX(),World1.p2.getY()-20);
        }
        if (x == 1) {
             setLocation(World1.p2.getX()-20,World1.p2.getY());
        }
        if (x == 2) {
             setLocation(World1.p2.getX(),World1.p2.getY()+20);
        }
        if (x == 3) {
             setLocation(World1.p2.getX()+20,World1.p2.getY());
        }
        Actor i = getOneIntersectingObject(P1.class);
        if ( i!= null) {
            if (first) {
                World1.percent1.addPercent(10);
                hit.play();
                if (getX()<i.getX()) {
                    World1.p1.hit(true);
                }
                else {
                    World1.p1.hit(false);
                }
                first = false;
            }
        }
        if (timer > 20) {
            getWorld().removeObject(this);
        }
        
    }    
    
}
