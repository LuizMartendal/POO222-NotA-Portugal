
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Jogador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private String name;
	private String nickName;
	private int height;
	private double weight;
	private LocalDate birthDate;
	private String position;
	private String currentClub;
	
	public Jogador (int number, String name, String nickName, int height, double weight,
					LocalDate birthDate, String position, String currentClub) {
		this.setNumber(number);
		this.setName(name);
		this.setNickName(nickName);
		this.setHeight(height);
		this.setWeight(weight);
		this.setBirthDate(birthDate);
		this.setPosition(position);
		this.setCurrentClub(currentClub);
	}

	public int getNumber() {
		if (this.number > 0) {
			return number;
		}
		throw new IllegalArgumentException("Invalid number.");
	}

	public void setNumber(int number) {
		if (number > 0) {
			this.number = number;
		}else {
			throw new IllegalArgumentException("Invalid number.");
		}
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

	public int getHeight() {
		if (this.height > 0) {
			return height;
		}
		throw new IllegalArgumentException("Invalid height.");
	}

	public void setHeight(int height) {
		if (height > 0) {
			this.height = height;
		}else {
			throw new IllegalArgumentException("Invalid height.");
		}
	}

	public double getWeight() {
		if (this.weight > 0) {
			return weight;
		}
		throw new IllegalArgumentException("Invalid weight");
	}

	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		}else {
			throw new IllegalArgumentException("Invalid weight");
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
			throw new IllegalArgumentException("Birthdate is null.");
		}
	}

	public String getPosition() {
		if (this.position != null && !this.position.isBlank()) {
			return this.position;
		}
		throw new IllegalArgumentException("Position is null.");
	}

	public void setPosition(String position) {
		if (position != null && !position.isBlank()) {
			this.position = position;
		}else {
			throw new IllegalArgumentException("Position is null");
		}	
	}

	public String getCurrentClub() {
		if (this.currentClub != null && !this.currentClub.isBlank()) {
			return currentClub;
		}
		throw new IllegalArgumentException("Current club is null.");
	}

	public void setCurrentClub(String currentClub) {
		if (currentClub != null && !currentClub.isBlank()) {
			this.currentClub = currentClub;
		}else {
			throw new IllegalArgumentException("Current club is null.");
		}	
	}
	
	public int getIdade() {
		if (this.birthDate != null) {
			return Period.between(birthDate, LocalDate.now()).getYears();
		}
		throw new IllegalArgumentException("Birthdate is null.");
	}
	
}
