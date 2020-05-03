package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Marsh extends Land {

	public Marsh(LandName name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int ogreCount = legion.count(CharacterName.Ogre);
		int trollCount = legion.count(CharacterName.Troll);
		int rangerCount = legion.count(CharacterName.Ranger);

		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Ogre);
		if (trollCount > 0 || rangerCount > 0 || ogreCount >= 2)
			available.add(CharacterName.Troll);
		if (rangerCount > 0 || trollCount >= 2)
			available.add(CharacterName.Ranger);
		return available;
	}

}
