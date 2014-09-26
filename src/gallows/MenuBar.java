package gallows;

import Panels.DownPanel;
import Panels.UpPanel;
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
    private final JMenuItem newGame;
    
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
        
        newGame = new JMenuItem();
        
        meniBar = new JMenuBar();
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
