package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Swamp extends Land {

	public Swamp() {
		super(LandName.Swamp);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int trollCount = legion.count(CharacterName.Centaur);
		int wyvernCount = legion.count(CharacterName.Lion);
		int hydraCount = legion.count(CharacterName.Ranger);

		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Troll);
		if (wyvernCount > 0 || hydraCount > 0 || trollCount >= 3)
			available.add(CharacterName.Wyvern);
		if (hydraCount > 0 || wyvernCount >= 2)
			available.add(CharacterName.Hydra);
		return available;
	}

}
