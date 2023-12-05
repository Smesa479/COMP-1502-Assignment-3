package model;

import controller.AppManager;


/**
 * The Toy class is an abstract class representing a generic toy.
 * It serves as the base class for specific types of toys such as Animal, BoardGame, Figure, and Puzzle.
 */
public abstract class Toy {
    protected long serialNumber;
    protected String name;
    protected String brand;
    protected double price;
    protected int availableCount;
    protected int ageAppropriate;

    /**
     * Constructs a Toy object with the specified attributes.
     *
     * @param serialNumber      The serial number of the toy.
     * @param name              The name of the toy.
     * @param brand             The brand of the toy.
     * @param price             The price of the toy.
     * @param availableCount    The available count of the toy.
     * @param ageAppropriate    The age appropriateness of the toy.
     */
    public Toy(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate) {
    	
        this.serialNumber = serialNumber;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.availableCount = availableCount;
        this.ageAppropriate = ageAppropriate;
    }
    
    /**
     * Sets the serial number of the toy.
     *
     * @param serialNumber The serial number to set.
     */
    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    /**
     * Gets the serial number of the toy.
     *
     * @return The serial number of the toy.
     */

    public long getSerialNumber() {
        return serialNumber;
    }
    
    /**
     * Sets the name of the toy.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the name of the toy.
     *
     * @return The name of the toy.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the brand of the toy.
     *
     * @param brand The brand to set.
     */
    public void setBrand(String brand) {
    	this.brand = brand;
    }
    
    /**
     * Gets the brand of the toy.
     *
     * @return The brand of the toy.
     */
    
    public String getBrand() {
    	return brand;
    }
    
    /**
     * Sets the price of the toy.
     *
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Gets the price of the toy.
     *
     * @return The price of the toy.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Sets the available count of the toy.
     *
     * @param availableCount The available count to set.
     */
    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }
    
    /**
     * Gets the available count of the toy.
     *
     * @return The available count of the toy.
     */
    public int getAvailableCount() {
        return availableCount;
    }
    
    /**
     * Sets the age appropriateness of the toy.
     *
     * @param ageAppropriate The age appropriateness to set.
     */
    public void setAgeAppropriate(int ageAppropriate) {
        this.ageAppropriate = ageAppropriate;
    }
    
    /**
     * Gets the age appropriateness of the toy.
     *
     * @return The age appropriateness of the toy.
     */
    public int getAgeAppropriate() {
        return ageAppropriate;
    }

	@Override
	public String toString() {
		return "Toy [serialNumber=" + serialNumber + ", name=" + name + ", brand=" + brand + ", price=" + price
				+ ", availableCount=" + availableCount + ", ageAppropriate=" + ageAppropriate + "]";
	}
	
}
	
