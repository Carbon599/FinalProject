import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fridge 
{

    // Create a list that contains the ingredients (the "storage")
    private ArrayList<Ingredient> fridge;

    public Fridge() 
    {
        fridge = new ArrayList<Ingredient>();
    }

    // Add or remove methods
    public void addIngredient(Ingredient ingr) 
    {
        fridge.add(ingr);
    }

    public void removeIngredient(String foodName) 
    {
        for (int i = 0; i < fridge.size(); i++) 
        {
            if (fridge.get(i).getFoodName().equalsIgnoreCase(foodName)) 
            {
                fridge.remove(i);
                break;
            }
        }
    }

    // Sort methods
    public void sortFridgeByName() 
    {
        Collections.sort(fridge, new Comparator<Ingredient>() 
        {
            public int compare(Ingredient i1, Ingredient i2) 
            {
                return i1.getFoodName().compareToIgnoreCase(i2.getFoodName());
            }
        });
    }

    public void sortFridgeByAmount() 
    {
       
    }

    // Display method
    public void displayContents() 
    {
        for (Ingredient ingredient : fridge) 
        {
            System.out.println("Ingredient: " + ingredient.getFoodName() + ", Amount: " + ingredient.getFoodAmount());
        }
    }

    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        
        // Adding some ingredients to the fridge
       
        // Displaying the contents of the fridge
       
        // Sorting by name and displaying
       
        // Sorting by amount and displaying
    
        // Removing an ingredient and displaying
    }
}
