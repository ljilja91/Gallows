package Panels;

import Base.BaseClass;
import java.awt.Font;
import javax.swing.JPanel;

/**
 *
 * @author Ljiljana
 */
public class DownPanel
{
    private JPanel downPanel = new JPanel();
    private UpPanel upPanel;
    private Font font;
    private BaseClass base;
  
    
    public DownPanel(Font font, BaseClass base, UpPanel upPanel)
    {
        this.font = font;
        this.base = base;
        this.upPanel = upPanel;
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
     * @return the upPanel
     */
    public UpPanel getUpPanel() {
        return upPanel;
    }

    /**
     * @param upPanel the upPanel to set
     */
    public void setUpPanel(UpPanel upPanel) {
        this.upPanel = upPanel;
    }
}
