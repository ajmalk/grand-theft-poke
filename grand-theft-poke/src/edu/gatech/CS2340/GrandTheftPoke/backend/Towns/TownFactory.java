/**
 * TownFactory.java
 * @version 1.0
 */
package edu.gatech.CS2340.GrandTheftPoke.backend.Towns;

/**
 * Town Factory
 * 
 * @author Team Rocket
 * @version 1.0
 */
public interface TownFactory {

	/**
	 * 
	 * @return PalletTown
	 */
	Town makePalletTown();

	/**
	 * 
	 * @return ViridianCity
	 */
	Town makeViridianCity();

	/**
	 * 
	 * @return PewterCity
	 */
	Town makePewterCity();

	/**
	 * 
	 * @return CeruleanCity
	 */
	Town makeCeruleanCity();

	/**
	 * 
	 * @return SaffronCity
	 */
	Town makeSaffronCity();

	/**
	 * 
	 * @return CeladonCity
	 */
	Town makeCeladonCity();

	/**
	 * 
	 * @return LavenderTown
	 */
	Town makeLavenderTown();

	/**
	 * 
	 * @return VermillionCity
	 */
	Town makeVermillionCity();

	/**
	 * 
	 * @return FuchsiaCity
	 */
	Town makeFuchsiaCity();

	/**
	 * 
	 * @return CinnibarIsland
	 */
	Town makeCinnabarIsland();

	/**
	 * 
	 * @return PowerPlant
	 */
	Town makePowerPlant();
}
