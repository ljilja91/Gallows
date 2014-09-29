package Panels;

import Base.BaseClass;
import gallows.MenuBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ljiljana
 */
public class DownPanel
{
    private JPanel downPanel = new JPanel();
    private UpPanel upPanel;
    private MenuBar myMenuBar;
    private BaseClass base;
    private String regex = "[^ ]";
    
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
        button.setVisible(false);
        
        if(getBase().getWord().contains(button.getText()))
        {
            setRegex(getRegex().substring(0, getRegex().length() - 1));
            setRegex(getRegex() + ",^" + button.getText() + "]");
            
            String testString = getBase().getWord();
            testString = testString.replaceAll(getRegex(), "?");
            
            this.upPanel.setWord(testString);
        }
        else
        {
            int misses = this.getNumberOfMiss();
            this.setNumberOfMiss(++misses);
            
            switch(this.getNumberOfMiss()) 
            {
                case 1:
                {
                    this.upPanel.setImage("src/Content/Stickman/image1.png");
                    break;
                }
                case 2:
                {
                    this.upPanel.setImage("src/Content/Stickman/image2.png");
                    break;
                }
                case 3:
                {
                    this.upPanel.setImage("src/Content/Stickman/image3.png");
                    break;
                }
                case 4:
                {
                    this.upPanel.setImage("src/Content/Stickman/image4.png");
                    break;
                }
                case 5:
                {
                    this.upPanel.setImage("src/Content/Stickman/image5.png");
                    break;
                }
                case 6:
                {
                    this.upPanel.setWord(this.base.getWord());
                    
                    this.upPanel.setImage("src/Content/Stickman/image6.png");
                    JLabel lblWIn = new JLabel("Ooooh, You Lose!!!");
                    lblWIn.setForeground(Color.magenta);
                    lblWIn.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
                    
                    ImageIcon icon = new ImageIcon("src/Content/Images/loseGame.png");
                    
                    Object buttonArray[] = {"New game", "EXIT"};
        
                    int response = JOptionPane.showOptionDialog(null, lblWIn, "Gallows", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                    icon, buttonArray, buttonArray[0]);
                    
                    if(response == JOptionPane.YES_OPTION)
                    {
                        this.myMenuBar.newGameClicked();
                        return;
                    }
                    else
                    {
                        System.exit(0);
                    }
                    
                    break;
                }
            }
        }
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
     * @return the regex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * @param regex the regex to set
     */
    public void setRegex(String regex) {
        this.regex = regex;
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
