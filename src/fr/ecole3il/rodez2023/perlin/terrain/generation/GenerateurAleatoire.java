package fr.ecole3il.rodez2023.perlin.terrain.generation;

import java.util.Random;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

public class GenerateurAleatoire extends GenerateurCarte{
    private Random random;

    public GenerateurAleatoire (long graine){
        super(graine);
        random = new Random(graine);
    }

    @Override
    public Terrain genererTerrain(int i, int j, int largeur, int hauteur){
        double hydrometrie = random.nextDouble();
        double temperature = random.nextDouble();
        double altitude = random.nextDouble() *2 - 1;
        return new Terrain(hydrometrie, temperature, altitude);
    }
}
