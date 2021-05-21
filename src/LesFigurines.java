import java.util.*;
import javax.swing.*;
public class LesFigurines {
    private ArrayList<Figurine> lfig;
    
    public LesFigurines()
    {
        this.lfig=new ArrayList<Figurine> ();
        //initFigurines();
    }
    
    public void initFigurines()
    {
        Figurine t;
        
        t= new Figurine("Pokemon", "Pikachu",(float) 25.0, "Figurine Funko Pop Pokemon Pikachu");
        t.setPhoto(new ImageIcon(getClass().getResource("/Pikachu.jpg")));
        ajoutFigurine(t);
        
        t= new Figurine("Pokemon", "Bulbizare",(float) 15.0,"Figurine Funko Pop Pokemon Bulbizarre");
        t.setPhoto(new ImageIcon(getClass().getResource("/Bulbizarre.jpg")));
        ajoutFigurine(t);
      
        t= new Figurine("Avengers", "Captain America",(float) 6.0,"Figurine Funko Pop Avengers Captain America");
        t.setPhoto(new ImageIcon(getClass().getResource("/CaptainAmerica.jpg")));
        ajoutFigurine(t);
        
       t= new Figurine("Disney", "Woody",(float) 6.0,"Figurine Funko Pop Disney Toy Story Woody" );
        t.setPhoto(new ImageIcon(getClass().getResource("/ToyStoryWoody.jpg")));
        ajoutFigurine(t);
    }
    
    public void ajoutFigurine(Figurine t)
    {
        this.lfig.add(t);
    }
    
    public int getNbFigurines()
    {
        return this.lfig.size();
    }
    
    public Figurine getFigurine(int ind)
    {
        if (ind >=0 && ind< this.lfig.size())
            return this.lfig.get(ind);
        else return null;
    }
       
     
    public ArrayList<String> getListeCategories()
    { ArrayList<String> ll= new ArrayList<String> ();
    for (int i=0; i< lfig.size(); i++)
    { String cat = this.lfig.get(i).getCategorie();
    boolean trouve=false;
    for( int j=0; j< ll.size(); j++)
        if (ll.get(j).equals(cat)) trouve=true;
    if (! trouve) ll.add(cat);
    }
    return ll;
    }
    
    public Figurine getFigurineLibelle(String l)
    {
        for(int i=0; i<this.lfig.size(); i++)
            if(this.lfig.get(i).getLibelle().equals(l))
                return lfig.get(i);
        return null;
    }
    
    public LesFigurines getFigurinesCategorie(String cat)
    {
        LesFigurines lp = new LesFigurines();
        for(int i=0; i<this.lfig.size(); i++)
            if(this.lfig.get(i).getCategorie().equals(cat))
                lp.ajoutFigurine(this.lfig.get(i));
        return lp;
    }
    
    public LesFigurines getFigurinesInf(float val)
    {
        LesFigurines lp = new LesFigurines();
        for(int i=0; i<this.lfig.size(); i++)
            if(this.lfig.get(i).getPrix() < val )
                lp.ajoutFigurine(this.lfig.get(i));
        return lp;
    }
    
    public LesFigurines getFigurinesSupe(float val)
    {
        LesFigurines lp = new LesFigurines();
        for(int i=0; i<this.lfig.size(); i++)
            if(this.lfig.get(i).getPrix() >= val )
                lp.ajoutFigurine(this.lfig.get(i));
        return lp;
    }

    @Override
    public String toString() {
        String s="";
        for (int i=0; i<lfig.size(); i++)
        {
            s+="\n\nFigurine N°"+(i+1);
            s+=lfig.get(i).toString();
        }
        return s;
    }
        
      
}
