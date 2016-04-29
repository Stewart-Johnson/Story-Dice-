import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*; 
/** 
 * drawsImage sets an image to be used in the Main GUI
 * 
 * @author Ryan Gonzales
 * 
 * @version April 29, 2016
 * 
 */

public class drawsImage extends JPanel
{
    private static final long serialVersionUID = 1L;
    private BufferedImage image;
    
    /**
     * Constructor creates the image
     * @parameter a string from the roll with the file location for the image to be drawn
     */
    public drawsImage(String imageStr) 
    {
        try 
        {
             //Load the image
            image = ImageIO.read(new File(imageStr));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    } 
    /**
    * Simple paint component using image from constructor 
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
                                //Paint it on screen
        g2d.drawImage(image, 0, 0, this);
        g2d.dispose();
    }
 
 
}
