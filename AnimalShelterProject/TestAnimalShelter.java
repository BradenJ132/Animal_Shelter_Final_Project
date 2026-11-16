
public class TestAnimalShelter {

	public static void main(String[] args) {
		Shelter FootHills = new Shelter("FootHills", 3);
		Animal jerry = new Animal("jerry", 2.5, 30, "dog");
		Animal terry = new Animal("terry", 5.0, 110, "zebra");
		FootHills.addAnimal(jerry);
		FootHills.addAnimal(terry);
		FootHills.displayShelterDetails();
		FootHills.getTotalWeeklyFood();
		FootHills.displayAboveAverage();
		

	}

}
//start Animal Class
class Animal
{
	//instance variables for animal class
	private String animalName;
	private double dailyFood;
	private double animalWeight;
	private String animalSpecies;
	
	
	//constructor for animal object
	public Animal(String animalName, double dailyFood, double animalWeight, String animalSpecies)
	{
		this.animalName = animalName;
		this.dailyFood = dailyFood;
		this.animalWeight = animalWeight;
		this.animalSpecies = animalSpecies;
	}
	
	//display animal info method 
	public void displayAnimalInfo()
	{
		System.out.println("name = " + animalName);
		System.out.println("species = " + animalSpecies);
		System.out.println("weight = " + animalWeight);
		System.out.println("weight category = " + getWeightClass());
		System.out.println("daily food = " + dailyFood);
		System.out.println("weekly food = " + getWeeklyFood());
		
	}
	
	//getter for animal name
	public String getAnimalName()
	{
		return animalName;
	}
	
	//getter for daily food
	public double getDailyFood()
	{
		return dailyFood;
	}
	
	//getter for animal weight
	public double getAnimalWeight()
	{
		return animalWeight;
	}
	
	//getter for species
	public String getAnimalSpecies()
	{
		return animalSpecies;
	}
	//calculates weekly food and getter for weekly food
	public double getWeeklyFood()
	{
		
		double currentWeeklyFood = dailyFood * 7;
		return currentWeeklyFood;
	}
	
	// calculates weight class and getter for weight class
	public String getWeightClass()
	{
		
			String animalWeightCategory;
			if (animalWeight < 20.00)
			{
				animalWeightCategory = ("small");
			}
			else if (animalWeight >= 20 && animalWeight < 50)
			{
				animalWeightCategory = ("medium");
			}
			else if (animalWeight >= 50 && animalWeight < 100)
			{
				animalWeightCategory = ("large");
			}
			else 
			{
				animalWeightCategory = ("Extra Large");
			}
		
		return animalWeightCategory;
	}
	
	
}
//end Animal Class

//Start Shelter Class
class Shelter
{
	//Shelter instance variables 
	private String shelterName;
	private int numberAnimals;
	private Animal animals[];
	
	
	
	//Shelter Constructor
	public Shelter(String shelterName, int maxNumberAnimals)
	{
		this.shelterName = shelterName;
		animals = new Animal[maxNumberAnimals];	
	}
	
	//add animal to animals array
	public void addAnimal(Animal newAnimal)
	{
		if (numberAnimals < animals.length)
		{
			animals[numberAnimals] = newAnimal;
			numberAnimals++;
		}
	}
	
	//getter for shelter name
	public String getSheltername()
	{
		return shelterName;
	}
	
	//getter for number of animals
	public int getNumberAnimals()
	{
		return numberAnimals;
	}
	
	
	
	//getter for total weekly food amount 
	public double getTotalWeeklyFood()
	{
		double totalWeeklyFood = 0;
		for (int index = 0; index < numberAnimals; index++)
		{
			totalWeeklyFood = totalWeeklyFood + animals[index].getWeeklyFood();
		}
		System.out.println("Total weekly food = " + totalWeeklyFood);
		System.out.println("********************");
		return totalWeeklyFood;
	}
	
	//average daily food Calculation and getter for average daily food
	public double getAverageDailyFood()
	{
		double currentTotal = 0;
		for (int index = 0; index < numberAnimals; index++)
		{
			currentTotal = currentTotal + animals[index].getDailyFood();
		}
		double currentAverage = currentTotal / numberAnimals;
		return currentAverage;
	}
	
	//list animals at or above 
	public void displayAboveAverage()
	{
		System.out.println("Animals at or above average daily food:");
		System.out.println(" ");
		for (int index = 0; index < numberAnimals; index++)
		{
			if (animals[index].getDailyFood() >= getAverageDailyFood())
					{
				System.out.println(animals[index].getAnimalName());
					}
		}
	}
	
	//method to display shelter details 
	public void displayShelterDetails()
	{
		System.out.println(shelterName);
		System.out.println("********************");
		System.out.println("Max number of animals = " + animals.length);
		System.out.println("the current number of animals = " + numberAnimals);
		System.out.println("********************");
		for(int index = 0; index < numberAnimals; index ++)
		{
			animals[index].displayAnimalInfo();
			System.out.println("********************");
			
		}
		
	}
}
//End Shelter Class