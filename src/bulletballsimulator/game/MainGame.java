//File created by Andrew Chafos on 11/21/16 @ 12:41 PM
package bulletballsimulator.game;

import container.Aspect;
import graphics.util.Button;
import java.awt.Color;
import java.awt.Graphics;
//import container.SubAspect;
import java.util.ArrayList;

public class MainGame extends Aspect {
    
    public MainGame() {
        super(new ArrayList<>());
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(0, 0, 1000, 650);
    }
    
}
