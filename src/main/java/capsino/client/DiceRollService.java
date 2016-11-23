package capsino.client;

import com.google.gson.Gson;

public class DiceRollService {

	private final DiceRoller diceRoller;
	
	public DiceRollService(DiceRoller diceRoller) {
		super();
		this.diceRoller = diceRoller;
	}

	public String getRoll() {

		Gson gson = new Gson();
		return gson.toJson(this.diceRoller.rollDice());

	}

}
