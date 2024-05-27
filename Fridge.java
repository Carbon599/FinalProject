import java.util.ArrayList;

public class Fridge 
{

    // create a list that contains the ingredients (the "storage")
    // display the list contents on the DisplayTextUI class maybe
    
    ArrayList<Ingredient> Fridge = new ArrayList<Ingredient>();




    // Add or remove methods
    public void addIngredient(Ingredient ingr)
    {
        Fridge.add(ingr);
    }

    public void removeIngredient()
    {

    }


    // Sort methods
    public void sortFridgeName()
    {

    }

    public void sortFridgeAount()
    {

    }
    
    public void displayContents()
    {
        for (int i = 0; i <= Fridge.size(); i++)
        {
            System.out.println("ing 1: " + Fridge.get(i).getFoodName());
        }
    }


}
