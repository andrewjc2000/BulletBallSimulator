//File created by Andrew Chafos on 11/16/16 @ 12:50 PM
package bulletballsimulator;

import bulletballsimulator.game.MainGame;
import bulletballsimulator.menu.MainMenu;
import container.*;
import graphics.util.*;
import java.awt.Color;
import java.awt.Cursor;
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
        BufferedImage marcFloor = null;
        try{
        URL resource1 = main.Launcher.class.getClassLoader()
                .getResource("bulletballsimulator/resources/background.jpg");
        background = ImageIO.read(resource1);
        URL resource2 = main.Launcher.class.getClassLoader()
                .getResource("bulletballsimulator/resources/MarcGriffinFloor.jpg");
        marcFloor = ImageIO.read(resource2);
        }
        catch(IOException e){System.out.println("Error: Could not locate image file.");}
        
        bulletballsimulator.Globals.menuBG = new graphics.util.Image(background, 1000, 650, 0, 0);
        bulletballsimulator.Globals.gameFloor = new graphics.util.Image(marcFloor, 1000, 650, 0, 0);
        
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
        bulletballsimulator.Globals.game = new MainGame();
        Globals.mainFrame = new Frame("BulletBall Simulator", bulletballsimulator.Globals.menu);
        Globals.mainFrame.setup();
        Globals.mainFrame.addMouseListener(menuButtons.get(0));
        Globals.mainFrame.addMouseListener(menuButtons.get(1));
        Globals.mainFrame.addMouseMotionListener(menuButtons.get(0));
        Globals.mainFrame.addMouseMotionListener(menuButtons.get(1));
        Globals.mainFrame.start();
        while(!bulletballsimulator.Globals.menu.getTerminating()){System.out.print("");}
        Globals.mainFrame.removeMouseListener(menuButtons.get(0));
        Globals.mainFrame.removeMouseListener(menuButtons.get(1));
        Globals.mainFrame.removeMouseMotionListener(menuButtons.get(0));
        Globals.mainFrame.removeMouseMotionListener(menuButtons.get(1));
        bulletballsimulator.Globals.initTime = System.currentTimeMillis();
        Globals.mainFrame.addMouseMotionListener(bulletballsimulator.Globals.game.h);
        Globals.mainFrame.contain.switchAspect(bulletballsimulator.Globals.game);
        Globals.mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
}
