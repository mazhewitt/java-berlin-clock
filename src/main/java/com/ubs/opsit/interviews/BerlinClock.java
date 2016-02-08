
public class BerlinClock {

	private boolean secondRow;
	private int hoursTopRow;
	private int hoursBottomRow;
	private int minutesTopRow;
	private int minutesBottomRow;

	public BerlinClock(boolean secondRow, int hoursTopRow, int hoursBottomRow, int minutesTopRow, int minutesBottomRow) {
		this.secondRow = secondRow;
		this.hoursTopRow = hoursTopRow;
		this.hoursBottomRow = hoursBottomRow;
		this.minutesTopRow = minutesTopRow;
		this.minutesBottomRow = minutesBottomRow;
	}
	
	public boolean getSecondRow() {
		return secondRow;
	}

	public void setSecondRow(boolean secondRow) {
		this.secondRow = secondRow;
	}

	public int getHoursTopRow() {
		return hoursTopRow;
	}

	public void setHoursTopRow(int hoursTopRow) {
		this.hoursTopRow = hoursTopRow;
	}

	public int getHoursBottomRow() {
		return hoursBottomRow;
	}

	public void setHoursBottomRow(int hoursBottomRow) {
		this.hoursBottomRow = hoursBottomRow;
	}

	public int getMinutesTopRow() {
		return minutesTopRow;
	}

	public void setMinutesTopRow(int minutesTopRow) {
		this.minutesTopRow = minutesTopRow;
	}

	public int getMinutesBottomRow() {
		return minutesBottomRow;
	}

	public void setMinutesBottomRow(int minutesBottomRow) {
		this.minutesBottomRow = minutesBottomRow;
	}
}
