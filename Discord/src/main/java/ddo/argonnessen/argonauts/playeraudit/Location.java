/**
 * 
 */
package ddo.argonnessen.argonauts.playeraudit;


/**
 * 
 */
public class Location {

	/**
	 * 
	 */
	String hexId;
	/**
	 * 
	 */
	String name;
	/**
	 * 
	 */
	Boolean isPublicSpace;
	/**
	 * 
	 */
	String region;

	/**
	 * @return the hexId
	 */
	public String getHexId() {
		return hexId;
	}

	/**
	 * @param hexId
	 *            the hexId to set
	 */
	public void setHexId(String hexId) {
		this.hexId = hexId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isPublicSpace
	 */
	public Boolean getIsPublicSpace() {
		return isPublicSpace;
	}

	/**
	 * @param isPublicSpace
	 *            the isPublicSpace to set
	 */
	public void setIsPublicSpace(Boolean isPublicSpace) {
		this.isPublicSpace = isPublicSpace;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
}
