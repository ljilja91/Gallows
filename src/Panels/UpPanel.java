
package Panels;

import Base.BaseClass;
import gallows.MenuBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Ljiljana
 */
public class UpPanel
{
    private JPanel panel = new JPanel();
    private JLabel word;
    private JLabel image;
    private BaseClass baseWord;
    private JTextField txtWord;
    
    private MenuBar myMenubar;
    
    /**
     * Konstruktor koji kreira gornji panel.
     * 
     * @param base panel mora da ima svijest od rijeci koja se pogadja
     */
    public UpPanel(BaseClass base)
    {
        this.baseWord = base;
        
        panel.setLayout(new BorderLayout(5,5)); //postavlja se izgled kompletnog panela
        
        JPanel imagePanel = new JPanel(); //kreiramo imagePanel koji sadrzi labelu u kojoj prikazujemo samo sliku "cikice"
        imagePanel.setLayout(new BorderLayout(5, 5));
        imagePanel.setBackground(Color.WHITE);
        image = new JLabel(new ImageIcon("src/Content/Stickman/image.PNG")); //postavljamo osnovu sliku 
        image.setVerticalAlignment(SwingConstants.CENTER); //postavljamo vertikalno poravnanje
        imagePanel.add(image, BorderLayout.CENTER); //dodajemo image na imagePanel na centralni dio izgleda 
        
        panel.add(imagePanel, BorderLayout.CENTER); //dodajemo imagePanel na naš glavni gornji panel
        
        JPanel userPanel = new JPanel(); //kreiramo korisnicki panel na kojem korisnik ima mogucnost da unese i provjeri rijec 
        userPanel.setLayout(new BorderLayout(5,5)); //postavljamo izgled korisnickom panelu
        
        JLabel labela = new JLabel("Type Your word");
        labela.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        labela.setHorizontalAlignment(SwingConstants.CENTER);
        userPanel.add(labela, BorderLayout.NORTH); //dodajemo labelu na korisnicki panel
        
        txtWord = new JTextField(); //kreiramo text box za unos teksta
        txtWord.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        txtWord.setHorizontalAlignment(SwingConstants.CENTER);
        
        /*
         * Dodajemo listener za slusaj kada je pritisnuto neko dugme na tastaturi i kada je 
        otpusteno. 
         */
        txtWord.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                chackLenght();
            }
            
            @Override
            public void keyReleased(KeyEvent e) 
            {
                capsLockLetter();
            }
	});
        
        userPanel.add(txtWord, BorderLayout.CENTER);
        
        JButton btnChackWord = new JButton("Chack word"); //na dugmetu pise sadrzaj Chack word
        btnChackWord.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        
        
        /*
        Dodajemo osluskivac na slucaj kada je kliknuto dugme.
        */
        btnChackWord.addMouseListener(new MouseAdapter() 
        {
	    @Override
	    public void mouseClicked(MouseEvent arg0) 
            {
                chackWord();
	    }
	});
        
        userPanel.add(btnChackWord, BorderLayout.SOUTH); //na korisnicki panel dodajemo dugme ali juzno. 
        //Postavljamo ga na donju stranu panela.
        
        JPanel wordPanel = new JPanel();
        
        word = new JLabel();
        word.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
        /*
        Rijec koju dodajemo na panel postavljamo tako sto pristupimo bazi.
        Uzmemo datu rijec preko metode getWord() koja nam vraca string i zatim zamjenimo sve karatere
        u rijeci za znakom ? osim razmaka.
        */
        word.setText(base.getWord().replaceAll("[^ ]", "?"));
                
        word.setHorizontalAlignment(SwingConstants.CENTER);
        wordPanel.add(word);
        
        panel.add(wordPanel, BorderLayout.SOUTH); //dodajemo wordPanel sa rjeci koja se pogadja juzno na kompletan gornji panel
        
        panel.add(userPanel, BorderLayout.NORTH); //kompletan korisnicki panel dodajemo na gornju stranu naseg glavnog gornjeg panela
    }
    
    /**
     * Funkcija provjera duzinu unjete rijeci u text box svaki put kada se pritisne neki taster.
     * Ako je duzina unjete rijeci veca od duzine rijeci koja se trazi stopira se dalji unos.
     */
    public void chackLenght()
    {
        int lenghtWord = getBaseWord().getWord().length();
        if(txtWord.getText().length() >= lenghtWord)
        {
            /*
            Odsjecamo zadnji karakter koji se unosi.
            */
            String test = txtWord.getText().substring(0, txtWord.getText().length()-1);
            txtWord.setText(test);
        }
    }
    
    /*
    Funkcija svaki unjeti karakter pretvara u veliko slovo.
    */
    public void capsLockLetter() 
    {
        this.txtWord.setText(this.txtWord.getText().toUpperCase());
    }
    
    /**
     * Funkcija provjerava da li je korisnik unio tacnu rijec
     */
    public void chackWord()
    {
        if(getTxtWord().getText().equals(this.getBaseWord().getWord())) //slucaj kada je korisnik uniio tacnu rijec 
        {
            /*
            Poruka koja se ispisuje korisniku je sastavljena od finksong stringa i rijeca koja se trazila.
            */
            JLabel lblWIn = new JLabel("Congratulations, you are successfully hit a search term " + getBaseWord().getWord()); 
            lblWIn.setForeground(Color.magenta);
            lblWIn.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
        
            ImageIcon icon = new ImageIcon("src/Content/Images/star.png"); //postavlja se pobjednicka slicica
            
            Object buttonArray[] = {"New game", "EXIT"}; //definise se niz objekata sa sadrzajem
        
            int response = JOptionPane.showOptionDialog(null, lblWIn, "Gallows", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                    icon, buttonArray, buttonArray[0]);
            
            if (response == JOptionPane.YES_OPTION) 
            {
                this.getMyMenubar().newGameClicked(); //ako korisnik zeli novu igru pokrece se metoda newGameClicked() iz kalse MenuBar
            } 
            else
            {
                System.exit(0); //U slucaju negativnog odgovora kraj programa.
            }
        }
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() 
    {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) 
    {
        this.panel = panel;
    }
    
    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.getWord().setText(word);
    }

    /**
     * @return the word
     */
    public JLabel getWord() {
        return word;
    }

    public void setImage(String src)
    {
        image.setIcon(new ImageIcon(src));
    }

    /**
     * @return the baseWord
     */
    public BaseClass getBaseWord() {
        return baseWord;
    }

    /**
     * @param baseWord the baseWord to set
     */
    public void setBaseWord(BaseClass baseWord) {
        this.baseWord = baseWord;
    }

    /**
     * @return the txtWord
     */
    public JTextField getTxtWord() {
        return txtWord;
    }

    /**
     * @param txtWord the txtWord to set
     */
    public void setTxtWord(String txtWord) {
        this.txtWord.setText(txtWord);
    }

    /**
     * @return the myMenubar
     */
    public MenuBar getMyMenubar() {
        return myMenubar;
    }

    /**
     * @param myMenubar the myMenubar to set
     */
    public void setMyMenubar(MenuBar myMenubar) {
        this.myMenubar = myMenubar;
    }
}
