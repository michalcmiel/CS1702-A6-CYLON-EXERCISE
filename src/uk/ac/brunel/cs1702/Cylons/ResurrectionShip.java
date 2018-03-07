package uk.ac.brunel.cs1702.Cylons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ResurrectionShip {
	
	//YOU CAN ADD FIELDS HERE
	private int shipID;
	private int[]shipNumbers = new int[Constants.MAX_NUMBER_OF_SHIPS + Constants.NUMBER_OF_CYLON_MODELS];
	private int numberOfModels = Constants.NUMBER_OF_CYLON_MODELS / Constants.MAX_NUMBER_OF_SHIPS;
	private ArrayList<Integer> modelsInShip = new ArrayList<Integer>();
	private Map<Integer, Integer> bodiesPerModel = new HashMap<Integer, Integer>();
	
	protected boolean hasModel(int modelNo){
		return modelsInShip.contains(modelNo);
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	protected ResurrectionShip(int shipID){
			this.shipID = shipID;
			int ships =0, models =0;
			for (int i=0; i<shipNumbers.length; i++){
				if (i % (numberOfModels+1) == 0){
					shipNumbers[i] = ships++;
				}
				if (i % (numberOfModels+1) != 0){
					shipNumbers[i] = models++;
				}
				if (shipID-1 == (ships-1)){
					modelsInShip.add(models);
				}
			}
			modelsInShip.remove(0);
			for (int i=0; i<modelsInShip.size(); i++){
				bodiesPerModel.put(modelsInShip.get(i), Constants.MAX_NUMBER_OF_BODIES_PER_MODEL_IN_RESURRECTION_SHIP);
			}
			System.out.println(Arrays.asList(bodiesPerModel));
			System.out.println(modelsInShip);
	}
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	protected int getBodyCount(int modelNo) {
		if (modelsInShip.contains(modelNo)){
			return bodiesPerModel.get(modelNo);
		}
		return 0;
	}
			
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	public Cylon[][] getCylonArmy(int[] modelNoCount) throws CylonException{		
		if (modelNoCount.length != Constants.NUMBER_OF_CYLON_MODELS) {
			throw new CylonException();
		}
		return null;
	}
	
	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	protected int resurrect(Cylon cylon) throws CylonException{
		if (cylon.isInfected()){
			for (int i=0; i< modelsInShip.size(); i++){
				bodiesPerModel.put(modelsInShip.get(i), 0);
			}
		}
		int modelNo = cylon.getModel();
		int bodiesLeftForModel = bodiesPerModel.get(modelNo);
		if (bodiesLeftForModel > 0){
			bodiesPerModel.put(modelNo, bodiesLeftForModel -1);
			return modelNo;
		}
		throw new CylonException();
	}

	//IMPLEMENT THIS METHOD AND DO NOT MODIFY ITS SIGNATURE
	protected int getShipID() {
		return this.shipID;
	}
}
