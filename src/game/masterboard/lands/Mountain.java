package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Mountain extends Land {

	public Mountain() {
		super(LandName.Mountain);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int lionCount = legion.count(CharacterName.Lion);
		int minotaurCount = legion.count(CharacterName.Minotaur);
		int dragonCount = legion.count(CharacterName.Dragon);
		int colossusCount = legion.count(CharacterName.Colossus);

		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Lion);
		if (minotaurCount > 0 || dragonCount > 0 || colossusCount > 0 || lionCount >= 2)
			available.add(CharacterName.Minotaur);
		if (colossusCount > 0 || dragonCount > 0 || minotaurCount >= 2)
			available.add(CharacterName.Dragon);
		if (colossusCount > 0 || dragonCount >= 2)
			available.add(CharacterName.Colossus);
		return available;
	}

}
