package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Jungle extends Land {

	public Jungle() {
		super(LandName.Jungle);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int gargoyleCount = legion.count(CharacterName.Gargoyle);
		int cyclopsCount = legion.count(CharacterName.Cyclops);
		int behemothCount = legion.count(CharacterName.Behemoth);
		int serpentCount = legion.count(CharacterName.Serpent);
		
		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Gargoyle);
		if (cyclopsCount > 0 || behemothCount > 0 || serpentCount > 0 || gargoyleCount >= 2)
			available.add(CharacterName.Cyclops);
		if (behemothCount > 0 || serpentCount > 0 || cyclopsCount >= 3)
			available.add(CharacterName.Behemoth);
		if (serpentCount > 0 || behemothCount >= 2)
			available.add(CharacterName.Serpent);
		return available;
	}

}
