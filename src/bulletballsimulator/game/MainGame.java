//File created by Andrew Chafos on 11/21/16 @ 12:41 PM
package bulletballsimulator.game;

import container.Aspect;
import graphics.util.Button;
import java.awt.Color;
import java.awt.Graphics;
//import container.SubAspect;
import java.util.ArrayList;

public class MainGame extends Aspect {
    
    final Color tableColor;
    
    public MainGame() {
        super(new ArrayList<>());
        tableColor = new Color(167,128,95);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,1000,650);
        //table color == (167,128,95)
        g.setColor(tableColor);
        g.fillOval(175, 0, 650, 650);
    }
    
    protected void updateObjects(){
        super.updateObjects();
    }
    
}
