
import java.awt.*;
import javax.swing.*;

public class Figurine
{
        private String categorie; // Pokemon, Avengers, Disney, Autre
        private String libelle;  
        private String descriptif;
        private float prix;
        private ImageIcon photo;

        public Figurine(String cat, String l, float prix, String d)
        { 
            this.categorie=cat;
            this.libelle=l;
            this.descriptif=d;
            this.prix=prix;
            this.photo = new ImageIcon(getClass().getResource("/ImageDefaut.jpg"));
        }
        
        public Figurine()
        { 
            this.categorie="Autre";
            this.libelle="";
            this.descriptif="";
            this.prix=0;
            this.photo = new ImageIcon(getClass().getResource("/ImageDefaut.jpg"));
        }



    public String getCategorie() {
        return this.categorie;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public String getDescriptif() {
        return this.descriptif;
    }

    public float getPrix() {
        return this.prix;
    }

    public ImageIcon getPhoto() { return photo;}            


    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

     public void setPrix(float prix) {
        this.prix = prix;
    }
    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
      

    public  String toString()
        {
            String s = "";
            s += "\nCatégorie : " + this.categorie;
            s += "\nLibellé : " + this.libelle;
            s += "\nDescriptif : " + this.descriptif;
            s += "\nPrix : " + this.prix;
            return s;
        }
}

