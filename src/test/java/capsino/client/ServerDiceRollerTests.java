package capsino.client;

import static org.junit.Assert.*;

import org.junit.Test;

import capsino.client.ServerDiceRoller.YahtzeeResponse;

public class ServerDiceRollerTests {

	@Test
	public void status_code_200_returns_correct_value() {

		YahtzeeResponse response = new YahtzeeResponse(200, "{\"roll\":2}");
		ServerDiceRoller diceRoller = new ServerDiceRoller();
		diceRoller.setResponse(response);

		diceRoller.setResponse(response);
		DiceRoll actual = diceRoller.rollDice();

		DiceRoll expected = new DiceRoll();
		expected.setRoll(2);

		assertNotNull(actual);
		assertEquals(expected.getRoll(), actual.getRoll());

	}

	@Test(expected=YahtzeeClientException.class)
	public void status_code_other_than_200_throws_exception() {
		
		YahtzeeResponse response = new YahtzeeResponse(404, null);
		ServerDiceRoller diceRoller = new ServerDiceRoller();
		diceRoller.setResponse(response);
		diceRoller.rollDice();

	}

}
