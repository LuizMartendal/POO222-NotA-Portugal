
import java.awt.Image;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;

public class Portugal implements NationalTeamInfos{
	private String name = "Portugal";
	private ArrayList<Jogador> players = new ArrayList<>();
	private ArrayList<ComissaoTecnica> commission = new ArrayList<>();
	private ArrayList<Dirigente> leaders = new ArrayList<>();
	private Stats stats = new Stats();
	
	public Portugal() {}

	public String getName() {
		return this.name;
	}
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPressOfficerContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCountryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getFlagImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path getTechnicalCommittee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NationalTeamStats getStatsResponsible() {
		return this.stats;
	}
	
	public void setDados() throws FileNotFoundException, IOException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("jogadores-dados.json"))){
			while (true) {
				this.players.add((Jogador)ois.readObject()); 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException eofe) {
			System.out.println("Fim do arquivo.");
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("comissaoTecnica-dados.json"))){
			while (true) {
				this.commission.add((ComissaoTecnica)ois.readObject()); 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException eofe) {
			System.out.println("Fim do arquivo.");
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dirigentes-dados.json"))){
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
