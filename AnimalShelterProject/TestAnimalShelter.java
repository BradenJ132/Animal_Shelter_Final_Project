
public class TestAnimalShelter {

	public static void main(String[] args) {
		

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
	private double weeklyFood = weeklyFoodCalculation();
	private String weightClass = weightClassCalculation();
	
	//constructor for animal object
	public Animal(String animalName, double dailyFood, double animalWeight, String animalSpecies)
	{
		this.animalName = animalName;
		this.dailyFood = dailyFood;
		this.animalWeight = animalWeight;
		this.animalSpecies = animalSpecies;
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
	//calculates weekly food
	private double weeklyFoodCalculation()
	{
		
		double currentWeeklyFood = dailyFood * 7;
		return currentWeeklyFood;
	}
	//getter for weekly food
	public double getWeeklyFood()
	{
		return weeklyFood;
	}
	
	// calculates weight class
	private String weightClassCalculation()
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
	//getter for weight class
	public String getWeightClass()
	{
		return weightClass;
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
	//getter for shelter name
	public String getSheltername()
	{
		return shelterName;
	}
	
	public int getNumberAnimals()
	{
		return numberAnimals;
	}
	
	
}
//End Shelter Class