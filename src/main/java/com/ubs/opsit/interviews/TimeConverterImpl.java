import java.time.LocalTime;
import java.util.Arrays;


public class TimeConverterImpl implements TimeConverter{
	
	private static final String LINE_SEPERATOR = "\n";
	private final static char OFF = 'O';
	private final static String SECOND_ROW_FORMAT = "Y";
	private final static String HOUR_ROW_FORMAT = "RRRR";
	private final static String MINUTE_TOP_ROW_FORMAT = "YYRYYRYYRYY";
	private final static String MINUTE_BOTTOM_ROW_FORMAT = "YYYY";

	@Override
	public String convertTime(String aTime) {
		LocalTime localTime = convertTimeStringToLocalTime(aTime);
		BerlinClock berlinClock = buildBerlinClock(localTime);
		return printBerlinClockRepresentation(berlinClock);
	}
	
	private LocalTime convertTimeStringToLocalTime(String aTime) {
		verifyFormat(aTime);
		return LocalTime.parse(aTime);
	}
	
	private void verifyFormat(String aTime) {
		if (aTime == null || aTime.isEmpty()) {
			throw new IllegalArgumentException("Time is required in the format HH:MM:SS");
		}
		if (!aTime.matches("\\d\\d:\\d\\d:\\d\\d")) {
			throw new IllegalArgumentException("Time must be in the format HH:MM:SS");
		}
	}
	
	private BerlinClock buildBerlinClock(LocalTime localTime) {
		boolean secondRow = localTime.getSecond()%2 == 0;
		int hoursTopRow = localTime.getHour()/5;
		int hoursBottomRow = localTime.getHour()%5;
		int minutesTopRow = localTime.getMinute()/5;
		int minutesBottomRow = localTime.getMinute()%5;
		return new BerlinClock(secondRow, hoursTopRow, hoursBottomRow, minutesTopRow, minutesBottomRow);
	}

	private String printBerlinClockRepresentation(BerlinClock berlinClock) {
		StringBuilder berlinClockBuilder = new StringBuilder();
		
		berlinClockBuilder.append(berlinClock.getSecondRow() ? SECOND_ROW_FORMAT : OFF);
		berlinClockBuilder.append(LINE_SEPERATOR);
		
		printBerlinClockRow(berlinClockBuilder, berlinClock.getHoursTopRow(), HOUR_ROW_FORMAT);
		
		printBerlinClockRow(berlinClockBuilder, berlinClock.getHoursBottomRow(), HOUR_ROW_FORMAT);
		
		printBerlinClockRow(berlinClockBuilder, berlinClock.getMinutesTopRow(), MINUTE_TOP_ROW_FORMAT);
		
		printBerlinClockRow(berlinClockBuilder, berlinClock.getMinutesBottomRow(), MINUTE_BOTTOM_ROW_FORMAT);
		
		return berlinClockBuilder.toString();
	}

	private void printBerlinClockRow(StringBuilder berlinClockBuilder,int numBlinks, String berlinClockRowFormat) {
		char[] row = berlinClockRowFormat.toCharArray();
		Arrays.fill(row, numBlinks, row.length, OFF);
		berlinClockBuilder.append(row);
		berlinClockBuilder.append(LINE_SEPERATOR);
	}
}
