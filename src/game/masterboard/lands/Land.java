package game.masterboard.lands;

import java.util.HashSet;
import java.util.Set;

import game.characters.CharacterName;
import game.masterboard.Legion;

public abstract class Land {

	private LandName name;
	private Set<Edge> edges;

	private class Edge {
		EdgeType type;
		Land target;

		/**
		 * @param type   The type of edge.
		 * @param target The end land of the edge.
		 */
		public Edge(EdgeType type, Land target) {
			this.type = type;
			this.target = target;
		}

		/**
		 * @return the type
		 */
		public EdgeType getType() {
			return type;
		}

		/**
		 * @return the target
		 */
		public Land getTarget() {
			return target;
		}

		/**
		 * @return If a legion must start by following this edge.
		 */
		public boolean mustStart() {
			return this.type == EdgeType.Block;
		}

		/**
		 * @return If a legion can continue by following this edge.
		 */
		public boolean canContinue() {
			return this.type == EdgeType.Arrow || this.type == EdgeType.TrippleArrow;
		}

		/**
		 * @return If a legion must continue by following this edge.
		 */
		public boolean mustContinue() {
			return this.type == EdgeType.TrippleArrow;
		}
	}

	/**
	 * @param name The name of the land.
	 */
	public Land(LandName name) {
		this.name = name;
		this.edges = new HashSet<Edge>();
	}

	/**
	 * Returns a list of possible characters to muster on this land with a given
	 * legion.
	 * 
	 * @param legion The legion mustering.
	 * @return A list of possible characters to muster.
	 */
	public abstract Set<CharacterName> muster(Legion legion);

	/**
	 * Connects the land to an adjacent land.
	 * 
	 * @param land The adjacent land.
	 * @param type The type of connecting edge.
	 */
	public void addEdge(Land land, EdgeType type) {
		this.edges.add(new Edge(type, land));
	}

	/**
	 * @return the name
	 */
	public LandName getName() {
		return name;
	}
	
	/**
	 * @return The adjacent lands for continuing.
	 */
	public Set<Land> getContinueLands() {
		Set<Land> lands = new HashSet<Land>();
		boolean hasMandatory = false;
		for (Edge edge : this.edges) {
			if (edge.canContinue()) {
				if (edge.mustContinue() && !hasMandatory) {
					lands = new HashSet<Land>();
					hasMandatory = true;
				}

				if (edge.mustContinue() || !hasMandatory)
					lands.add(edge.getTarget());
			}
		}
		return lands;
	}

	/**
	 * @return The adjacent lands for starting.
	 */
	public Set<Land> getStartLands() {
		Set<Land> lands = new HashSet<Land>();
		boolean hasMandatory = false;
		for (Edge edge : this.edges) {
			if (edge.mustStart() && !hasMandatory) {
				lands = new HashSet<Land>();
				hasMandatory = true;
			}

			if (edge.mustStart() || !hasMandatory)
				lands.add(edge.getTarget());
		}
		return lands;
	}
}
