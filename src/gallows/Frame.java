package gallows;

import Base.BaseClass;
import Panels.DownPanel;
import Panels.UpPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
    
    /**
     * Osnovni konstruktor koji se koristi pri inicijalizaciji kompletnog frame-a.
     * Redom se kreiraju sljedeci objekti:
     * @see #base
     * @see #upPanel
     * @see #downPanel
     * @see #meni
     */
    public Frame()
    {
        base = new BaseClass();
        
        createUpPanel();
        
        createDownPanel();
        
        meni = new MenuBar(upPanel, downPanel);
        
        this.upPanel.setMyMenubar(meni);
        
        this.downPanel.setMyMenuBar(meni);
        
        createMainPanel(); 
        
        this.setJMenuBar(meni.getMeniBar());
        
        this.add(mainPanel);
        
        frameSettings();
    }
    
    /**
     * Funkcija kreira donji panel i poziva konstruktor
     * @see DownPanel#DownPanel(Base.BaseClass, Panels.UpPanel) 
     */
    private void createDownPanel() 
    {
        downPanel = new DownPanel(base, this.upPanel);
    }

    /**
     * Funkcija kreira gornji panel i poziva konstruktor
     * @see UpPanel#UpPanel(Base.BaseClass) 
     */
    private void createUpPanel() 
    {
        upPanel = new UpPanel(base);
    }

    /**
     * Funkcija kreira glavni panel koji sadrzi
     * @see #upPanel i
     * @see #downPanel
     */
    private void createMainPanel() 
    {
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(700, 550));
        mainPanel.setLayout(new BorderLayout(5,5));
        mainPanel.add(this.upPanel.getPanel(), BorderLayout.CENTER);
        mainPanel.add(this.downPanel.getDownPanel(), BorderLayout.SOUTH);
    }
    
    /**
     * Funkcija postavlja osnovna podešavanja u vezi prozora.
     */
    private void frameSettings() 
    {
        this.setTitle("Gallows");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        /*
        Dozvoljavaju se sve komande nad prozorom, smanjivanje, maksimiziranje i isključivanje.
        */
        this.setType(Type.NORMAL);
        
        Dimension dimensionWindow = new Dimension(700, 550);
        
        this.setSize(mainPanel.getWidth(), mainPanel.getHeight());
        
        Toolkit tkDimension = Toolkit.getDefaultToolkit();
	Dimension dimensionScrean = tkDimension.getScreenSize();

	setLocation(dimensionScrean.width / 2 - dimensionWindow.width / 2,
				dimensionScrean.height / 2 - dimensionWindow.height / 2);
        
        this.pack();
        /*
        Postavljanje ikonice.
        */
        this.setIconImage(new ImageIcon("src/Content/Images/gallowss.png").getImage());
        this.setVisible(true);
    }

   

}
