package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Hills extends Land {

	public Hills() {
		super(LandName.Hills);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int ogreCount = legion.count(CharacterName.Centaur);
		int minotaurCount = legion.count(CharacterName.Lion);
		int unicornCount = legion.count(CharacterName.Ranger);

		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Ogre);
		if (minotaurCount > 0 || unicornCount > 0 || ogreCount >= 3)
			available.add(CharacterName.Minotaur);
		if (unicornCount > 0 || minotaurCount >= 2)
			available.add(CharacterName.Unicorn);
		return available;
	}

}
