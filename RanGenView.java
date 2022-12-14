package GraphicsProject;
/**
 * This program outputs a Smiley Face canvas and asks the user questions
 * 
 * @author Vy Nguyen
 * @version 1
 */

import javax.swing.JFrame; //this is the window
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JComponent; // generic predefined attribute
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;


public class RanGenView extends JFrame {
    
    private int parsedNum;
    private int colorAnswer; // 0 = yes, 1 = no
    private String username;
  
    private final String GREETING = "   Welcome to Graphics Manager\n" + "Customize your own smiley face 😃";
    private final String PICK_COLOR = "Do you want random colors? \nDefault colors are used if you choose \"No\"";
    private final String PICK_RANGE = "Please enter a number between 10-250 \nas a range of randomization:";
    private final String PICK_USERNAME = "Please enter a name:";

    /**
     * These are custom colors.
     */
    
    Color blue1 = new Color(94, 132, 162);
    Color blue2 = new Color(182, 208, 225);
    Color blue3 = new Color(202, 223, 237);
    Color blue4 = new Color(220, 235, 244);
    Color mySoftYellow = new Color(222, 186, 71);
    Color myDarkBlue = new Color (11, 17, 32);
    Color userCustomColor;

    /**
     * Constructor calls the modal and draw methods.
     */
    
    public RanGenView() {
        modal();
        draw();
    }

    /**
     * This method creates a Panel to store the smiley face.
     */
    
    public void draw() {
        JPanel panel = new JPanel();
        JComponent component = new HappyFaceComponent();
        component.setPreferredSize(new Dimension(600,600));
        panel.add(component);
        add(panel);
        
        setTitle("HEY " + username.toUpperCase() + "!");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This method gets the username.
     */
    
    public String getUsername() { 
        return username;
    }

    /**
     * This method gets the yes (0) or no (1) answer whether user wants custom color or not.
     * @return colorAnswer 0 or 1
     */
    
    public int getColorAnswer() {
        return colorAnswer;
    }

    /**
     * This method returns the range between 10 - 250.
     * @return range
     */
    
    public int getRange() {
        return parsedNum;
    }

    /**
     * This method creates a new color and repaint the canvas.
     * @param r a randomly generated number
     * @param g a randomly generated number
     * @param b a randomly generated number
     */
    
    public void updateCanvas(int r, int g, int b) {
        System.out.print("\n⭐️ New RBG: " + r + " " + g + " " + b + " ⭐️");
        userCustomColor = new Color(r,g,b);
        repaint();
    }
    
    /**
     * This method asks the user questions.
     */
    public void modal() {
        
        JOptionPane.showMessageDialog(null, GREETING);
        
        username = JOptionPane.showInputDialog(null, PICK_USERNAME);
        colorAnswer = JOptionPane.showConfirmDialog(null, PICK_COLOR, "Click Yes or No", JOptionPane.YES_NO_OPTION);
        
        if (colorAnswer == JOptionPane.YES_OPTION) {
            parsedNum = Integer.parseInt(JOptionPane.showInputDialog(null,PICK_RANGE));
            
            if (parsedNum < 10 || parsedNum > 250) {
                JOptionPane.showMessageDialog(null, "Sorry, between 10-250 only!");
                parsedNum = Integer.parseInt(JOptionPane.showInputDialog(null,PICK_RANGE));
            }

        } else {
            userCustomColor = mySoftYellow;
        }
        
        
    }
    
    /**
     * This class creates the drawing of the smiley face.
     */
    class HappyFaceComponent extends JComponent {

        /**
         * This method creates the drawing.
         * @param canvas allows you to call methods from the Graphics object
         */
        public void paintComponent(Graphics canvas) {
            //background
            canvas.setColor(myDarkBlue);
            canvas.fillRect(0,0 ,600 ,600 );
            
            //draw background for greeting
            canvas.setColor(blue1); 
            canvas.drawString("HELLURR! HERE'S YOUR CUSTOM SMILEY FACE",165, 128); //greeting
            
            //face drawing
            canvas.setColor(userCustomColor);
            canvas.fillOval(200, 200, 200, 200); //head
            canvas.setColor(Color.BLACK);
            canvas.fillOval(255, 260, 10, 20); //right eye
            canvas.fillOval(335,260, 10, 20); //left eye
            canvas.drawArc(250, 310, 100, 50, 180, 180); //smile
        }

    }
    
}
