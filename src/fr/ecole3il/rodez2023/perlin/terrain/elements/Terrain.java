/*Implémnetation de la classe TypeTerrain */
package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain {
    private double temperature;
    private double altitude;
    private double hydrometrie;

    public double getHydrometrie(){
        return this.hydrometrie;
    }

    public double getTemperature (){
        return this.temperature;
    }

    public double getAltitude(){
        return this.altitude;
    }

    public Terrain (double hydrometrie, double temperature, double altitude){
        if (hydrometrie<=0 || hydrometrie >=1){
            throw new MauvaiseValeurException ("L'hydrométrie doit être comprise entre 0 et 1, valeur obtenue : " + hydrometrie);
        }
        if (temperature<=0 || temperature >=1){
            throw new MauvaiseValeurException ("La température doit être comprise entre 0 et 1, valeur obtenue : " + temperature);
        }
        if (altitude<=-1 || altitude >=1){
            throw new MauvaiseValeurException ("L'altitude doit être comprise entre -1 et 1, valeur obtenue : " + altitude);
        }
        this.hydrometrie = hydrometrie;
        this.temperature = temperature;
        this.altitude = altitude;
    }
    /*méthode sui accepte un visiteur */
    public TypeTerrain getTypeTerrain (DetermineurTerrain dt){
        return dt.determinerTerrain(this.altitude, this.hydrometrie, this.temperature);
    }
    
}