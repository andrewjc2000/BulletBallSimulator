//File created by Andrew Chafos on 11/6/16 @ 4:55 PM

package bulletballsimulator.menu;

import container.Aspect;
import container.SubAspect;
import graphics.util.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import main.Globals;

public class MainMenu extends Aspect {
    
    ArrayList<graphics.util.Button> buttons;
    BufferedImage mahpoint;
    
    public MainMenu(ArrayList<SubAspect> subAspects, ArrayList<graphics.util.Button> buttons) {
        super(subAspects);/*
        try{
        URL resource1 = main.Launcher.class.getClassLoader()
                .getResource("main/resources/mahpoint.jpg");
        mahpoint = ImageIO.read(resource1);
        }
        catch(IOException e){System.out.println("Error: Could ");}*/
        this.buttons = buttons;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(0,0, Globals.contentWidth, Globals.contentHeight);
        for(Button b: buttons){
            b.draw(g);
        }
    }
    
    protected void updateObjects(){
        super.updateObjects();
    }
    
}
