
public class TestAnimalShelter {

	public static void main(String[] args) {
		Shelter braden = new Shelter("braden", 3);
		Animal jerry = new Animal("jerry", 30, 2.5, "dog");
		braden.addAnimal(jerry);
		braden.displayShelterDetails();
		

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
	
	//display animal info method 
	public void displayAnimalInfo()
	{
		System.out.println("name = " + animalName);
		System.out.println("species = " + animalSpecies);
		System.out.println("weight = " + animalWeight);
		System.out.println("weight category = " + weightClass);
		System.out.println("daily food = " + dailyFood);
		System.out.println("weekly food = " + weeklyFood);
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
	private double dailyFoodAverage = dailyFoodAverageCalculation();
	
	
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
		return totalWeeklyFood;
	}
	
	//average daily food Calculation
	private double dailyFoodAverageCalculation()
	{
		double currentTotal = 0;
		for (int index = 0; index < numberAnimals; index++)
		{
			currentTotal = currentTotal + animals[index].getDailyFood();
		}
		double currentAverage = currentTotal / numberAnimals;
		return currentAverage;
	}
	
	//getter for daily food average
	public double getDailyAverageFood()
	{
		return dailyFoodAverage;
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
			
		}
		
	}
}
//End Shelter Class