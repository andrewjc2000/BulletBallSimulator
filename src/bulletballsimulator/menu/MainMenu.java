//File created by Andrew Chafos on 11/6/16 @ 4:55 PM

package bulletballsimulator.menu;

import container.Aspect;
import container.SubAspect;
import graphics.util.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import main.Globals;

public class MainMenu extends Aspect {
    
    private final ArrayList<graphics.util.Button> buttons;
    private final Font font;
    
    public MainMenu(ArrayList<SubAspect> subAspects, ArrayList<graphics.util.Button> buttons) {
        super(subAspects);/*
        try{
        URL resource1 = main.Launcher.class.getClassLoader()
                .getResource("main/resources/mahpoint.jpg");
        mahpoint = ImageIO.read(resource1);
        }
        catch(IOException e){System.out.println("Error: Could ");}*/
        this.buttons = buttons;
        font = new Font("Monospaced", Font.BOLD, 74);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bulletballsimulator.Globals.menuBG.draw(g);
        for(Button b: buttons){
            b.draw(g);
        }
        g.setColor(Color.yellow);
        g.setFont(font);
        g.drawString("BulletBall Simulator", 50, 150);
    }
    
    protected void updateObjects(){
        super.updateObjects();
    }
    
}
