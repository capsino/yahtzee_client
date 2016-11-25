package capsino.client;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;

public class DiceRollServiceTests {

	private TestDiceRoller diceRoller;
	private DiceRollService service;

	@Before
	public void before() {
		diceRoller = new TestDiceRoller();
		service = new DiceRollService(diceRoller);
	}

	@Test
	public void returns_correct_json_for_all_1() {

		String actual = service.getRoll();
		String expected = "{\"roll\":[1,1,1,1,1]}";

		assertThat(actual, is(equalToIgnoringWhiteSpace(expected)));

	}

	@Test
	public void returns_correct_json_for_1_to_5() {

		diceRoller.roll = new int[]{ 1, 2, 3, 4, 5 };
		String actual = service.getRoll();
		String expected = "{\"roll\":[1,2,3,4,5]}";

		assertThat(actual, is(equalToIgnoringWhiteSpace(expected)));

	}

	public static class TestDiceRoller implements DiceRoller {

		public int[] roll = { 1, 1, 1, 1, 1 };

		@Override
		public DiceRoll rollDice() {

			DiceRoll diceRoll = new DiceRoll();
			diceRoll.setRoll(this.roll);

			return diceRoll;

		}
		
	}

}
