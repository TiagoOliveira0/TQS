package ui;

import euromillions.CuponEuromillions;
import euromillions.Dip;
import euromillions.EuromillionsDraw;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoMain {

    /**
     * demonstrates a client for ramdom euromillions bets
     */
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(DemoMain.class.getName());

        // played sheet
        CuponEuromillions thisWeek = new CuponEuromillions();
        logger.log(Level.INFO, "Betting with three random bets...");
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());

        // simulate a random draw
        EuromillionsDraw draw = EuromillionsDraw.generateRandomDraw();

        //report results
        logger.log(Level.INFO,"You played");
        String s = thisWeek.format();
        logger.log(Level.INFO, s);

        logger.log(Level.INFO,"Draw results:");

        s = draw.getDrawResults().format();
        logger.log(Level.INFO,s);


        logger.log(Level.INFO,"Your score:");



        for (Dip dip : draw.findMatches(thisWeek)) {
            s=dip.format();
            logger.log(Level.INFO,s);

        }
    }
}
