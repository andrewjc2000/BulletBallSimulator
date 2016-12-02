//File created by Andrew Chafos on 11/23/16 @ 11:23 PM

package bulletballsimulator.game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private double velocityX, velocityY;//pixels per second
    private double x, y;
    public final Hand h;
    
    public Ball(double initX, double initY, double vX, double vY){
        x = initX;
        y = initY;
        velocityX = vX;
        velocityY = vY;
        h = new Hand(500, 600);
    }
    
    public void changeVX(double newVX){
        velocityX = newVX;
    }
    
    public void changeVY(double newVY){
        velocityY = newVY;
    }
    
    public void move(double time){//in seconds
        int newX = (int)Math.round(x + (velocityX * time));
        int newY = (int)Math.round(y + (velocityY * time));
        int[] changeC = h.containsCoords((int)Math.round(x), (int)Math.round(y), newX, newY);
        if(changeC[0] != 0 || changeC[1] != 0){
            velocityX = 2 * h.getVelocityX();
            velocityY = 2 * h.getVelocityY();
            x += changeC[0];
            y += changeC[1];
        }
        else if(onWall()){
            velocityX *= -1;
            x += (velocityX * time);
            y += (velocityY * time);
        }
        else{
            x += (velocityX * time);
            y += (velocityY * time);
        }
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)Math.round(x - 20), (int)Math.round(y - 20), 40, 40);
    }
    
    public boolean onWall(){
        
        /*
            1] g.drawArc(185, 0, 650, 650, 130, 90);
            2] g.drawArc(165, 0, 650, 650, 50, -90);
            Center 1: 510, 325
            Center 2: 490, 325
            Radius: 325
        */
        if(x > 500){
            //arc 2
            if(y > 325){
                for(int i = 0;i <= 15;i++){
                    //5 degrees to -40 degrees
                    double arcX = 490 + 325 * Math.cos((Math.PI / 36) - ((i / 15.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((Math.PI / 36) - ((i / 15.0) * (Math.PI / 4)));
                    if(inBall(arcX, arcY)){
                        return true;
                    }
                }
            }
            else{
                for(int i = 0;i <= 15;i++){
                    //5 degrees to 50 degrees
                    double arcX = 490 + 325 * Math.cos((Math.PI / 36) - ((i / 15.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((Math.PI / 36) + ((i / 15.0) * (Math.PI / 4)));
                    if(inBall(arcX, arcY)){
                        return true;
                    }
                }
            }
        }
        else{
            //arc 1
            if(y > 325){
                for(int i = 0;i <= 15;i++){
                    //175 degrees to 220 degrees
                    double arcX = 490 + 325 * Math.cos((35 * Math.PI / 36) + ((i / 15.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((35 * Math.PI / 36) + ((i / 15.0) * (Math.PI / 4)));
                    if(inBall(arcX, arcY)){
                        return true;
                    }
                }
            }
            else{
                for(int i = 0;i <= 15;i++){
                    //175 degrees to 130 degrees
                    double arcX = 490 + 325 * Math.cos((35 * Math.PI / 36) - ((i / 15.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((35 * Math.PI / 36) - ((i / 15.0) * (Math.PI / 4)));
                    if(inBall(arcX, arcY)){
                        return true;
                    }
                }
            }
        }
        
        
        return false;
    }
    
    private boolean inBall(double x, double y){
        double val1 = Math.pow((y - this.y), 2);
        double val2 = Math.pow((x - this.x), 2);
        return val1 + val2 <= 10;
    }
}
