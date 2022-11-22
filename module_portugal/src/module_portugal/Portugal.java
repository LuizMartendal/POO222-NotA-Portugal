package module_portugal;
import java.awt.Image;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import fifa.NationalTeamInfos;
import fifa.NationalTeamStats;

public class Portugal implements NationalTeamInfos{
	private static String name = "Portugal";
	private ArrayList<Jogador> players = new ArrayList<>();
	private ArrayList<ComissaoTecnica> commission = new ArrayList<>();
	private ArrayList<Dirigente> leaders = new ArrayList<>();
	private Stats stats = new Stats();
	
	public Portugal() {}
	
	@Override
	public int getHowManyMembers() {
		if (this.commission.isEmpty()) {
			try {
				this.setDados();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.commission.size();
	}

	@Override
	public int getOldestPlayer() {
		if (this.players.isEmpty()) {
			try {
				this.setDados();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    int older = 0;
	    int nr = 0;
	    for (Jogador j: this.players) {
	    	if (j.getIdade() > older) {
	    		older = j.getIdade();
	    		nr = j.getNumber();
	    	}
	    }
	    return nr;
	}

	@Override
	public int getYoungestPlayer() {
		if (this.players.isEmpty()) {
			try {
				this.setDados();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    int youngest = 150;
	    int nr = 0;
	    for (Jogador j: this.players) {
	    	if (j.getIdade() < youngest) {
	    		youngest = j.getIdade();
	    		nr = j.getNumber();
	    	}
	    }
	    return nr;
	}

	@Override
	public double getAverageAge() {
		if (players.isEmpty()) {
			try {
				this.setDados();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int amount = this.players.size();
		int sun = 0;
		for (Jogador j: players) {
			sun += j.getIdade();
		}
		return (double)sun / amount;
	}

	@Override
	public String getPlayer(int number) {
		String formJson = null;
		if (players.isEmpty()) {
			try {
				this.setDados();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boolean i = false;
		for (Jogador j: players) {
			if (j.getNumber() == number) {
				i = true;
			}
		}
		if (i) {
			Jogador player = players.get(number - 1);
			int numb = player.getNumber();
			String name = player.getName();
			String nickname = player.getNickName();
			int height = player.getHeight();
			double weight = player.getWeight();
			LocalDate birthDate = player.getBirthDate();
			String position = player.getPosition();
			String currentClub = player.getCurrentClub();
			
			formJson = "{number:\"" +numb+ "\", name:\"" +name+  "\", nickname:\"" +nickname+ "\", height:" +height+ ", weight:" +weight+ ", birthDate:\"" +birthDate+ "\", position:\"" +position+ "\", currentClub:\"" +currentClub+ "\"}";
			
			return formJson;
		}
		
	    return formJson;
	}

	@Override
	public String getPressOfficerContacts() {
		String formJson = null;
		if (leaders.isEmpty()) {
			try {
				this.setDados();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Dirigente leader = leaders.get(0);
		String name = leader.getName();
		String tel1 = leader.getTell1();
		String tel2 = leader.getTell2();
		String email = leader.getEmail();
		formJson = "{name:\"" +name+ "\", tel1:\"" +tel1+ "\", tel2:\"" +tel2+ "\", emailAccount:\"" +email+ "\"}";
		return formJson;
	}

	@Override
	public String getCountryName() {
		return Portugal.name;
	}

	@Override
	public Image getFlagImage() {
		Image i = null;
		try {
			i = ImageIO.read(new File("bandeira.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Path getTechnicalCommittee() {
		File f = new File("comissaoTecnica.json");
		Path path = f.toPath();
		return path;
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		return this.stats;
	}
	
	public void setDados() throws FileNotFoundException, IOException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("jogadores-dados.dat"))){
			while (true) {
				this.players.add((Jogador)ois.readObject()); 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException eofe) {
			System.out.println("Fim do arquivo.");
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("comissaoTecnica-dados.dat"))){
			while (true) {
				this.commission.add((ComissaoTecnica)ois.readObject()); 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException eofe) {
			System.out.println("Fim do arquivo.");
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dirigentes-dados.dat"))){
			while (true) {
				this.leaders.add((Dirigente)ois.readObject()); 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException eofe) {
			System.out.println("Fim do arquivo.");
		}
	}

}
