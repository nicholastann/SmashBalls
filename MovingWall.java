import greenfoot.*;  
public class MovingWall extends Obstacle{  
    int vSpeed = 1;
    public void act() {
       if(getY()>500){
           vSpeed = -1;
        }
       if(getY()<350){
           vSpeed = 1;
        }
       setLocation(getX(), getY() + vSpeed);
    }    
}
