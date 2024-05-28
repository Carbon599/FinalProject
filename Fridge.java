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

    public void removeIngredient(Ingredient ingr)
    {

    }



    // Sort methods
    public void sortIngredientName(ArrayList foodList)
    {

    }

    public void sortIngredientAmount(ArrayList foodList)
    {

    }
    
    public void displayContents()
    {
        for (int i = 0; i < Fridge.size(); i++)
        {
            System.out.println("ing" +i+": " + Fridge.get(i).getFoodName());
        }
    }


}
