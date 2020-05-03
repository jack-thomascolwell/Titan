package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public class Brush extends Land {

	public Brush() {
		super(LandName.Brush);
	}

	@Override
	public Set<CharacterName> muster(Legion legion) {
		int gargoyleCount = legion.count(CharacterName.Gargoyle);
		int cyclopsCount = legion.count(CharacterName.Cyclops);
		int gorgonCount = legion.count(CharacterName.Gorgon);
		
		Set<CharacterName> available = new HashSet<CharacterName>();
		available.add(CharacterName.Gargoyle);
		if (cyclopsCount > 0 || gorgonCount > 0 || gargoyleCount >=2)
			available.add(CharacterName.Cyclops);
		if (gorgonCount > 0 || cyclopsCount >= 2)
			available.add(CharacterName.Gorgon);
		return available;
	}

}
