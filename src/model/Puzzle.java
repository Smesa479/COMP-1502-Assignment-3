package model;


/**
 * The Puzzle class represents a type of toy that is a puzzle.
 * It extends the base class Toy and includes additional properties such as the puzzle type.
 */
public class Puzzle extends Toy {
    

	private String puzzleType;
    
    /**
     * Constructs a Puzzle object with the specified attributes.
     *
     * @param serialNumber      The serial number of the puzzle.
     * @param name              The name of the puzzle.
     * @param brand             The brand of the puzzle.
     * @param price             The price of the puzzle.
     * @param availableCount    The available count of the puzzle.
     * @param ageAppropriate    The age appropriateness of the puzzle.
     * @param puzzleType        The type of the puzzle.
     */
    public Puzzle(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate, String puzzleType) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.puzzleType = puzzleType;
    }
    
    public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
    /**
     * Gets the type of the puzzle.
     *
     * @return The type of the puzzle.
     */
    public String getPuzzleType() {
    	return puzzleType;
    }
    
    /**
     * Returns a string representation of the Puzzle object.
     *
     * @return A string representation of the Puzzle object.
     */
    @Override
    public String toString() {
        return "Category: Puzzle " + " (Serial Number: " + serialNumber + "Name: " + name + ", Brand: " + brand + ", Price: " + price +
                ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
                ", Puzzle Type: " + puzzleType + ")";
    }
}




