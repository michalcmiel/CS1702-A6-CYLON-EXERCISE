package uk.ac.brunel.cs1702.Cylons;

public class Cylon {
	
	//YOU CAN ADD FIELDS HERE
	private int modelNo = 0;
	private int resurrectionCount = 0;
	private int dead = 0;
	private int infected = 0;
	
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	protected Cylon(int modelNo) throws CylonException{
		if (modelNo< 1 || modelNo>Constants.NUMBER_OF_CYLON_MODELS){
			throw new CylonException();
		}
		this.modelNo = modelNo;
	}

	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public int getModel() {
		return this.modelNo;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public int getResurrectionCount() {
		return this.resurrectionCount;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public boolean isDeadForever() {
		if (this.dead == 1){
			return true;
		}else return false;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public void killed() throws CylonException{
		try{
			ResurrectionShip ship = ResurrectionShipFactory.getInstance().findYourShip(this);
			if (ship != null){
				ship.resurrect(this);
				this.resurrectionCount++;
			}
			else {
				throw new CylonException();
			}
		}catch (CylonException ex){
			this.dead = 1;
		}
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public void setInfected(){
			this.infected = 1;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public boolean isInfected(){
		if (this.infected == 1){
			return true;
		}else return false;
	}	
}
