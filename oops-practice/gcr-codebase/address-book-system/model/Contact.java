package model;


public class Contact {
	private String id;
	private String firstname;
	private String lastname;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String email;

	public Contact(String id, String firstname, String lastname, String phone, String email) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
	}

	public Contact(String id, String firstname, String lastname, String phone, String address, String city, String state, String zip, String email) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getFirstName() { return firstname; }
	public void setFirstName(String firstname) { this.firstname = firstname; }

	public String getLastName() { return lastname; }
	public void setLastName(String lastname) { this.lastname = lastname; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }

	public String getState() { return state; }
	public void setState(String state) { this.state = state; }

	public String getZip() { return zip; }
	public void setZip(String zip) { this.zip = zip; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Contact[id=").append(id)
		  .append(", name=").append(firstname).append(" ").append(lastname)
		  .append(", phone=").append(phone)
		  .append(", email=").append(email);
		if (address != null) sb.append(", address=").append(address);
		if (city != null) sb.append(", city=").append(city);
		if (state != null) sb.append(", state=").append(state);
		if (zip != null) sb.append(", zip=").append(zip);
		sb.append("]");
		return sb.toString();
	}

}