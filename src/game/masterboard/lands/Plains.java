package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Plains extends Land {

	public Plains(LandName name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int centaurCount = legion.count(CharacterName.Centaur);
		int lionCount = legion.count(CharacterName.Lion);
		int rangerCount = legion.count(CharacterName.Ranger);

		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Centaur);
		if (lionCount > 0 || rangerCount > 0 || centaurCount >= 2)
			available.add(CharacterName.Lion);
		if (rangerCount > 0 || lionCount >= 2)
			available.add(CharacterName.Ranger);
		return available;
	}

}
