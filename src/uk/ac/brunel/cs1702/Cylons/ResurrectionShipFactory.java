package uk.ac.brunel.cs1702.Cylons;

//DO NOT MODIFY THIS LINE
public class ResurrectionShipFactory implements ShipFinder {
	
	//YOU CAN ADD FIELDS HERE
	
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
		return null;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	@Override
	public ResurrectionShip findYourShip(Cylon cylon) {
		return null;
	}
}