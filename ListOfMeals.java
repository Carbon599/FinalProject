import java.util.ArrayList;


public class ListOfMeals // where all meals are stored
{

    private ArrayList<Meal> Meals = new ArrayList<Meal>();

    public void addMeal(Meal newMeal)
    {
        Meals.add(newMeal);
    }

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
}
