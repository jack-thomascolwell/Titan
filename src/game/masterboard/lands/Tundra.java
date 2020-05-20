package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Tundra extends Land {

	public Tundra() {
		super(LandName.Tundra);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int trollCount = legion.count(CharacterName.Lion);
		int warbearCount = legion.count(CharacterName.Warbear);
		int giantCount = legion.count(CharacterName.Giant);
		int colossusCount = legion.count(CharacterName.Colossus);

		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Troll);
		if (warbearCount > 0 || giantCount > 0 || colossusCount > 0 || trollCount >= 2)
			available.add(CharacterName.Warbear);
		if (colossusCount > 0 || giantCount > 0 || warbearCount >= 2)
			available.add(CharacterName.Giant);
		if (colossusCount > 0 || giantCount >= 2)
			available.add(CharacterName.Colossus);
		return available;
	}

}
