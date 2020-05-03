package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Woods extends Land {

	public Woods(LandName name) {
		super(LandName.Woods);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int centaurCount = legion.count(CharacterName.Centaur);
		int warbearCount = legion.count(CharacterName.Warbear);
		int unicornCount = legion.count(CharacterName.Unicorn);

		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Centaur);
		if (warbearCount > 0 || unicornCount > 0 || centaurCount >= 3)
			available.add(CharacterName.Warbear);
		if (unicornCount > 0 || warbearCount >= 2)
			available.add(CharacterName.Unicorn);
		return available;
	}

}
