package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Desert extends Land {

	public Desert(LandName name) {
		super(LandName.Desert);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int lionCount = legion.count(CharacterName.Lion);
		int griffonCount = legion.count(CharacterName.Griffon);
		int rangerCount = legion.count(CharacterName.Ranger);

		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Lion);
		if (griffonCount > 0 || rangerCount > 0 || lionCount >= 3)
			available.add(CharacterName.Griffon);
		if (rangerCount > 0 || griffonCount >= 2)
			available.add(CharacterName.Ranger);
		return available;
	}

}
