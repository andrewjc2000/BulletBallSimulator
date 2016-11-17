//File created by Andrew Chafos on 11/16/16 @ 12:50 PM
package bulletballsimulator;

import bulletballsimulator.menu.MainMenu;
import container.*;
import graphics.util.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import main.Globals;

public class BulletBallSimulator {

    public static void main(String[] args) {
        BufferedImage background = null;
        try{
        URL resource1 = main.Launcher.class.getClassLoader()
                .getResource("bulletballsimulator/resources/background.jpg");
        background = ImageIO.read(resource1);
        }
        catch(IOException e){System.out.println("Error: Could not locate image file.");}
        
        bulletballsimulator.Globals.menuBG = new graphics.util.Image(background, 1000, 650, 0, 0);
        
        ArrayList<graphics.util.Button> menuButtons = new ArrayList<>();
        menuButtons.add(
            new graphics.util.Button(
                350, 250, 300, 40, Color.blue,  new ArrayList<>(Arrays.asList("Start Game")), "Monospaced", Color.white, 20
            )
        );
        menuButtons.add(
            new graphics.util.Button(
                350, 400, 300, 40, Color.blue,  new ArrayList<>(Arrays.asList("Quit Game")), "Monospaced", Color.white, 20
            )
        );
        bulletballsimulator.Globals.menu = new MainMenu(new ArrayList<>(), menuButtons);
        Globals.mainFrame = new Frame("BulletBall Simulator", bulletballsimulator.Globals.menu);
        Globals.mainFrame.setup();
        Globals.mainFrame.start();
    }
    
}
