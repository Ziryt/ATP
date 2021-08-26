package tests.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company{
	private String bs;
	private String catchPhrase;
	private String name;

	public void setBs(String bs) {
		this.bs = bs;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBs(){
		return bs;
	}

	public String getCatchPhrase(){
		return catchPhrase;
	}

	public String getName(){
		return name;
	}

	public String Info() {
		return "Company{" + "\n" +
				"		bs= " + bs + "\n" +
				"		catchPhrase= " + catchPhrase + "\n" +
				"		name= " + name + "\n" +
				"	}\n";
	}
}
