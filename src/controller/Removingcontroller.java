package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Animal;
import model.BoardGame;
import model.Figure;
import model.Puzzle;
import model.Toy;

public class Removingcontroller {
	
	
	private final String FILE_PATH = "res/toys.txt";
	@FXML
    private TextField NameFIeld;

    @FXML
    private RadioButton SN;
    
    @FXML
    private TextField SNSTD;
    
    @FXML
    private TextField Types;

    @FXML
    private Button btnDisplay;

    @FXML
    private ListView<String> lvnames;
    
    private List<Toy> toys;

    @FXML
    void NameFIields(ActionEvent event) {
    	
    	if (SN.isSelected()) {
	        // Update the UI or perform actions specific to the Name radio button
		 NameFIeld.setPromptText("Enter SN"); // Set the prompt text for NameField
	    }


    }
    @FXML
    void SNST(ActionEvent event) {
    	
    	if (SN.isSelected()) {
    		SNSTD.setPromptText("Enter Serial Number:");
        }

    }

    @FXML
    void SNS(ActionEvent event) {

    }

    @FXML
    void btnHandler(ActionEvent event) {
    	
    	filterAndDisplayResults();

    }
    

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
    
    private boolean matchesCriteria(Toy toy, String searchTerm, String searchSerialNumber, String searchType) {
        if (SN.isSelected()) {
            return String.valueOf(toy.getSerialNumber()).contains(searchSerialNumber);
        }
        return false;
    }
    
    
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
    
    public void initialize() {
        toys = loadDataFromFile(); // Implement this method to load data
    }

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
	

	private boolean isBoardgame(long serialNumber) {
        String serialString = Long.toString(serialNumber);
        char firstDigit = serialString.charAt(0);
        return firstDigit == '7' || firstDigit == '8' || firstDigit == '9';
    }
    private boolean isFigure(long serialNumber) {
    	
    	

        // Extract the first digit
        
        String serialString = Long.toString(serialNumber);
        char firstDigit = serialString.charAt(0);
        return firstDigit == '0' || firstDigit == '1';
    }
    private boolean isAnimal(long serialNumber) {
        String serialString = Long.toString(serialNumber);
        char firstDigit = serialString.charAt(0);
        return firstDigit == '2' || firstDigit == '3';
    }
    private boolean isPuzzle(long serialNumber) {
        String serialString = Long.toString(serialNumber);
        char firstDigit = serialString.charAt(0);
        return firstDigit == '4' || firstDigit == '5' || firstDigit == '6';
    }
	

}
