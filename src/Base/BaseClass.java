
package Base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ljiljana
 */
public class BaseClass 
{
    protected String word;

    /**
     * Osnovni konstruktor koji se poziva prilikom prvog otvaranja programa.
     * Cita fajl naucnici.
     */
    public BaseClass()
    {
        this.generateWord("src/Content/Files/scientists.txt");
    }
    
    /**
     * Konstruktor koji se poziva u trenutku kada se učitava nova igra.
     * Prima parametar @menu kojim se razgranicava koji će se od tri fajla čitati.
     * 
     * @param menu tip po kojem se zna koji fajl se cita
     */
    public BaseClass(int menu)
    {
        if(menu == 1)
        {
            this.generateWord("src/Content/Files/scientists.txt");
        }
        else if(menu == 2)
        {
            this.generateWord("src/Content/Files/sports.txt");
        }
        else
        {
            this.generateWord("src/Content/Files/singers.txt");
        }
    } 
    
    /**
     * Funkcija na osnovu lokacije i slucajno izabranog broja otvara fajl i iz
     * njega pronalazi rijec koja se poklapa sa generisanim brojem.
     * 
     * @param location lokacija od fajla iz kojeg ce se nasumicno izvuci slucjana rijec
     */
    private void generateWord(String location)
    {
        BufferedReader reader;
        try 
        {
            reader = new BufferedReader(new FileReader(location));
            
            Random randomNumber = new Random(); //klasa koja radi sa slucajnim brojevima
            int number = randomNumber.nextInt(30); //program nam vrati nasumicno generisan broj od 1 do 30
                    
            while((this.word = reader.readLine()) != null) //citamo fajl do posljednjeg reda
            {
                if(getWord().contains(Integer.toString(number))) //provjeravamo da li rijec do koje smo stigli citanje sadrzi slucajno izabran broj
                {
                    setWord(getWord().substring(3)); //odbijamo prva tri karaktera od pocetka
                    break; //prekida se dalje izvrsavanje jer nema smisla ici do kraja fajla ako smo pronasli trazenu rijec
                }
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(BaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }
}

