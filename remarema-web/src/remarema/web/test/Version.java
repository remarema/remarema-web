package remarema.web.test;

public class Version {
	
	private String version = "1.0";
	private String packet = "TomEE";

	public String getVersionName(int i) {
		return version + " " + i;
	}

	public String getPacketName(int i) {
		return packet + " " + i;
	}

}
