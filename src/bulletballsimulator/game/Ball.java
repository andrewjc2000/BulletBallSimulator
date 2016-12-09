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
        if(onWall()){
            velocityX *= -1;
            velocityY *= -1;
            if(velocityX == 0 && velocityY == 0){
                //put coordinate of wall here minus radius of ball
            }
            x += 3 * (velocityX * time);
            y += 3 * (velocityY * time);
        }
        else if(x <= 0 || x >= 1000 || y <= 0 || y >= 650){
            velocityX *= -1;
            velocityY *= -1;
            if(x <= 0){
                x = 1;
            }
            if(x >= 1000){
                x = 999;
            }
            if(y <= 0){
                y = 1;
            }
            if(y >= 650){
                y = 649;
            }
        }
        else if(changeC[0] != 0 || changeC[1] != 0){
            velocityX = 2 * h.getVelocityX();
            velocityY = 2 * h.getVelocityY();
            x += changeC[0];
            y += changeC[1];
        }
        else{
            x += (velocityX * time);
            y += (velocityY * time);
        }
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)Math.round(x - 20), (int)Math.round(y - 20), 40, 40);
        
        double theta = (velocityX != 0) ? Math.atan(velocityY / velocityX) + ((velocityX < 0) ? Math.PI : 0)
                : (velocityY > 0) ? Math.PI / 2: 3 * Math.PI / 2;
        
        if(velocityX < 0 && velocityY == 0){
            theta = Math.PI;
        }
        
        g.setColor(Color.blue);
        g.fillRect((int)Math.round(x + 20 * Math.cos(theta)), (int)Math.round(y + 20 * Math.sin(theta)), 2, 2);
        
        if(x > 500){
            //arc 2
            if(y < 343){
                for(int i = 0;i <= 30;i++){
                    //5 degrees to -40 degrees
                    double arcX = 470 + 325 * Math.cos((Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    g.fillRect((int) Math.round(arcX), (int)Math.round(arcY), 3, 3);
                }
            }
            else{
                for(int i = 0;i <= 30;i++){
                    //5 degrees to 50 degrees
                    double arcX = 470 + 325 * Math.cos((Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((Math.PI / 36) + ((i / 30.0) * (Math.PI / 4)));
                    g.fillRect((int) Math.round(arcX), (int)Math.round(arcY), 3, 3);
                }
            }
        }
        else{
            //arc 1
            if(y < 343){
                for(int i = 0;i <= 60;i++){
                    //175 degrees to 220 degrees
                    double arcX = 510 + 325 * Math.cos((28 * Math.PI / 36) + ((i / 60.0) * (0.50208333333 * Math.PI)));//14.5 * pi / 48 + (pi / 4)
                    double arcY = 325 + 325 * Math.sin((28 * Math.PI / 36) + ((i / 60.0) * (0.50208333333 * Math.PI)));
                    g.fillRect((int) Math.round(arcX), (int)Math.round(arcY), 3, 3);
                }
            }
            else{
                for(int i = 0;i <= 30;i++){
                    //175 degrees to 130 degrees
                    double arcX = 510 + 325 * Math.cos((35 * Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((35 * Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    g.fillRect((int) Math.round(arcX), (int)Math.round(arcY), 3, 3);
                }
            }
        }
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
            if(y < 343){
                for(int i = 0;i <= 30;i++){
                    //5 degrees to -40 degrees
                    double arcX = 470 + 325 * Math.cos((Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    if(inBall(arcX, arcY)){
                        return true;
                    }
                }
            }
            else{
                for(int i = 0;i <= 30;i++){
                    //5 degrees to 50 degrees
                    double arcX = 470 + 325 * Math.cos((Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((Math.PI / 36) + ((i / 30.0) * (Math.PI / 4)));
                    if(inBall(arcX, arcY)){
                        return true;
                    }
                }
            }
        }
        else{
            //arc 1
            if(y < 343){
                for(int i = 0;i <= 30;i++){
                    //175 degrees to 220 degrees
                    double arcX = 510 + 325 * Math.cos((35 * Math.PI / 36) + ((i / 30.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((35 * Math.PI / 36) + ((i / 30.0) * (Math.PI / 4)));
                    if(inBall(arcX, arcY)){
                        return true;
                    }
                }
            }
            else{
                for(int i = 0;i <= 30;i++){
                    //175 degrees to 130 degrees
                    double arcX = 510 + 325 * Math.cos((35 * Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    double arcY = 325 + 325 * Math.sin((35 * Math.PI / 36) - ((i / 30.0) * (Math.PI / 4)));
                    if(inBall(arcX, arcY)){
                        return true;
                    }
                }
            }
        }
        
        
        return false;
    }
    
    public boolean inBall(double x, double y){
        double val1 = Math.pow((y - this.y), 2);
        double val2 = Math.pow((x - this.x), 2);
        return val1 + val2 <= 100;
    }
}
