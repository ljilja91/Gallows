package gallows;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Ljiljana
 */
public class Frame extends JFrame
{
  
    public Frame(Font font)
    {
        this.setTitle("Gallows");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setType(Type.NORMAL);
        
        Dimension dimensionWindow = new Dimension(500, 400);
        
        this.setSize(500, 400);
        
        Toolkit tkDimension = Toolkit.getDefaultToolkit();
	Dimension dimensionScrean = tkDimension.getScreenSize();

	setLocation(dimensionScrean.width / 2 - dimensionWindow.width / 2,
				dimensionScrean.height / 2 - dimensionWindow.height / 2);
        
        this.pack();
        this.setVisible(true);
    }

   

}
