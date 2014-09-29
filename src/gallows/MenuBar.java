package gallows;

import Base.BaseClass;
import Panels.DownPanel;
import Panels.UpPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Ljiljana
 */
public class MenuBar extends JMenuBar
{
    private UpPanel upPanel;
    private DownPanel doPanel;
    
    private JMenuBar meniBar;
    private JMenu typeGallows;
    private JCheckBoxMenuItem jcbScientists;
    private JCheckBoxMenuItem jcbSports;
    private JCheckBoxMenuItem jcbSingers;
    private JMenuItem newGame;
    
    private int type;

    /**
     * @return the meniBar
     */
    public JMenuBar getMeniBar() {
        return meniBar;
    }

    /**
     * @param meniBar the meniBar to set
     */
    public void setMeniBar(JMenuBar meniBar) {
        this.meniBar = meniBar;
    }
    
    public MenuBar(UpPanel upPanel, DownPanel downPanel)
    {
        this.upPanel = upPanel;
        this.doPanel = downPanel;
        
        meniBar = new JMenuBar();
        
        typeGallows = new JMenu("Type Gallows");
        
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                newGameClicked();
	    }
	});
        
        typeGallows.add(newGame);
        typeGallows.addSeparator();
        
        jcbScientists = new JCheckBoxMenuItem("Scientists");
        jcbSports = new JCheckBoxMenuItem("Sports");
        jcbSingers = new JCheckBoxMenuItem("Singers");
        
        jcbScientists.setSelected(true);
        jcbScientists.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                chackBoxClick(e);
            }
        });
        
        
        jcbSports.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                chackBoxClick(e);
            }
        });
        
        
        jcbSingers.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                chackBoxClick(e);
            }
        });
        
        
        typeGallows.add(jcbScientists);
        typeGallows.add(jcbSports);
        typeGallows.add(jcbSingers);
        
        meniBar.add(typeGallows);
    }  

    private void chackBoxClick(ActionEvent e) 
    {
        if(((JCheckBoxMenuItem)e.getSource()).getText() == "Scientists")
        {
            getJcbScientists().setSelected(true);
            getJcbSports().setSelected(false);
            getJcbSingers().setSelected(false);
            
            this.type = 1;
        }
        else if(((JCheckBoxMenuItem)e.getSource()).getText() == "Sports")
        {
            getJcbScientists().setSelected(false);
            getJcbSports().setSelected(true);
            getJcbSingers().setSelected(false);
            
            this.type = 2;
        }
        else
        {
            getJcbScientists().setSelected(false);
            getJcbSports().setSelected(false);
            getJcbSingers().setSelected(true);
            
            this.type = 3;
        }
    }
    
    public void newGameClicked()
    {
        this.doPanel.setNumberOfMiss(0);
        
        this.upPanel.setImage("src/Content/Stickman/image.png");
        
        this.doPanel.getDownPanel().removeAll();
        this.doPanel.createButtons();
        
        BaseClass newWord = new BaseClass(this.type);
        this.doPanel.setBase(newWord);
        
        this.doPanel.setRegex("[^ ]");
        
        this.upPanel.setBaseWord(newWord);
        this.upPanel.setWord(newWord.getWord().replaceAll("[^ ]", "?"));
        this.upPanel.setTxtWord("");
    }
    
    /**
     * @return the jcbScientists
     */
    public JCheckBoxMenuItem getJcbScientists() {
        return jcbScientists;
    }

    /**
     * @param jcbScientists the jcbScientists to set
     */
    public void setJcbScientists(JCheckBoxMenuItem jcbScientists) {
        this.jcbScientists = jcbScientists;
    }

    /**
     * @return the jcbSports
     */
    public JCheckBoxMenuItem getJcbSports() {
        return jcbSports;
    }

    /**
     * @param jcbSports the jcbSports to set
     */
    public void setJcbSports(JCheckBoxMenuItem jcbSports) {
        this.jcbSports = jcbSports;
    }

    /**
     * @return the jcbSingers
     */
    public JCheckBoxMenuItem getJcbSingers() {
        return jcbSingers;
    }

    /**
     * @param jcbSingers the jcbSingers to set
     */
    public void setJcbSingers(JCheckBoxMenuItem jcbSingers) {
        this.jcbSingers = jcbSingers;
    }
}
