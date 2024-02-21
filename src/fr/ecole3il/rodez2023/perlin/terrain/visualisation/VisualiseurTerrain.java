package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;

public abstract class VisualiseurTerrain {
    /*Déclaration des attributs*/
    protected Carte carte;
    protected DetermineurTerrain determineurTerrain;
    protected enum AltitudeAffichee {
        Basse, Moyenne, Elevee, FondMarin
    }
    protected enum HydrometrieAffichee {
        Sec, Moyen, Humide
    }
    protected enum TemperatureAffichee {
        Froid, Tempere, Chaud
    }

    /*Constructeur de la classe Visualisateur Terrain */
    public VisualiseurTerrain(DetermineurTerrain determineurTerrain, Carte carte) {
        this.determineurTerrain = determineurTerrain;
        this.carte = carte;
    }

    public abstract TypeTerrain getTypeTerrain(int x, int y);
    public abstract String getAltitudeAffichee(int x, int y);
    public abstract String getHydrometrieAffichee(int x, int y);
    public abstract String getTemperatureAffichee(int x, int y);
    
}
