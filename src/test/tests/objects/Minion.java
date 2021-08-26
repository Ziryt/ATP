package tests.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Random;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Minion{
	private int id;
	private String name;
	private String username;
	private String email;
	private Address address = new Address();
	private String phone;
	private String website;
	private Company company = new Company();

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWebsite(){
		return website;
	}

	public Address getAddress(){
		return address;
	}

	public String getPhone(){
		return phone;
	}

	public String getName(){
		return name;
	}

	public Company getCompany(){
		return company;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}

	public String Info() {
		return "Minion{" + "\n" +
				"	id= " + id + "\n" +
				"	name= " + name + "\n" +
				"	username= " + username + "\n" +
				"	email= " + email + "\n" +
				"	address= " + address.Info() +
				"	phone= " + phone + "\n" +
				"	website= " + website + "\n" +
				"	company= " + company.Info() +
				"}\n";
	}


}
