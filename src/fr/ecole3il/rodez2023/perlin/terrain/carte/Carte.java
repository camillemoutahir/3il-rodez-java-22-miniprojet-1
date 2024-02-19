package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import java.lang.IndexOutOfBoundsException;
import java.util.Scanner;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

public class Carte{
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] terrains;
    
    /*Accesseurs pour le nom, la largeur et la hauteur de la carte */
    public String getNom(){
        return this.nom;
    }
    public int getLargeur(){
        return this.largeur;
    }
    public int getHauteur(){
        return this.hauteur;
    }
    
    public Terrain getTerrain(int x, int y) throws TerrainInexistant{
        if (x < 0 || x>= largeur || y<0 || y>= hauteur){
            throw new TerrainInexistant ("Terrain inexistant aux coordonnées [" + x +"][" + y + "]");
        }
        return terrains[x][y];
    }
    /*Premier constructeur */
    public Carte (String nom, int largeur, int hauteur, GenerateurCarte generateurCarte){
        this.nom = nom;
        this.largeur= largeur;
        this.hauteur = hauteur;
        this.terrains = generateurCarte.genererCarte(largeur, hauteur); 
    }
    /*Deuxième constructeur */
    public Carte(String donneesCarte) throws TerrainInexistant {
        Scanner scanner = new Scanner(donneesCarte);

        // Lecture du nom
        this.nom = scanner.nextLine();

        // Lecture de la largeur et de la hauteur
        this.largeur = Integer.parseInt(scanner.nextLine());
        this.hauteur = Integer.parseInt(scanner.nextLine());

        // Initialisation du tableau de terrains
        this.terrains = new Terrain[largeur][hauteur];

        // Lecture des données de terrain
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                if (!scanner.hasNext()) {
                    scanner.close();
                    throw new TerrainInexistant("Données de terrain insuffisantes");
                }

                String ligne = scanner.nextLine();
                String[] elements = ligne.split(" ");
                double altitude = Double.parseDouble(elements[2]);
                double hydrometrie = Double.parseDouble(elements[1]);
                double temperature = Double.parseDouble(elements[0]);

                this.terrains[x][y] = new Terrain(altitude, hydrometrie, temperature);
            }
        }

        scanner.close();
    }
}

class TerrainInexistant extends IndexOutOfBoundsException {
    public TerrainInexistant (String message){
        super(message);
    }
}