package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Animal;
import model.BoardGame;
import model.Figure;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;



import model.Puzzle;
import model.Toy;


public class AppManager {
	
	private final String FILE_PATH = "res/toys.txt";
    
//    private Toy toy;
       
    
    @FXML
    private Button btnBuy;

    @FXML
    private Button btnClear;
    
    @FXML
    private Button removebutton;

	
	  @FXML
	    private RadioButton Name;

	    @FXML
	    private TextField NameFIeld;
	    
	    @FXML
	    private TextField SNSTD;
	    
	    @FXML
	    private TextField Types;


	    @FXML
	    private RadioButton SN;

	    @FXML
	    private RadioButton Type;

	    @FXML
	    private Button btnDisplay;

	    @FXML
	    private ListView<String> lvnames;
	    
	    private List<Toy> toys;
	    

	    @FXML
	    void NameFIields(ActionEvent event) {
	    	
	    	 if (Name.isSelected()) {
	    	        // Update the UI or perform actions specific to the Name radio button
	    		 NameFIeld.setPromptText("Enter Name here"); // Set the prompt text for NameField
	    	    }

	    }

	    @FXML
	    void Names(ActionEvent event) {

	    }
	    
	    @FXML
	    void SNS(ActionEvent event) {

	    }

	    @FXML
	    void SNST(ActionEvent event) {
	    	
	    	if (SN.isSelected()) {
	    		SNSTD.setPromptText("Enter Serial Number:");
	        }

	    }

	    @FXML
	    void Types(ActionEvent event) {

	    }
	    
	    @FXML
	    void Typesa(ActionEvent event) {

	    }
	    
	    
	    
	    /**
	     * Handles the event when the user clicks the "Buy" button.
	     * Retrieves the selected item from the ListView, updates its count, and
	     * reflects the changes in the UI and data file.
	     *
	     * @param event The ActionEvent triggered by clicking the "Buy" button.
	     */
	    
	    @FXML
	    void btnHandlerB(ActionEvent event) {
	        // Get the selected item from the ListView
	        String selectedItem = lvnames.getSelectionModel().getSelectedItem();

	        if (selectedItem != null) {
	            // Split the selected item to extract the relevant information
	            String[] parts = selectedItem.split(", ");
	            Long serialNumber = Long.parseLong(parts[1].substring(parts[1].indexOf(":") + 2)); // Extracting serial number
	            String name = parts[2].substring(parts[2].indexOf(":") + 2); // Extracting name
	            String brand = parts[3].substring(parts[3].indexOf(":") + 2); // Extracting brand
	            Double price = Double.parseDouble(parts[4].substring(parts[4].indexOf(":") + 2)); // Extracting price
	            int count = Integer.parseInt(parts[5].substring(parts[5].indexOf(":") + 2)); // Extracting count
	            int ageAppropriate = Integer.parseInt(parts[6].substring(parts[6].indexOf(":") + 2)); // Extracting age
	            String category = parts[0].substring(parts[0].indexOf(":") + 2); // Extracting category

	            // Update the count value
	            count--;

	            // Update the ListView
	            lvnames.getItems().remove(selectedItem);
	            lvnames.getItems().add(String.format("Category: %s, Serial Number: %d, Name: %s, Brand: %s, Price %f, Count: %d, Age_Appro: %d",
	                    category, serialNumber, name, brand, price, count, ageAppropriate));

	            // Update the text file
	            updateTextFile(serialNumber, name, brand, price, count, ageAppropriate, category);
	        }
	    }
	    
	    /**
	     * Removes the selected item from the ListView and updates the data file accordingly.
	     *
	     * @param serialNumber The serial number of the toy to be removed.
	     * @param name         The name of the toy to be removed.
	     * @param brand        The brand of the toy to be removed.
	     * @param price        The price of the toy to be removed.
	     * @param count        The count of the toy to be removed.
	     * @param ageAppropriate The age appropriateness of the toy to be removed.
	     * @param category      The category of the toy to be removed.
	     */

