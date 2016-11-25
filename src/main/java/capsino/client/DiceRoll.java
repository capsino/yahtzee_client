package capsino.client;

public class DiceRoll {

	private int[] roll = new int[5];

	public int[] getRoll() {
		return roll;
	}

	public void setRoll(int[] roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() +
				": roll=" + this.roll;
	}

}
