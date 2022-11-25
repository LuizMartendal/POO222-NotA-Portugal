package module_portugal;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import fifa.NationalTeamStats;

public class Stats implements NationalTeamStats{
	
	public void addHowManyQuestions() throws IOException {
		int questions = 0;
		if (new File("questions_portugal.dat").canRead()) {
			try (FileInputStream fis = new FileInputStream("questions_portugal.dat")){
				questions += fis.read();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException eofe) {
				System.out.println("Fim do arquivo.");
			} 
		}
		questions++;
		try (FileOutputStream fos = new FileOutputStream("questions_portugal.dat")) {
			fos.write(questions);
		}
	}
	
	@Override
	public int getHowManyQuestions() {
		int questions = 0;
		if (new File("questions_portugal.dat").canRead()) {
			try (FileInputStream fis = new FileInputStream("questions_portugal.dat")) {
				DataInputStream dis = new DataInputStream(fis);
				questions = dis.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return questions;
	}
	
	public void addHowManyCallsToPlayer(int number) throws IOException {
		ArrayList<Integer> callsToPlayer = new ArrayList<>();
		int indice = number - 1;
		int element = 0;
		if (number <= 0 && number > 11) {
			throw new IllegalArgumentException("Jogador não listado");
		}
		if (new File("callsToPlayer_portugal.dat").canRead()) {
			try (FileInputStream fis = new FileInputStream("callsToPlayer_portugal.dat")){
				DataInputStream dis = new DataInputStream(fis);
				while (true) {
					callsToPlayer.add(dis.readInt());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException eofe) {
				System.out.println("Fim do arquivo.");
			}

			element = callsToPlayer.get(indice);
			callsToPlayer.remove(indice);
		}else {
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
			callsToPlayer.add(0);
		}
		element++;
		callsToPlayer.add(indice, element);
		
		try (FileOutputStream fos = new FileOutputStream("callsToPlayer_portugal.dat")) {
			DataOutputStream dos = new DataOutputStream(fos);
			for (int i = 0; i < callsToPlayer.size(); i++) {
				dos.writeInt(callsToPlayer.get(i));
			}
		} 
	}
	
	@Override
	public int getHowManyCallsToPlayer(int number) {
		ArrayList<Integer> callsToPlayer = new ArrayList<>();
		int amount = 0;
		if (number <= 0 && number > 11) {
			return 0;
		}
		if (new File("callsToPlayer_portugal.dat").canRead()) {
			try (FileInputStream fis = new FileInputStream("callsToPlayer_portugal.dat")){
				DataInputStream dis = new DataInputStream(fis);
				while (true) {
					callsToPlayer.add(dis.readInt());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EOFException eofe) {
				System.out.println("Fim do arquivo.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int indice = number - 1;
			amount = callsToPlayer.get(indice);
		}
		return amount;
	}

}