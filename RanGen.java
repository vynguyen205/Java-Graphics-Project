package GraphicsProject;
/**
 * This program generates a random number.
 * 
 * @author Vy Nguyen
 * @version 1
 */

import java.util.Random;

public class RanGen {
    
    private String username;
    private int randomRange;

    /**
     * Constructor that takes in username and range
     * @param name username
     * @param range number user picked
     */
    public RanGen(String name, int range) {
        this.username = name;
        this.randomRange = range;
    }

    /**
     * This method returns a random number.
     * @return a random number
     */
    
    public int randomizeNum() {
        Random randoObject = new Random();
        return randoObject.nextInt(randomRange);
    }

    
}

