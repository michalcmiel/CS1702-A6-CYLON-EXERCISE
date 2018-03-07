package uk.ac.brunel.cs1702.Cylons;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

//DO NOT MODIFY THIS LINE
public class ResurrectionShipFactory implements ShipFinder {
	
	//YOU CAN ADD FIELDS HERE
	
	List<ResurrectionShip> ships = new ArrayList<ResurrectionShip>();
	
	
	//DO NOT MODIFY THIS LINE
	private static ResurrectionShipFactory instance;

	//DO NOT MODIFY THIS CONSTRUCTOR
	private ResurrectionShipFactory(){}
	
	//DO NOT MODIFY THIS METHOD
	public static ResurrectionShipFactory getInstance(){
		if(instance == null)
			instance = new ResurrectionShipFactory();
		return instance;
	}

	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public ResurrectionShip getNewShip(int shipID) throws CylonException {
		if (shipID < 1 || shipID > Constants.NUMBER_OF_CYLON_MODELS || ships.size() >= Constants.MAX_NUMBER_OF_SHIPS){
			throw new CylonException();
		}
		if (ships.stream().filter(s -> s.getShipID() == shipID).count() > 0){
			throw new CylonException();
		}
		ResurrectionShip ship = new ResurrectionShip(shipID);
		ships.add(ship);
		return ship;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	@Override
	public ResurrectionShip findYourShip(Cylon cylon) {
		Optional<ResurrectionShip> ship = ships.stream()
				.filter(s -> s.hasModel(cylon.getModel())).findFirst();
		if (ship.isPresent()) {
			return ship.get();
		}
		return null;
	}
}