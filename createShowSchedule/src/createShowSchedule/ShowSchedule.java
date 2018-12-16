package createShowSchedule;

import java.util.ArrayList;

public class ShowSchedule {
	public ArrayList<Show> showSchedule;
	
	public ShowSchedule(ArrayList<Show> showSchedule) {
		this.showSchedule = showSchedule;
	}
	
	ArrayList<Show> getSched() { return this.showSchedule; }
}
