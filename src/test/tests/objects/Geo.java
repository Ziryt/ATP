package tests.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geo{
	private String lng;
	private String lat;


	public void setLng(String lng) {
		this.lng = lng;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng(){
		return lng;
	}

	public String getLat(){
		return lat;
	}

	public String Info() {
		return "Geo{" + "\n" +
				"			lng= " + lng + "\n" +
				"			lat= " + lat + "\n" +
				"		}\n";
	}
}
