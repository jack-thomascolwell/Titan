package game.masterboard.lands;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import game.characters.CharacterName;
import game.characters.Character;
import game.masterboard.Legion;

public class Tower extends Land {

	public Tower() {
		super(LandName.Tower);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Gargoyle);
		available.add(CharacterName.Centaur);
		available.add(CharacterName.Ogre);

		if (legion.contains(CharacterName.Titan))
			available.add(CharacterName.Warlock);
		
		Character[] characters = legion.toArray();
		Map<CharacterName, Integer> counts = new HashMap<CharacterName, Integer>();
		int maxCount = 0;
		for (Character character: characters) {
			int count = 1 + counts.getOrDefault(character.getName(), 0);
			if (count > maxCount) maxCount = count;
			counts.put(character.getName(), count);
		}
		
		if (maxCount >= 3)
			available.add(CharacterName.Guardian);
		
		return available;
	}

}
