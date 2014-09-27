package gallows;

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
        
    }
    
    public void newGameClicked()
    {
        
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
