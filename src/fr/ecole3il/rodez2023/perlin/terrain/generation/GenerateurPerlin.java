package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;

public class GenerateurPerlin extends GenerateurCarte {
    
    private BruitPerlin2D bruitPerlinHydrometrie;
    private BruitPerlin2D bruitPerlinTemperature;
    private BruitPerlin2D bruitPerlinAltitude;

    public GenerateurPerlin(long graine) {
        super(graine);
        double resolution = 1.0;
        bruitPerlinHydrometrie = new BruitPerlin2D(graine, resolution);
        bruitPerlinTemperature = new BruitPerlin2D(graine*2, resolution);
        bruitPerlinAltitude = new BruitPerlin2D(graine*4, resolution);
    }

    @Override
    public Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double hydrometrie = bruitPerlinHydrometrie.bruit2D(i/(double)largeur, j/(double)hauteur) * 0.5 + 0.5; 
        double temperature = bruitPerlinTemperature.bruit2D(i/(double)largeur, j/(double)hauteur) * 0.5 + 0.5;
        double altitude = bruitPerlinAltitude.bruit2D(i/(double)largeur, j/(double)hauteur);
        return new Terrain(hydrometrie, temperature, altitude);
    }
}
