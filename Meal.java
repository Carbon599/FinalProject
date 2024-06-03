import java.util.ArrayList;

public class Meal// create templates for a certain meal, check if fridge has enough of it 
                  // will this extend fridge?
                  // meals class checks the thing in the fridge vs the list that contains the ingredients required for the meal

{                   
    
    private ArrayList<ArrayList<Ingredient>> Meals; // where all the meals are stored\

    public Meal()
    {
        Meals = new ArrayList<ArrayList<Ingredient>>();
    }





    public void createMeal()
    {
        Ingredient ing = new Ingredient(null, 0, null);
        ArrayList<Ingredient> newMeal = new ArrayList<Ingredient>();

    }

    public void removeMeal()
    {

    }
}
