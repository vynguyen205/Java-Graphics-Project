package GraphicsProject;
/**
 * This is programs tests Smiley face drawing.
 * 
 * @author Vy Nguyen
 * @version 1
 */

public class RanGenDemo {

    public static void main(String[] args) {
        
        RanGenView view = new RanGenView();
        String username = view.getUsername();
        int range = view.getRange();
        int yesOrNo = view.getColorAnswer();

        RanGen user1 = new RanGen(username, range);
        int r = user1.randomizeNum();
        int g = user1.randomizeNum();
        int b = user1.randomizeNum();

        if (yesOrNo == 0) {
            view.updateCanvas(r, g, b);
        }
        
    }
}
