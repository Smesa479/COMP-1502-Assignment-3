package model;


/**
 * The Figure class represents a type of toy that is a figure.
 * It extends the base class Toy and includes additional properties such as the classification.
 */
public class Figure extends Toy {
    private String classification;
    
    /**
     * Constructs a Figure object with the specified attributes.
     *
     * @param serialNumber      The serial number of the figure.
     * @param name              The name of the figure.
     * @param brand             The brand of the figure.
     * @param price             The price of the figure.
     * @param availableCount    The available count of the figure.
     * @param ageAppropriate    The age appropriateness of the figure.
     * @param classification    The classification of the figure.
     */
    public Figure(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate, String classification) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.classification = classification;
    }
    
    
    
    public void setClassification(String classification) {
		this.classification = classification;
	}



	/**
     * Gets the classification of the figure.
     *
     * @return The classification of the figure.
     */
    public String getClassification() {
    	return classification;
    }
    
    /**
     * Returns a string representation of the Figure object.
     *
     * @return A string representation of the Figure object.
     */
    @Override
    public String toString() {
        return "Category: Figure "  + " (Serial Number: " + serialNumber + "Name: " + name + ", Brand: " + brand + ", Price: " + price +
                ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
                ", Classification: " + classification + ")";
    }
}


