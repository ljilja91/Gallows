
package Panels;

import Base.BaseClass;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.MenuBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    
    public UpPanel(BaseClass base)
    {
        this.baseWord = base;
        
        panel.setLayout(new BorderLayout(5,5));
        
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout(5, 5));
        imagePanel.setBackground(Color.WHITE);
        image = new JLabel(new ImageIcon("src/Content/Stickman/image.PNG"));
        image.setVerticalAlignment(SwingConstants.CENTER);
        imagePanel.add(image, BorderLayout.CENTER);
        
        panel.add(imagePanel, BorderLayout.CENTER);
        
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout(5,5));
        
        JLabel labela = new JLabel("Type Your word");
        labela.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        labela.setHorizontalAlignment(SwingConstants.CENTER);
        userPanel.add(labela, BorderLayout.NORTH);
        
        txtWord = new JTextField();
        txtWord.setFont(new Font("Kristen ITC", Font.PLAIN, 18));
        txtWord.setHorizontalAlignment(SwingConstants.CENTER);
        
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
        
    }
    
    public void chackLenght()
    {
    }
    
    public void capsLockLetter() 
    {
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
