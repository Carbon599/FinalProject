import java.util.ArrayList;

public class Table extends ListOfRecipes // wow an extension
{
    private ArrayList<Meal> table = new ArrayList<Meal>();

    @Override
    public void displayMeals()
    {
        if (table.size()==0)
        {
    
            System.out.println("There is no food in the table");
        }
        else 
        {
            int i = 1;
            for (Meal mealAt: table)
            {
                System.out.println("Meal " + i+ "# >>" +mealAt.getMealName());
                System.out.println("\n\n");
                i++;

            }

        }
    }
    @Override
    public void addRecipe(Meal newMeal)
    {
        table.add(newMeal);
    }
}
