package gallows;

import Base.BaseClass;
import Panels.DownPanel;
import Panels.UpPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MenuBar;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Ljiljana
 */
public class Frame extends JFrame
{
    private DownPanel downPanel;
    private UpPanel upPanel;
    
    private MenuBar meni;
    private JPanel mainPanel;
    private Font customFont = null;
    private BaseClass base;
    
    
    public Frame(Font font)
    {
        this.customFont = font;
        this.frameSettings();
    }
    
    private void frameSettings() 
    {
        this.setTitle("Gallows");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setType(Type.NORMAL);
        
        Dimension dimensionWindow = new Dimension(500, 400);
        
        this.setSize(mainPanel.getWidth(), mainPanel.getHeight());
        
        Toolkit tkDimension = Toolkit.getDefaultToolkit();
	Dimension dimensionScrean = tkDimension.getScreenSize();

	setLocation(dimensionScrean.width / 2 - dimensionWindow.width / 2,
				dimensionScrean.height / 2 - dimensionWindow.height / 2);
        
        this.pack();
        this.setIconImage(new ImageIcon("src/Content/Images/gallowss.png").getImage());
        this.setVisible(true);
    }

   

}
