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
        if(changeC[0] != 0 && changeC[1] != 0){
            velocityX = 2 * h.getVelocityX();
            velocityY = 2 * h.getVelocityY();
            x += changeC[0];
            y += changeC[1];
        }
        x += (velocityX * time);
        y += (velocityY * time);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)Math.round(x - 20), (int)Math.round(y - 20), 40, 40);
    }
}
