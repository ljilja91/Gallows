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
    
    /**
     * Konstrkutor inicijalizuje parametre i kreira menu sa osnovnim postavkama.
     * 
     * @param upPanel gornji panel
     * @param downPanel donji panel
     */
    public MenuBar(UpPanel upPanel, DownPanel downPanel)
    {
        this.upPanel = upPanel;
        this.doPanel = downPanel;
        
        meniBar = new JMenuBar();
        
        //naslov menija
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
        typeGallows.addSeparator(); //dodavanje separatora
        
        /*
        Inicijalizacija osnovna tri chack boxa.
        */
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

    /**
     * Funkcija postavlja koji je od tri chack boxa cekiran.
     * Postavlja 
     * @see #type po kome se razaznaje koji fajl treba citati prilikom pokretanja nove igrice.
     * 
     * @param e 
     */
    private void chackBoxClick(ActionEvent e) 
    {
        if(((JCheckBoxMenuItem)e.getSource()).getText() == "Scientists")
        {
            getJcbScientists().setSelected(true);
            getJcbSports().setSelected(false);
            getJcbSingers().setSelected(false);
            
            this.type = 1; //tip su naucnici
        }
        else if(((JCheckBoxMenuItem)e.getSource()).getText() == "Sports")
        {
            getJcbScientists().setSelected(false);
            getJcbSports().setSelected(true);
            getJcbSingers().setSelected(false);
            
            this.type = 2; //tip su sportisti
        }
        else
        {
            getJcbScientists().setSelected(false);
            getJcbSports().setSelected(false);
            getJcbSingers().setSelected(true);
            
            this.type = 3; //tip su pjevaci
        }
    }
    
    /**
     * Funkcija odpocinje novu igru i vrsi inicijalizaciju sljedecih parametara
     * {@link DownPanel#numberOfMiss}, postavlja se na 0,
     * {@link UpPanel#image} , postavlja se pocetna slika,
     * {@link DownPanel#createButtons()} , kreiraju se ponovo sva dugmad,
     * {@link BaseClass#BaseClass(int)} , poziva se konstruktor za inicijalizaciju nove rijeci na osnovu tipa,
     * {@link DownPanel#setBase(Base.BaseClass)} , donji panel treba da ima svijest o rijeci koja se pogadja,
     * {@link DownPanel#setRegex(java.lang.String)} , postavlja se osnovni regex,
     * {@link UpPanel#setBaseWord(Base.BaseClass)} , gornji panel treba da ima svijest o rijeci koja se pogadja,
     * {@link UpPanel#setWord(java.lang.String)} , postavlja se trazena rijec na panel sa upitnicima,
     * {@link UpPanel#setTxtWord(java.lang.String)} , brise se polje za unos rijeci.
     */
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
