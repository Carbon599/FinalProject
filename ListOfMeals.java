import java.util.ArrayList;


public class ListOfMeals // where all meals are stored
{

    private ArrayList<Meal> Meals = new ArrayList<Meal>();

    public void addMeal(Meal newMeal)
    {
        Meals.add(newMeal);
    }
}
