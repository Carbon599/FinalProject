
import java.util.ArrayList;
import java.util.Collections;

public class Fridge 
{

    // Create a list that contains the ingredients (the "storage")
    private ArrayList<Ingredient> fridge = new ArrayList<Ingredient>();

    // Add or remove methods
    public void addIngredient(Ingredient ingr) 
    {
        fridge.add(ingr);
    }

    public void removeIngredient(String foodName) // removes whatever the ingredient the user typed in
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
    public void sortFridgeByName() //erm
    {
        
        MergeSort.mergeSort(fridge);
    

    }


    public void sortFridgeByQuantity()// sorts the items in the fridge by amount (disregards the actual measurement)
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
    public void displayContents() //display the items in the fridge
    {
        System.out.println("\nI-----Stuff in the fridge-----I\n");

        for (Ingredient ingredient : fridge) 
        {
            System.out.println(">> " + ingredient.getFoodName() + ", " + ingredient.getFoodAmount() + ingredient.getFoodMeasurement());
        }
        System.out.println("\nI-----------------------------I\n");
    }

}
