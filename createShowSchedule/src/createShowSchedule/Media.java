package createShowSchedule;

import javafx.util.Pair;
import java.util.ArrayList;

public class Media {
	public String facebook;
	public String instagram;
	public String soundcloud;
	public String spinitron;
	
	public Media(String facebook, String instagram, String soundcloud, String website, String spinitron) {
		this.facebook = facebook;
		this.instagram = instagram;
		this.soundcloud = soundcloud;
		this.spinitron = spinitron;
	}
	
	public ArrayList<Pair<String, String>> getMedia() {
		ArrayList<Pair<String, String>> media = new ArrayList<Pair<String, String>>();
		
		if (!this.spinitron.equals("")) {
			media.add(new Pair<String, String>("Spinitron", this.spinitron));
		}
		
		if (!this.soundcloud.equals("")) {
			media.add(new Pair<String, String>("Soundcloud", this.soundcloud));
		}
		
		if (!this.facebook.equals("")) {
			media.add(new Pair<String, String>("Facebook", this.facebook));
		}
		
		if (!this.instagram.equals("")) {
			media.add(new Pair<String, String>("Instagram", this.instagram));
		}		
		
		return media;
	}
}
