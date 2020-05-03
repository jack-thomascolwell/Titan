package game.characters;

public abstract class Character {

	private CharacterType type;
	private CharacterName name;
	private int powerFactor, skillFactor;
	private boolean flying, ranged;

	/**
	 * @param type        The type of the character
	 * @param name        The name of the character
	 * @param powerFactor The character's power factor
	 * @param skillFactor The character's skill factor
	 * @param flying      If the character can fly
	 * @param ranged      If the character can rangedStrike
	 */
	public Character(CharacterType type, CharacterName name, int powerFactor, int skillFactor, boolean flying,
			boolean ranged) {
		this.type = type;
		this.name = name;
		this.powerFactor = powerFactor;
		this.skillFactor = skillFactor;
		this.flying = flying;
		this.ranged = ranged;
	}

	/**
	 * @return the type
	 */
	public CharacterType getType() {
		return type;
	}

	/**
	 * @return the name
	 */
	public CharacterName getName() {
		return name;
	}

	/**
	 * @return the powerFactor
	 */
	public int getPowerFactor() {
		return powerFactor;
	}

	/**
	 * @return the skillFactor
	 */
	public int getSkillFactor() {
		return skillFactor;
	}

	/**
	 * @return the flying
	 */
	public boolean isFlying() {
		return flying;
	}

	/**
	 * @return the ranged
	 */
	public boolean isRanged() {
		return ranged;
	}

	/**
	 * @return the value in points
	 */
	public int getValue() {
		return this.skillFactor * this.powerFactor;
	}

	/**
	 * @return the ranged strength
	 */
	public int getRangedStrength() {
		return this.powerFactor / 2;
	}
}
