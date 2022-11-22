package module_portugal;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import fifa.NationalTeamStats;

public class Stats implements NationalTeamStats{
	private int questions;
	private ArrayList<Integer> callsToPlayer = new ArrayList<>();
	
	public void addHowManyQuestions() throws IOException {
		File f = new File("questions.txt");
		if (new File("questions.txt") != null) {
			try {
				FileReader fr = new FileReader(f);
				this.questions = fr.read();
				fr.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException eofe) {
				System.out.println("Fim do arquivo");
			}
		}
		this.questions++;
		FileWriter fw = new FileWriter("questions.txt");
		fw.write(questions);
		fw.close();
	}
	
	@Override
	public int getHowManyQuestions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHowManyCallsToPlayer(int number) {
		// TODO Auto-generated method stub
		return 0;
	}

}