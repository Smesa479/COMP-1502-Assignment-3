package model;

/**
 * The Animal class represents a type of toy that is an animal.
 * It extends the base class Toy and includes additional properties such as material and size.
 */
public class Animal extends Toy {
    private String material;
    private String size;
    
    
    /**
     * Constructs an Animal object with the specified attributes.
     *
     * @param serialNumber    The serial number of the animal toy.
     * @param name            The name of the animal toy.
     * @param brand           The brand of the animal toy.
     * @param price           The price of the animal toy.
     * @param availableCount  The available count of the animal toy.
     * @param ageAppropriate  The age appropriateness of the animal toy.
     * @param material        The material of the animal toy.
     * @param size            The size of the animal toy.
     */
    public Animal(long serialNumber, String name, String brand, double price, int availableCount, int ageAppropriate, String material, String size) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.material = material;
        this.size = size;
    }
    /**
     * Gets the material of the animal toy.
     *
     * @return The material of the animal toy.
     */
    public String getMaterial() {
      return material;
  }
    
    /**
     * Gets the size of the animal toy.
     *
     * @return The size of the animal toy.
     */
  public String getSize() {
      return size;
  }

  // Setters
  /**
   * Sets the material of the animal toy.
   *
   * @param material The new material for the animal toy.
   */
  public void setMaterial(String material) {
      this.material = material;
  }
  /**
   * Sets the size of the animal toy.
   *
   * @param size The new size for the animal toy.
   */
  public void setSize(String size) {
      this.size = size;
  }
  /**
   * Returns a string representation of the Animal object.
   *
   * @return A string representation of the Animal object.
   */
    @Override
    public String toString() {
        return "Category: Animal" + " (Serial Number: " + "Name: " + name  + serialNumber + ", Brand: " + brand + ", Price: " + price +
                ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
                ", Material: " + material + ", Size: " + size + ")";
    }
}

