package model;

/**
 * The BoardGame class represents a type of toy that is a board game.
 * It extends the base class Toy and includes additional properties such as the number of players, minimum and maximum number of players, and author.
 */
public class BoardGame extends Toy {
	private int minNumOfPlayers;
    private int maxNumOfPlayers;
    private String numOfPlayers;
    private String author;

    /**
     * Constructs a BoardGame object with the specified attributes.
     *
     * @param serialNumber      The serial number of the board game.
     * @param name              The name of the board game.
     * @param brand             The brand of the board game.
     * @param price             The price of the board game.
     * @param availableCount    The available count of the board game.
     * @param ageAppropriate    The age appropriateness of the board game.
     * @param numOfPlayers      The number of players the board game is designed for.
     * @param author            The author of the board game.
     */
    public BoardGame(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate,  String numOfPlayers, String author) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
//        this.minNumOfPlayers = minNumOfPlayers;
//        this.maxNumOfPlayers = maxNumOfPlayers;
        this.numOfPlayers = numOfPlayers;
        this.author = author;
    }
    
    /**
     * Sets the number of players the board game is designed for.
     *
     * @param numOfPlayers The new number of players for the board game.
     */

    public void setNumOfPlayers(String numOfPlayers) {
    	this.numOfPlayers = numOfPlayers;
    }
    /**
     * Gets the number of players the board game is designed for.
     *
     * @return The number of players the board game is designed for.
     */
    public String getNumOfPlayers() {
    	return numOfPlayers;
    }
    public void setMinNumOfPlayers(int minNumOfPlayers) {
    	this.minNumOfPlayers = minNumOfPlayers;
    }
    public int getMinNumOfPlayers() {
    	return minNumOfPlayers;
    }
    
    public void setMaxNumOfPlayers(int maxNumOfPlayers) {
    	this.maxNumOfPlayers = maxNumOfPlayers;
    }
    public int getMaxNumOfPlayers() {
    	return maxNumOfPlayers;
    }
    
    /**
     * Sets the author of the board game.
     *
     * @param author The new author for the board game.
     */
    public void setAuthor(String author) {
      this.author = author;
    }
    
    /**
     * Gets the author of the board game.
     *
     * @return The author of the board game.
     */
    public String getAuthor() {
      return author;
    }

    /**
     * Returns a string representation of the BoardGame object.
     *
     * @return A string representation of the BoardGame object.
     */
    @Override
    public String toString() {
        return "Category: BoardGame: " + " (Serial Number: " + serialNumber + "Name: " + name +  ", Brand: " + brand + ", Price: " + price +
                ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
                ", Num of Players: " + numOfPlayers  + ", Author: " + author + ")";
    }
}


