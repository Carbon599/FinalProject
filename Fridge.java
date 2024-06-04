
import java.util.ArrayList;
import java.util.Collections;

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
        
        System.out.println(foodName + " removed from the pantry.");
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
        MergeSort.mergeSort(fridge);

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

    // Display method
    public void displayContents() 
    {
        System.out.println("\nI-----Stuff in the fridge-----I\n");
        System.out.println("Stuff in the fridge: (everything is in the fridge [real]) \n");
        int i = 0;
        for (Ingredient ingredient : fridge) 
        {
            System.out.println(">> " + ingredient.getFoodName() + ", " + ingredient.getFoodAmount() + ingredient.getFoodMeasurement());
            i++;
        }
        System.out.println("\nI-----------------------------I\n");
    }

}
