package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;

public class VisualiseurTerrainEnonce extends VisualiseurTerrain {
	public VisualiseurTerrainEnonce(Carte c) {
		super(new DetermineurTerrainEnonce(), c);
	}

	/*Méthode getTypeTerrain */
	@Override
	public TypeTerrain getTypeTerrain(int x, int y) {
		double altitude = carte.getTerrain(x, y).getAltitude();
		double hydrometrie = carte.getTerrain(x, y).getHydrometrie();
		double temperature = carte.getTerrain(x, y).getTemperature();
		return determineurTerrain.determinerTerrain(altitude, hydrometrie, temperature);
	}

	/*Méthode getAltitudeAffichee */
	@Override
	public String getAltitudeAffichee(int x, int y) {
		double altitude = carte.getTerrain(x, y).getAltitude();
		if (altitude < 0) {
			return "Fond marin";
		} else if (altitude < 0.33) {
			return "Basse";
		} else if (altitude < 0.66) {
			return "Moyenne";
		} else {
			return "Elevée";
		}
	}

	/*Méthode getHydrometrieAffichee */
	@Override
	public String getHydrometrieAffichee(int x, int y) {
		double hydrometrie = carte.getTerrain(x, y).getHydrometrie();
		if (hydrometrie < 0.33) {
			return "Sec";
		} else if (hydrometrie < 0.66) {
			return "Moyen";
		} else {
			return "Humide";
		}
	}

	/*Méthode getTemperatureAffichee */
	@Override
	public String getTemperatureAffichee(int x, int y) {
		double temperature = carte.getTerrain(x, y).getTemperature();
		if (temperature < 0.33) {
			return "Froid";
		} else if (temperature < 0.66) {
			return "Tempéré";
		} else {
			return "Chaud";
		}
	}
}
