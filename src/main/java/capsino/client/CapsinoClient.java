package capsino.client;

import static spark.Spark.get;
import static spark.Spark.port;

public class CapsinoClient {

	public static void main(String[] args) {
		
        port(80);
        get("/", "application/json", (req, res) -> {
        	DiceRoller diceRoller = new ServerDiceRoller();
        	DiceRollService service = new DiceRollService(diceRoller);

        	return service.getRoll();
        });

	}

}
