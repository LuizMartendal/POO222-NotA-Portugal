package module_portugal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class ComissaoTecnica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String nickName;
	private String function;
	private LocalDate birthDate;
	
	public ComissaoTecnica(String name, String nickName, String function, 
							LocalDate birthDate) {
		this.setName(name);
		this.setNickName(nickName);
		this.setFunction(function);
		this.setBirthDate(birthDate);
	}

	public String getName() {
		if (this.name != null && !this.name.isBlank()) {
			return name;
		}
		throw new IllegalArgumentException("Name is null.");
	}

	public void setName(String name) {
		if (name != null && !name.isBlank()) {
			this.name = name;
		}else {
			throw new IllegalArgumentException("Name is null.");
		}
	}

	public String getNickName() {
		if (this.nickName != null && !this.nickName.isBlank()) {
			return nickName;
		}
		throw new IllegalArgumentException("Nickname is null.");
	}

	public void setNickName(String nickName) {
		if (nickName != null && !nickName.isBlank()) {
			this.nickName = nickName;
		}else {
			throw new IllegalArgumentException("Nickname is null.");
		}
	}

	public String getFunction() {
		if (this.function != null && !this.function.isBlank()) {
			return function;
		}
		throw new IllegalArgumentException("Function is null.");
	}

	public void setFunction(String function) {
		if (function != null && !function.isBlank()) {
			this.function = function;
		}else {
			throw new IllegalArgumentException("Function is null.");
		}
	}

	public LocalDate getBirthDate() {
		if (this.birthDate != null) {
			return birthDate;
		}
		throw new IllegalArgumentException("Birthdate is null.");
	}

	public void setBirthDate(LocalDate birthDate) {
		if (birthDate != null) {
			this.birthDate = birthDate;
		}else {
			throw new IllegalArgumentException("birthDate is null.");
		}
	}
	
	public int getIdade() {
		if (this.birthDate != null) {
			return Period.between(birthDate, LocalDate.now()).getYears();
		}
		throw new IllegalArgumentException("Birthdate is null.");
	}
}
