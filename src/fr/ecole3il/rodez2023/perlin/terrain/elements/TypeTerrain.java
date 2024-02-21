/*Implémnetation de la classe TypeTerrain */
package fr.ecole3il.rodez2023.perlin.terrain.elements;

import java.awt.image.BufferedImage;
import fr.ecole3il.rodez2023.perlin.Utils;

public class TypeTerrain{
    /* Déclaration des attributs */
    private String nom;
    private BufferedImage image;

    /* On instancie les différents types de terrain */
    public static final TypeTerrain OCEAN = new TypeTerrain("Océan", "ocean.png");
    public static final TypeTerrain PLAINE = new TypeTerrain("Plaine", "plain.png");
    public static final TypeTerrain FORET_FEUILLUS = new TypeTerrain("Forêt feuillus", "deciduous_forest.png");
    public static final TypeTerrain TOUNDRA = new TypeTerrain("Toundra", "tundra.png");
    public static final TypeTerrain FORET_CONIFÈRES = new TypeTerrain("Forêt conifères", "coniferous_forest.png");
    public static final TypeTerrain MONTAGNE = new TypeTerrain("Montagne", "mountain.png");
    public static final TypeTerrain DESERT = new TypeTerrain("Désert", "desert.png");
    public static final TypeTerrain COLLINES = new TypeTerrain("Collines", "hills.png");
    public static final TypeTerrain MARAIS = new TypeTerrain("Marais", "marsh.png");


    public TypeTerrain(String nom, String nomImage){
        this.nom=nom;
        this.image= Utils.chargerTuile(nomImage);
    }
    /*Accesseur particulier renvoyant un élément de type BufferedImage et utilisant la fonction Utils.chargerTuile */
    public BufferedImage getImage(){
        return this.image;
    }
    @Override
    /*Méthode qui convertit un TypeTerrain en chaîne de caractère */
    public String toString(){
        return this.nom;
    }
}