	    private void updateTextFile(Long serialNumber, String name, String brand, Double price, int count, int ageAppropriate, String category) {
	        try {
	            List<String> lines = new ArrayList<>();
	            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
	            String line;

	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(";");
	                Long currentSerialNumber = Long.parseLong(parts[0].trim());
	                String currentName = parts[1].trim();
	                String currentBrand = parts[2].trim();
	                Double currentPrice = Double.parseDouble(parts[3].trim());
	                int currentCount = Integer.parseInt(parts[4].trim()) - 1;
	                int currentAgeAppropriate = Integer.parseInt(parts[5].trim());

//	                if (currentSerialNumber == serialNumber && currentName.equals(name) && currentBrand.equals(brand) && currentPrice.equals(price) && currentAgeAppropriate == ageAppropriate) {
//	                    // Update the count value
//	                    parts[4] = String.valueOf(currentCount);
//	                }
	                
	                parts[4] = String.valueOf(currentCount);
	                lines.add(String.join(";", parts));
	            }

	            reader.close();

	            // Write the updated lines back to the file
	            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
	            for (String updatedLine : lines) {
	                writer.write(updatedLine);
	                writer.newLine();
	            }

	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle exceptions appropriately
	        }
	    }






	    /**
	     * Clears the ListView and resets the text fields and radio buttons to their default state.
	     *
	     * @param event The ActionEvent triggered by clicking the "Clear" button.
	     */

	    @FXML
	    void btnHandlerC(ActionEvent event) {
	    	
	    	lvnames.getItems().clear();

	        // Clear the text fields
	        NameFIeld.clear();
	        SNSTD.clear();
	        Types.clear();

	        // Unselect the radio buttons
	        Name.setSelected(false);
	        SN.setSelected(false);
	        Type.setSelected(false);

	    }
	    
	    
	    /**
	     * Handles the event when the user clicks the "Display" button.
	     * Filters the toy data based on user input and updates the ListView accordingly.
	     *
	     * @param event The ActionEvent triggered by clicking the "Display" button.
	     */
    @FXML
    void btnHandler(ActionEvent event) {
    	
    	filterAndDisplayResults();
    	 

    }
    
    /**
     * Filters the toy data based on user input and updates the ListView with the results.
     */
    private void filterAndDisplayResults() {
        String searchTerm = NameFIeld.getText().toLowerCase();
        String searchSerial = SNSTD.getText().toLowerCase();
        String searchType = Types.getText().toLowerCase();

        List<String> filteredResults = toys.stream()
                .filter(toy -> matchesCriteria(toy, searchTerm, searchSerial, searchType))
                .map(this::formatToy)
                .collect(Collectors.toList());

        lvnames.getItems().setAll(filteredResults);
    }
    
    /**
     * Checks if the given toy matches the specified criteria based on user input.
     *
     * @param toy               The toy to be checked.
     * @param searchTerm        The search term for toy name.
     * @param searchSerialNumber The search term for toy serial number.
     * @param searchType        The search term for toy brand/type.
     * @return True if the toy matches the criteria, false otherwise.
     */
    private boolean matchesCriteria(Toy toy, String searchTerm, String searchSerialNumber, String searchType) {
        if (Name.isSelected()) {
            return toy.getName().toLowerCase().contains(searchTerm);
        } else if (SN.isSelected()) {
            return String.valueOf(toy.getSerialNumber()).contains(searchSerialNumber);
        } else if (Type.isSelected()) {
            return toy.getBrand().toLowerCase().contains(searchType);
        }
        return false;
    }
    
    
    /**
     * Formats the toy information for display in the ListView.
     *
     * @param toy The toy to be formatted.
     * @return A formatted string representing the toy information.
     */
    private String formatToy(Toy toy) {
    	if (toy instanceof BoardGame) {
    		BoardGame boardgame = (BoardGame) toy;
            return String.format("Category: BoardGame, Serial Number: %d, Name: %s, Brand: %s, Price: %f, Available Count: %d, Age Appropiate: %d, Num of Players: %s, Author: %s",
            		toy.getSerialNumber(), toy.getName(), toy.getBrand(), toy.getPrice(), toy.getAvailableCount(), toy.getAgeAppropriate(), boardgame.getNumOfPlayers(), boardgame.getAuthor());
        } else if (toy instanceof Figure) {
    		Figure figure = (Figure) toy;
            return String.format("Category: Figure, Serial Number: %d, Name: %s, Brand: %s, Price: %f, Available Count: %d, Age Appropiate: %d, Classification: %s",
            		toy.getSerialNumber(), toy.getName(), toy.getBrand(), toy.getPrice(), toy.getAvailableCount(), toy.getAgeAppropriate(), figure.getClassification());
        }
    	
        else if (toy instanceof Animal) {
    		Animal animal = (Animal) toy;
            return String.format("Category: Animal, Serial Number: %d, Name: %s, Brand: %s, Price: %f, Available Count: %d, Age Appropiate: %d, Material: %s, Size: %s",
            		toy.getSerialNumber(), toy.getName(), toy.getBrand(), toy.getPrice(), toy.getAvailableCount(), toy.getAgeAppropriate(), animal.getMaterial(), animal.getSize());
        }
    	
        else if (toy instanceof Puzzle) {
    		Puzzle puzzle = (Puzzle) toy;
            return String.format("Category: Puzzle, Serial Number: %d, Name: %s, Brand: %s, Price: %f, Available Count: %d, Age Appropiate: %d, Puzzle Type: %s",
            		toy.getSerialNumber(), toy.getName(), toy.getBrand(), toy.getPrice(), toy.getAvailableCount(), toy.getAgeAppropriate(), puzzle.getPuzzleType());
        }
    	
        else {
             
            return String.format("Category: Unknown, Serial Number: %d, Name: %s, Brand: %s, Price: %f, Available Count: %d, Age Appropiate: %d ",
            		toy.getSerialNumber(), toy.getName(), toy.getBrand(), toy.getPrice(), toy.getAvailableCount(), toy.getAgeAppropriate());        }
    }
    
    /**
     * Initializes the application by loading data from the specified file.
     */
    
    public void initialize() {
        toys = loadDataFromFile(); // Implement this method to load data
    }
    
    /**
     * Loads toy data from the specified file and returns a list of Toy objects.
     *
     * @return A list of Toy objects loaded from the file.
     */

	private List<Toy> loadDataFromFile() {
		 List<Toy> toyList = new ArrayList<>();
		    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
		        String line;
		        while ((line = br.readLine()) != null) {
		            String[] parts = line.split(";");
		            if (parts.length >= 6) {
		            	long serialNumber = Long.parseLong(parts[0].trim());
	                    String name = parts[1].trim();
	                    String brand = parts[2].trim();
	                    double price = Double.parseDouble(parts[3].trim());
	                    int availableCount = Integer.parseInt(parts[4].trim());
	                    int ageAppropriate = Integer.parseInt(parts[5].trim());
	                    
	                    
	                    if (isBoardgame(serialNumber) && parts.length >= 8) {
	                        String numOfPlayers = parts[6].trim();
	                        String author = parts[7].trim();
	                        toyList.add(new BoardGame(serialNumber, name, brand, price, availableCount, ageAppropriate, numOfPlayers, author));
	                    }
	                    
	                    else if (isFigure(serialNumber) && parts.length >= 7) {
	                    	
	                    	String classification = parts[6].trim();
	                    	toyList.add(new Figure(serialNumber, name, brand, price, availableCount, ageAppropriate, classification));
	                       
	                    }
	                    
                        else if (isAnimal(serialNumber) && parts.length >= 8) {
	                    	
                        	String materials = parts[6].trim();
                            String size = parts[7].trim();
                            toyList.add(new Animal(serialNumber, name, brand, price, availableCount, ageAppropriate, materials, size));
   
	                    }
	                    
                        else if (isPuzzle(serialNumber) && parts.length >= 7) {
                            String puzzleType = parts[6].trim();
                            toyList.add(new Puzzle(serialNumber, name, brand, price, availableCount, ageAppropriate, puzzleType));
                            
                        } 
		             

		                
		            }
		        }
		    } catch (IOException | NumberFormatException e) {
		        e.printStackTrace(); // Handle exceptions appropriately
		    }
		    return toyList;
    }
	

	/**
	 * Determines if the given serial number corresponds to a BoardGame based on the first digit.
	 *
	 * @param serialNumber The serial number to be checked.
	 * @return True if the serial number corresponds to a BoardGame, false otherwise.
	 */
	private boolean isBoardgame(long serialNumber) {
        String serialString = Long.toString(serialNumber);
        char firstDigit = serialString.charAt(0);
        return firstDigit == '7' || firstDigit == '8' || firstDigit == '9';
    }
	
	/**
	 * Determines if the given serial number corresponds to a Figure based on the first digit.
	 *
	 * @param serialNumber The serial number to be checked.
	 * @return True if the serial number corresponds to a Figure, false otherwise.
	 */
    private boolean isFigure(long serialNumber) {
   
        // Extract the first digit
        
        String serialString = Long.toString(serialNumber);
        char firstDigit = serialString.charAt(0);
        return firstDigit == '0' || firstDigit == '1';
    }
    
    /**
     * Determines if the given serial number corresponds to an Animal based on the first digit.
     *
     * @param serialNumber The serial number to be checked.
     * @return True if the serial number corresponds to an Animal, false otherwise.
     */

    private boolean isAnimal(long serialNumber) {
        String serialString = Long.toString(serialNumber);
        char firstDigit = serialString.charAt(0);
        return firstDigit == '2' || firstDigit == '3';
    }
    
    /**
     * Determines if the given serial number corresponds to a Puzzle based on the first digit.
     *
     * @param serialNumber The serial number to be checked.
     * @return True if the serial number corresponds to a Puzzle, false otherwise.
     */
    private boolean isPuzzle(long serialNumber) {
        String serialString = Long.toString(serialNumber);
        char firstDigit = serialString.charAt(0);
        return firstDigit == '4' || firstDigit == '5' || firstDigit == '6';
    }
	
    
    


}
