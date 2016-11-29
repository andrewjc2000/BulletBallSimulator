//File created by Andrew Chafos on 11/26/16 @ 2:48 PM

package bulletballsimulator.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Hand implements MouseMotionListener {
    //velocity of ball is 2 * velocity of hand
    
    private final ArrayList<long[]> handPositions;
    private int currentX, currentY;
    
    public Hand(int initX, int initY){
        currentX = initX;
        currentY = initY;
        handPositions = new ArrayList<>();
    }
    
    public void updatePos(int newX, int newY){
        long tempArr[] = {newX, newY, System.currentTimeMillis()};
        handPositions.add(tempArr);
        if(handPositions.size() >= 50){
            handPositions.remove(0);
        }
        currentX = newX;
        currentY = newY;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(currentX - 50, currentY, 100, 20);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        updatePos(e.getX(), e.getY() - 25);
    }
    
    public int[] containsCoords(int cX, int cY, int newX, int newY){
        if(cX + 20 >= currentX - 50 && cX - 20 <= currentX + 50){
            if(cY + 20 >= currentY && cY - 20 <= currentY + 20){
                int changeC[] = {0,0};
                //if the ball is exactly at the corners
                if(cX == cY - 60 && cY == currentY - 10){
                    changeC[0] = -1;
                    changeC[1] = -1;
                    return changeC;
                }
                if(cX == cY - 60 && cY == currentY + 30){
                    changeC[0] = -1;
                    changeC[1] = 1;
                    return changeC;
                }
                if(cX == cY + 60 && cY == currentY - 10){
                    changeC[0] = 1;
                    changeC[1] = -1;
                    return changeC;
                }
                if(cX == cY - 60 && cY == currentY + 30){
                    changeC[0] = 1;
                    changeC[1] = 1;
                    return changeC;
                }
                //everything else
                
                if(cY <= currentY){
                    if(cX >= currentX - 50 && cX <= currentX + 50){
                        changeC[1] = currentY - (cY + 10);
                        if(changeC[1] == 0){
                            changeC[1] = -1;
                            return changeC;
                        }
                    }
                    else if(cX < currentX - 50){
                        changeC[0] = currentX - 50 - (cX + 10);
                        if(changeC[0] == 0){
                            changeC[0] = -1;
                            return changeC;
                        }
                    }
                    else if(cX > currentX + 50){
                        changeC[0] = currentX + 50 - (cX + 10);
                        if(changeC[0] == 0){
                            changeC[0] = 1;
                            return changeC;
                        }
                    }
                }
                else{
                    if(cX >= currentX - 50 && cX <= currentX + 50){
                        changeC[1] = currentY + 10 - cY;
                        if(changeC[1] == 0){
                            changeC[1] = 1;
                            return changeC;
                        }
                    }
                    else if(cX < currentX - 50){
                        changeC[0] = currentX - 50 - (cX + 10);
                        if(changeC[0] == 0){
                            changeC[0] = -1;
                            return changeC;
                        }
                    }
                    else if(cX > currentX + 50){
                        changeC[0] = currentX + 50 - (cX + 10);
                        if(changeC[0] == 0){
                            changeC[0] = 1;
                            return changeC;
                        }
                    }
                }
                
                changeC[0] *= -1;
                changeC[1] *= -1;
                System.out.println(changeC[0] + " " + changeC[1]);
                return changeC;
            }
        }
        /*
        if((cX - 20 <= currentX - 50 && newX + 20 >= currentX + 50) || 
           (cX + 20 >= currentX + 50 && newX - 20 <= currentX - 50)    
        ){
            if(
                (cY - 20 <= currentY && newY + 20 >= currentY + 20) ||
                (cY  + 20 >= currentY + 20 && newY - 20 <= currentY)    
            ){
                int newC[] = new int[2];
                newC[0] = currentX;
                newC[1] = currentY - 21;
                return newC;
            }
        }*/
        int c[] = {0,0};
        return c;
    }
    
    public double getVelocityX(){
        if(handPositions.size() <= 2){
            return 0;
        }
        else {
            if((System.currentTimeMillis() - handPositions.get(handPositions.size() - 1)[2]) < 1000){
                return 1000 * (handPositions.get(handPositions.size() - 1)[0] - 
                        handPositions.get(handPositions.size() - 3)[0])
                    / (handPositions.get(handPositions.size() - 1)[2] - 
                        handPositions.get(handPositions.size() - 3)[2]);
            }
        }
        return 0;
    }
    
    public double getVelocityY(){
        if(handPositions.size() <= 2){
            return 0;
        }
        else {
            if((System.currentTimeMillis() - handPositions.get(handPositions.size() - 1)[2]) < 1000){
                return 1000 * (handPositions.get(handPositions.size() - 1)[1] - 
                        handPositions.get(handPositions.size() - 3)[1]) * 1.0
                    / (handPositions.get(handPositions.size() - 1)[2] - 
                        handPositions.get(handPositions.size() - 3)[2]);
            }
        }
        return 0;
    }
    
}
