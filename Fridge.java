import java.security.PublicKey;
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


    public void sortFridgeByQuantity()
    {

        for (int i = 0; i < fridge.size()-1; i++)
        {
            
            if (fridge.get(i).getFoodAmount()>fridge.get(i+1).getFoodAmount())
            {
                Collections.swap(fridge, i, (i+1));
            }
            

        }

    }

    //public  sortFridgeByAmount() // do this


    // Display method
    public void displayContents() 
    {
        System.out.println("Stuff in the fridge: (everything is in the fridge [real]) \n");
        int i = 0;
        for (Ingredient ingredient : fridge) 
        {
            System.out.println("Ingredient "+(i+1)+": " + ingredient.getFoodName() + ", Amount: " + ingredient.getFoodAmount() + ingredient.getFoodMeasurement());
            i++;
        }
        System.out.println("\n");
    }

}
