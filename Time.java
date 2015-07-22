import java.io.DataInputStream;
import java.io.IOException;

/**
 * To show the valid time in hour : minutes : seconds from the integer seconds
 * 
 * @author Anitha
 * 
 */
public class Time {
	public static void main(String[] args) throws IOException {
		int seconds;
		String time;
		DataInputStream dataInput = new DataInputStream(System.in);
		System.out.println("Enter the seconds ");
		/*
		 * reading input seconds from the user
		 */
		seconds = Integer.parseInt(dataInput.readLine());
		// checking constraint
		if (seconds > (24 * 60 * 60) - 1) {
			System.out.println("Invalid input ");
		} else {
			time = whatTime(seconds, 0);
			System.out.println("Time is " + time);
		}

	}

	/**
	 * To manipulate time in <H> : <M>: <S>
	 * 
	 * @param seconds
	 *            - input in seconds
	 * @param level
	 *            - height of time ( contains either hour,minutes, seconds )
	 * @return
	 */
	public static String whatTime(int seconds, int level) {
		String time = "";
		if (seconds != 0) {
			level = level + 1;
			// recursion until the seconds reached zero
			time = whatTime((int) (seconds / 60), level);

			// to avoid colon in starting
			// else - : hour : minute : seconds will be displayed
			if (time != "")
				time = time.concat(":");

		} else {
			// if it has not hour

			if (level == 2) {
				time = "0";
			}
			// no hour and minute
			else if (level == 1) {
				time = "0:0";
			}
			// no hour ,minute and seconds
			else if (level == 0) {
				time = "0:0:0";
			}
			return time;
		}

		return time.concat(Integer.toString(seconds % 60));

	}
}