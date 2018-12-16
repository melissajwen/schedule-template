package createShowSchedule;

public class Show {
	public String showID;
	public String dataStart;
	public String dataEnd;
	public String eventName;
	public String djName;
	public String description;
  	public Media media;
  	
  	public Show(String showID, String dataStart, String dataEnd, String eventName, String djName, String description, Media media) {
		this.showID = showID;
		this.dataStart = dataStart;
		this.dataEnd = dataEnd;
		this.eventName = eventName;
		this.djName = djName;
		this.description = description;
		this.media = media;
	}
}
