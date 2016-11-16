//File created by Andrew Chafos on 11/16/16 @ 12:50 PM
package bulletballsimulator;

import bulletballsimulator.menu.MainMenu;
import container.*;
import graphics.util.*;
import java.util.ArrayList;
import main.Globals;

public class BulletBallSimulator {

    public static void main(String[] args) {
        bulletballsimulator.Globals.menu = new MainMenu(new ArrayList<>(), new ArrayList<>());
        Globals.mainFrame = new Frame("BulletBall Simulator", bulletballsimulator.Globals.menu);
        Globals.mainFrame.setup();
        Globals.mainFrame.start();
    }
    
}
