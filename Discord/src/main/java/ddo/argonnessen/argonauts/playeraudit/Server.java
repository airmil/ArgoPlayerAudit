package ddo.argonnessen.argonauts.playeraudit;

import java.sql.Timestamp;
import java.util.Set;

/**
 * 
 */
public class Server {

	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	Timestamp lastUpdateTime;
	/**
	 * 
	 */
	Long creationIndex;
	/**
	 * 
	 */
	Integer population;
	/**
	 * 
	 */
	Set<Player> players;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastUpdateTime
	 */
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime
	 *            the lastUpdateTime to set
	 */
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return the creationIndex
	 */
	public Long getCreationIndex() {
		return creationIndex;
	}

	/**
	 * @param creationIndex
	 *            the creationIndex to set
	 */
	public void setCreationIndex(Long creationIndex) {
		this.creationIndex = creationIndex;
	}

	/**
	 * @return the population
	 */
	public Integer getPopulation() {
		return population;
	}

	/**
	 * @param population
	 *            the population to set
	 */
	public void setPopulation(Integer population) {
		this.population = population;
	}

	/**
	 * @return the players
	 */
	public Set<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players
	 *            the players to set
	 */
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
}
