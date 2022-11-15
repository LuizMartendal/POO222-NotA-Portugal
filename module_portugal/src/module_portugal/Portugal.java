package module_portugal;

import java.awt.Image;
import java.nio.file.Path;

public class Portugal implements NationalTeamInfos{
	private String name = "Portugal";
	
	public Portugal() {}

	public String getName() {
		return this.name;
	}
	
	@Override
	public int getHowManyMembers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOldestPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYoungestPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAverageAge() {
		// TODO Auto-generated method stub
		return 0;
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
		return null;
	}
	
	
}
