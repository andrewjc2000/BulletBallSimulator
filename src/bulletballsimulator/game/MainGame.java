//File created by Andrew Chafos on 11/21/16 @ 12:41 PM
package bulletballsimulator.game;

import container.Aspect;
import graphics.util.Button;
import java.awt.Color;
import java.awt.Graphics;
//import container.SubAspect;
import java.util.ArrayList;

public class MainGame extends Aspect {
    
    final Color tableColor, tableOutline;
    
    public MainGame() {
        super(new ArrayList<>());
        tableColor = new Color(167,128,95);
        tableOutline = new Color(139,69,19);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bulletballsimulator.Globals.gameFloor.draw(g);
        //table color == (167,128,95)
        
        //drawing the table
        g.setColor(tableColor);
        g.fillOval(175, 0, 650, 650);
        g.setColor(tableOutline);
        g.drawOval(175, 0, 650, 650);
        g.drawOval(275, 100, 450, 450);
        //top & bottom lines
        g.drawLine(450, 645, 450, 545);
        g.drawLine(550, 645, 550, 545);
        g.drawLine(450, 5, 450, 105);
        g.drawLine(550, 5, 550, 105);
        //left & right lines
        g.drawLine(180, 275, 280, 275);
        g.drawLine(180, 375, 280, 375);
        g.drawLine(720, 275, 820, 275);
        g.drawLine(720, 375, 820, 375);

    }
    
    protected void updateObjects(){
        super.updateObjects();
    }
    
}
