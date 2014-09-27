package Panels;

import Base.BaseClass;
import gallows.MenuBar;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ljiljana
 */
public class DownPanel
{
    private JPanel downPanel = new JPanel();
    private UpPanel upPanel;
    private BaseClass base;
    
    private MenuBar myMenuBar;
    
    private int numberOfMiss=0;
    
    public DownPanel(BaseClass base, UpPanel upPanel)
    {
        downPanel.setBackground(Color.yellow);
        downPanel.setMinimumSize(new Dimension(WIDTH, 160));
        downPanel.setPreferredSize(new Dimension(WIDTH, 160));
        
        createButtons();
        
        this.upPanel = upPanel;
        this.base = base;
    }

    /**
     * @return the downPanel
     */
    public JPanel getDownPanel() {
        return downPanel;
    }

    /**
     * @param downPanel the downPanel to set
     */
    public void setDownPanel(JPanel downPanel) {
        this.downPanel = downPanel;
    }
    
    public void letterClick(JButton button)
    {
        
    }

    public void createButtons()
    {
        
    }

    /**
     * @return the base
     */
    public BaseClass getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(BaseClass base) {
        this.base = base;
    }

    /**
     * @return the myMenuBar
     */
    public MenuBar getMyMenuBar() {
        return myMenuBar;
    }

    /**
     * @param myMenuBar the myMenuBar to set
     */
    public void setMyMenuBar(MenuBar myMenuBar) {
        this.myMenuBar = myMenuBar;
    }

    /**
     * @return the numberOfMiss
     */
    public int getNumberOfMiss() {
        return numberOfMiss;
    }

    /**
     * @param numberOfMiss the numberOfMiss to set
     */
    public void setNumberOfMiss(int numberOfMiss) {
        this.numberOfMiss = numberOfMiss;
    }
}
