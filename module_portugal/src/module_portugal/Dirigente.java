package module_portugal;

import java.io.Serializable;

public class Dirigente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String tell1;
	private String tell2;
	private String email;
	
	public Dirigente (String name, String tell1, String tell2, String email) {
		this.setName(name);
		this.setTell1(tell1);
		this.setTell2(tell2);
		this.setEmail(email);
	}

	public String getName() {
		if (this.name != null && !this.name.isBlank()) {
			return name;
		}
		throw new IllegalArgumentException("Name is null");
	}

	public void setName(String name) {
		if (name != null && !name.isBlank()) {
			this.name = name;
		}else {
			throw new IllegalArgumentException("Name is null");
		}
	}

	public String getTell1() {
		if (this.tell1 != null && !this.tell1.isBlank()) {
			return this.tell1;
		}
		throw new IllegalArgumentException("Tell1 is null");
	}

	public void setTell1(String tell1) {
		if (tell1 != null && !tell1.isBlank()) {
			this.tell1 = tell1;
		}else {
			throw new IllegalArgumentException("Tell1 is null");
		}
	}

	public String getTell2() {
		if (this.tell2 != null && !this.tell2.isBlank()) {
			return this.tell2;
		}
		throw new IllegalArgumentException("Tell2 is null");
	}

	public void setTell2(String tell2) {
		if (tell2 != null && !tell2.isBlank()) {
			this.tell2 = tell2;
		}else {
			throw new IllegalArgumentException("Tell2 is null");
		}
	}

	public String getEmail() {
		if (this.email != null && !this.email.isBlank()) {
			return this.email;
		}
		throw new IllegalArgumentException("Email is null");
	}

	public void setEmail(String email) {
		if (email != null && !email.isBlank()) {
			this.email = email;
		}else {
			throw new IllegalArgumentException("Email is null");
		}
	}
}
