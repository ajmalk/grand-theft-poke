package edu.gatech.CS2340.GrandTheftPoke.backend.Towns;

/**
 * Town Factory
 * 
 * @author Team Rocket
 */
public interface TownFactory {

	/**
	 * 
	 * @return PalletTown
	 */
	public Town makePalletTown();

	/**
	 * 
	 * @return ViridianCity
	 */
	public Town makeViridianCity();

	/**
	 * 
	 * @return PewterCity
	 */
	public Town makePewterCity();

	/**
	 * 
	 * @return CeruleanCity
	 */
	public Town makeCeruleanCity();

	/**
	 * 
	 * @return SaffronCity
	 */
	public Town makeSaffronCity();

	/**
	 * 
	 * @return CeladonCity
	 */
	public Town makeCeladonCity();

	/**
	 * 
	 * @return LavenderTown
	 */
	public Town makeLavenderTown();

	/**
	 * 
	 * @return VermillionCity
	 */
	public Town makeVermillionCity();

	/**
	 * 
	 * @return FuchsiaCity
	 */
	public Town makeFuchsiaCity();

	/**
	 * 
	 * @return CinnibarIsland
	 */
	public Town makeCinnabarIsland();

	/**
	 * 
	 * @return PowerPlant
	 */
	public Town makePowerPlant();
}
