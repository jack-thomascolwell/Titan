package game.masterboard;

import java.util.HashSet;
import java.util.Set;

import game.characters.Character;
import game.characters.CharacterName;

public class Legion {

	private Set<Character> characters;

	/*
	 * Creates an empty legion.
	 */
	public Legion() {
		this.characters = new HashSet<Character>();
	}

	/**
	 * Adds a character to the legion if there is room.
	 * 
	 * @param character The character to be added to the legion.
	 * @return If the character was successfully added to the legion.
	 */
	public boolean add(Character character) {
		if (this.characters.size() >= 7)
			return false;

		this.characters.add(character);
		return true;
	}

	/**
	 * Checks if the legion contains a character.
	 * 
	 * @param name The name of the character to be checked.
	 * @return If the legion contains the character.
	 */
	public boolean contains(CharacterName name) {
		for (Character character : this.characters)
			if (character.getName().equals(name))
				return true;

		return false;
	}
	
	/**
	 * Checks if the legion contains a specific character object.
	 * @param character The character to be checked.
	 * @return If the legion contains the character.
	 */
	public boolean contains(Character character) {
		for (Character c : this.characters)
			if (c.equals(character))
				return true;
		return false;
	}

	/**
	 * Counts the number of characters in the legion with a given name.
	 * 
	 * @param name The name of the characters to be counted.
	 * @return The number of characters with the given name.
	 */
	public int count(CharacterName name) {
		int count = 0;
		for (Character character : this.characters)
			if (character.getName().equals(name))
				count++;
		return count;
	}

}
