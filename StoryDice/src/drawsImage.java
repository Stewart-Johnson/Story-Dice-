import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class drawsImage extends JPanel
{
    private static final long serialVersionUID = 1L;
    private BufferedImage image;

 
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