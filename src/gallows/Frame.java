package gallows;

import Base.BaseClass;
import Panels.DownPanel;
import Panels.UpPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
    private BaseClass base;
    
    
    public Frame()
    {
        base = new BaseClass();
        
        createLeftUpPanel();
        
        createDownPanel();
        
        meni = new MenuBar(upPanel, downPanel);
        
        this.upPanel.setMyMenubar(meni);
        
        createMainPanel(); 
        
        this.setJMenuBar(meni.getMeniBar());
        
        this.add(mainPanel);
        
        frameSettings();
    }
    
    private void createDownPanel() 
    {
        downPanel = new DownPanel(base, this.upPanel);
    }

    private void createLeftUpPanel() 
    {
        upPanel = new UpPanel(base);
    }

    private void createMainPanel() 
    {
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(700, 550));
        mainPanel.setLayout(new BorderLayout(5,5));
        mainPanel.add(this.upPanel.getPanel(), BorderLayout.CENTER);
        mainPanel.add(this.downPanel.getDownPanel(), BorderLayout.SOUTH);
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
