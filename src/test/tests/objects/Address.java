package tests.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address{
	private String zipcode;
	private Geo geo = new Geo();
	private String suite;
	private String city;
	private String street;

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode(){
		return zipcode;
	}

	public Geo getGeo(){
		return geo;
	}

	public String getSuite(){
		return suite;
	}

	public String getCity(){
		return city;
	}

	public String getStreet(){
		return street;
	}

	public String Info() {
		return "Address{" + "\n" +
				"		zipcode= " + zipcode + "\n" +
				"		geo= " + geo.Info() +
				"		suite= " + suite + "\n" +
				"		city= " + city + "\n" +
				"		street= " + street + "\n" +
				"	}\n";
	}
}
