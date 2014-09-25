
package Panels;

import Base.BaseClass;
import java.awt.Font;
import java.awt.MenuBar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    
    public UpPanel(Font font, BaseClass base)
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
