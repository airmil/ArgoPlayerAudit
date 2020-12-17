/**
 * 
 */
package ddo.argonnessen.argonauts.playeraudit;


/**
 * 
 */
public class Clazz implements Named {

	/**
	 * 
	 */
	String name;
	/**
	 * 
	 */
	Integer level;

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
}
