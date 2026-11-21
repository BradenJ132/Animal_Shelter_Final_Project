import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class TestAnimalShelter {

	public static void main(String[] args) {
		displayProgramOverview();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter File name");
		
		String fileName = input.nextStr() + ".txt";
		input.close();
		try
		{
			RescueCenter testRescueCenter = new RescueCenter("Braden's Rescue", 6);
			rescueSetUp(fileName, testRescueCenter);
			testRescueCenter.displayShelterDetails();
			testRescueCenter.displayAboveAverage();
			testRescueCenter.writeAnimalsToFile("PrintToFile.txt");
			
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}
			
//String animalName, String animalSpecies, double animalWeight, double dailyFoodAmount
	}
//read from file
	public static void rescueSetUp(String fileName, RescueCenter newRescueCenter) throws FileNotFoundException
	{
		File inputFile = new File(fileName);
		Scanner fileScanner = new Scanner(inputFile);
		while (fileScanner.hasNext())
		{
			String animalName = fileScanner.next();
			String animalSpecies = fileScanner.next();
			double animalWeight = fileScanner.nextDouble();
			double dailyFoodAmount = fileScanner.nextDouble();
			Animal animals = new Animal(animalName, animalSpecies, animalWeight, dailyFoodAmount);
			newRescueCenter.addAnimal(animals);
		}
		fileScanner.close();
	}
	
	//display program overview
	
	public static void displayProgramOverview()
	{
		System.out.println("*****************************");
		System.out.println("Animal Rescue Center Analysis");
		System.out.println("*****************************");
		System.out.println("Reads animal information from a text file");
		System.out.println("Displays each animal's weight category and weekly food");
		System.out.println("Calculates average daily and total weekly food");
		System.out.println("Writes rescue information and analysis to a file");
		System.out.println("*****************************");
		System.out.println("");
		
	
		
	}
}
//start Animal Class
class Animal
{
	//instance variables for animal class
	private String name;
	private double dailyFoodAmount;
	private double weight;
	private String species;
	
	
	//constructor for animal object
	public Animal(String animalName, String animalSpecies, double animalWeight, double dailyFoodAmount)
	{
		this.name = animalName;
		this.dailyFoodAmount = dailyFoodAmount;
		this.weight = animalWeight;
		this.species = animalSpecies;
	}
	
	//display animal info method 
	public void displayAnimalInfo()
	{
		System.out.println("name = " + name);
		System.out.println("species = " + species);
		System.out.println("weight = " + weight);
		System.out.println("weight category = " + determineWeightCategory());
		System.out.println("daily food = " + dailyFoodAmount);
		System.out.println("weekly food = " + calculateWeeklyFood());
		
	}
	
	//getter for animal name
	public String getName()
	{
		return name;
	}
	
	//getter for daily food
	public double getDailyFoodAmount()
	{
		return dailyFoodAmount;
	}
	
	//getter for animal weight
	public double getWeight()
	{
		return weight;
	}
	
	//getter for species
	public String getSpecies()
	{
		return species;
	}
	//calculates weekly food and getter for weekly food
	public double calculateWeeklyFood()
	{
		
		double currentWeeklyFood = dailyFoodAmount * 7;
		return currentWeeklyFood;
	}
	
	// calculates weight class and getter for weight class
	public String determineWeightCategory()
	{
		
			String animalWeightCategory;
			if (weight < 20.00)
			{
				animalWeightCategory = ("small");
			}
			else if (weight >= 20 && weight < 50)
			{
				animalWeightCategory = ("medium");
			}
			else if (weight >= 50 && weight < 100)
			{
				animalWeightCategory = ("large");
			}
			else 
			{
				animalWeightCategory = ("Extra Large");
			}
		
		return animalWeightCategory;
	}
	//display animal analysis method
	public void displayAnimalAnalysis()
	{
		
	}
}
//end Animal Class

//Start Shelter Class
class RescueCenter
{
	//Shelter instance variables 
	private String rescueName;
	private int animalCount;
	private Animal animals[];
	
	
	
	//Shelter Constructor
	public RescueCenter(String shelterName, int maxNumberAnimals)
	{
		this.rescueName = shelterName;
		animals = new Animal[maxNumberAnimals];	
	}
	
	//add animal to animals array
	public void addAnimal(Animal newAnimal)
	{
		if (animalCount < animals.length)
		{
			animals[animalCount] = newAnimal;
			animalCount++;
		}
	}
	
	//getter for shelter name
	public String getSheltername()
	{
		return rescueName;
	}
	
	//getter for number of animals
	public int getNumberAnimals()
	{
		return animalCount;
	}
	
	
	
	//getter for total weekly food amount 
	public double getTotalWeeklyFood()
	{
		double totalWeeklyFood = 0;
		for (int index = 0; index < animalCount; index++)
		{
			totalWeeklyFood = totalWeeklyFood + animals[index].calculateWeeklyFood();
		}
		System.out.println("Total weekly food = " + totalWeeklyFood);
		System.out.println("********************");
		return totalWeeklyFood;
	}
	
	//average daily food Calculation and getter for average daily food
	public double getAverageDailyFood()
	{
		double currentTotal = 0;
		for (int index = 0; index < animalCount; index++)
		{
			currentTotal = currentTotal + animals[index].getDailyFoodAmount();
		}
		double currentAverage = currentTotal / animalCount;
		return currentAverage;
	}
	
	//list animals at or above 
	public void displayAboveAverage()
	{
		System.out.println("Animals at or above average daily food:");
		System.out.println(" ");
		for (int index = 0; index < animalCount; index++)
		{
			if (animals[index].getDailyFoodAmount() >= getAverageDailyFood())
					{
				System.out.println(animals[index].getName());
					}
		}
	}
	
	//method to display shelter details 
	public void displayShelterDetails()
	{
		System.out.println(rescueName);
		System.out.println("********************");
		System.out.println("Max number of animals = " + animals.length);
		System.out.println("the current number of animals = " + animalCount);
		System.out.println("********************");
		for(int index = 0; index < animalCount; index ++)
		{
			animals[index].displayAnimalInfo();
			System.out.println("********************");
			
		}
		
	}
	//write animals to file method
		public void writeAnimalsToFile(String fileName) throws FileNotFoundException
		{
		try 
		{
			PrintWriter writeToFile = new PrintWriter(fileName);
			writeToFile.println(rescueName);
			writeToFile.println("****************");
			for(int index = 0; index < animalCount; index++)
			{
				
				writeToFile.println("Animal name = " + animals[index].getName());
				writeToFile.println("Animal species = " + animals[index].getSpecies());
				writeToFile.println("Animal weight = " + animals[index].getWeight());
				writeToFile.println("Animal weight category = " + animals[index].determineWeightCategory());
				writeToFile.println("Animal daily food amount = " + animals[index].getDailyFoodAmount());
				writeToFile.println("Animal weekly food amount= " + animals[index].calculateWeeklyFood());
				writeToFile.println("****************");
				
			}
			writeToFile.println("Animals at or above average daily food:");
			writeToFile.println(" ");
			for (int index = 0; index < animalCount; index++)
			{
				if (animals[index].getDailyFoodAmount() >= getAverageDailyFood())
						{
					writeToFile.println(animals[index].getName());
						}
			}
			writeToFile.close();
			
		}
		catch (FileNotFoundException exception)
		{
			System.out.println("Error: Unable to find file " + fileName);
		}
		
		}	
		
}
//End Shelter Class