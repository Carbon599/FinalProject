import java.util.ArrayList;

public class ListOfRecipes // where all recipes are stored
{

    private ArrayList<Meal> Meals = new ArrayList<Meal>();

    //getters 
    public int getRecipeListSize()
    {
        return Meals.size();
    }

    //add or remove methods
    public void addRecipe(Meal newMeal)
    {
        Meals.add(newMeal);
    }

    public void removeMeal(int place) //place, as in place(position) in the list
    {
        Meals.remove(place);

    }


    // display methods
    public void displayMeals() //
    {
        int i = 1;
        for (Meal mealAt: Meals)
        {
            System.out.println("Recipe " + i+ "# >>" +mealAt.getMealName());
            for (int j = 0; j < mealAt.getIngredientsList().size(); j++)
            {
                System.out.println("|"+(j+1)+"| >" + mealAt.getIngredientsList().get(j).getFoodName()+
                                   ", " + mealAt.getIngredientsList().get(j).getFoodAmount() + 
                                    mealAt.getIngredientsList().get(j).getFoodMeasurement());
            }
            System.out.println("\n\n");
            i++;
            

        }
    }
    public void displayRecipeForRemoval() //just modified what it says
    {   
        int i = 1;
        System.out.println("Choose a recipe to remove: ");
        for (Meal mealAt: Meals)
        {
            System.out.println("Recipe " + i+ "# >>" +mealAt.getMealName());
            for (int j = 0; j < mealAt.getIngredientsList().size(); j++)
            {
                System.out.println("|"+(j+1)+"| >" + mealAt.getIngredientsList().get(j).getFoodName());

            }
            System.out.println("\n\n");
            i++; 

        }
    }
}
