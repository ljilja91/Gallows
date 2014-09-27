package Panels;

import Base.BaseClass;
import gallows.MenuBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        char letter = 'A';
        JButton dugme;
        for (int i = 1; i <= 26; i++) 
        {
            dugme = new JButton(String.valueOf(letter++));
            dugme.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
            dugme.setBackground(Color.GREEN);
            this.downPanel.add(dugme);
            
            dugme.addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent e) 
                {
                    letterClick((JButton)e.getSource());
                }
            });
        }
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
