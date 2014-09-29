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
    private JPanel downPanel = new JPanel(); //osnovni panel
    private UpPanel upPanel;
    private MenuBar myMenuBar;
    private BaseClass base;
    private String regex = "[^ ]";
    
    private int numberOfMiss=0;
    
    /**
     * 
     * @param base komunicira sa bazom radi rijeci koja se pogadja
     * @param upPanel potrebna je svijest o gornjem panelu radi eventualnih izmjena
     */
    public DownPanel(BaseClass base, UpPanel upPanel)
    {
        downPanel.setBackground(Color.yellow);
        downPanel.setPreferredSize(new Dimension(WIDTH, 160)); //postavljanje duzine panela a visina se postvlja fiksno na 160
        
        createButtons();
        
        /*
        Inicijalizujemo privatna polja preko parametara koja smo doprijemili preko konstruktora.
        */
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
    
    /**
     * Funkcija obradjuje slucaj kada je kliknuto neko dugme.
     * 
     * @param button dugme koje je kliknuto
     */
    public void letterClick(JButton button)
    {
        button.setVisible(false); //uklanjamo dugme sa panela
        
        if(getBase().getWord().contains(button.getText())) //u slucaju da se slovo nalazi u rijeci koja se pogadja
        {
            /*
            Uklanjamo zadnji karakter iz regexa, tacnije uklanja se ']'
            */
            setRegex(getRegex().substring(0, getRegex().length() - 1));
            /*
            Kreiramo novi regex na osnovu postojećeg. U kojem postavljamo takav string da će se 
            u kasnijoj zamjeni zamjeniti svi karakteri koji nisu razmak i oni karakteri koji su jednaki
            slovu koje se nalazi na dugmetu koje je klinuto.
            */
            setRegex(getRegex() + ",^" + button.getText() + "]");
            
            String testString = getBase().getWord();
            testString = testString.replaceAll(getRegex(), "?"); //kreiramo novu rijec na osnovu novog regexa koja ce se pojaviti na korisnickom panelu
            
            this.upPanel.setWord(testString); //postavljamo novu rijec na panel
        }
        else
        {
            /*
            Povecavamo i postavljamo novu vrijednost promasaja.
            */
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
                    this.upPanel.setWord(this.base.getWord()); //prikazuje se korisniku trazena rijec u slucaju da je izgubio
                    
                    this.upPanel.setImage("src/Content/Stickman/image6.png");
                    JLabel lblWIn = new JLabel("Ooooh, You Lose!!!"); //tekst poruke koji se ispisuje u slusaju gubitka
                    lblWIn.setForeground(Color.magenta);
                    lblWIn.setFont(new Font("Kristen ITC", Font.PLAIN, 15)); //inicijalizacija fonta
                    
                    ImageIcon icon = new ImageIcon("src/Content/Images/loseGame.png"); //slicica koja se prikazuje korisniku
                    
                    Object buttonArray[] = {"New game", "EXIT"}; //definisemo niz objekata sa njohovim sadrzajem koji je tekst
        
                    /*
                    Korisniku prikazujemo opcioni panel i kupimo njegov odogovor u promjenjivu
                    response.
                    */
                    int response = JOptionPane.showOptionDialog(null, lblWIn, "Gallows", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                    icon, buttonArray, buttonArray[0]);
                    
                    if(response == JOptionPane.YES_OPTION)
                    {
                        this.myMenuBar.newGameClicked(); //odgovor je potvrdan, kreće nova igra
                        return;
                    }
                    else
                    {
                        System.exit(0); //KRAJ PROGRAMA
                    }
                    
                    break;
                }
            }
        }
    }

    /**
     * Funkcija kreira dugmad koja dodaje na donji panel.
     * Kreira se osluškivač na dugme. 
     * Kreira se 26 dugmadi sa sadrzajem sacinjenih od slova engleskog alfabeta.
     */
    public void createButtons()
    {
        char letter = 'A';
        JButton dugme;
        for (int i = 1; i <= 26; i++) 
        {
            dugme = new JButton(String.valueOf(letter++)); //postavljamo sadrzaj dugmeta. Konvertujemo cijelobrojnu vrijednost u string.
            //kasnije se povecava vrijednost slova
            dugme.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
            dugme.setBackground(Color.GREEN);
            this.downPanel.add(dugme);
            
            /*
            Dodajemo osluskivac na svako dugme.
            Svakom dugmetu prosljedjujemo metodom kastovanja sadrzaj onog dugmeta koje je kliknuto.
            */
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
