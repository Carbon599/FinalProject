
import java.util.ArrayList;
import java.util.Collections;

public class Fridge 
{

    // Create a list that contains the ingredients (the "storage")
    private ArrayList<Ingredient> fridge = new ArrayList<Ingredient>();

    //getters 
    public int getFridgeSize()    //get the size of the ing list
    {
        return fridge.size();
    }

    public String getIngName(int where) //gets the ing name at "where"
    {
        return fridge.get(where).getFoodName();
    }

    public Ingredient getIngredient(int where) // grabs the ingredient from the list
    {
        return fridge.get(where);
    }

    // Add or remove methods
    public void addIngredient(Ingredient ingr) 
    {
        fridge.add(ingr);
    }

    public void removeIngredient(String foodName) // removes whatever the ingredient the user typed in(not used currently)
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
    
    public void removeIngredient(int place) // removes the ingredient at "place"
    {   
        fridge.remove(place);
    }

    // Sort methods
    public void sortFridgeByName() //erm
    {    
        fridge = MergeSort.mergeSort(fridge); // wow it works 
    }


    public void sortFridgeByQuantity() // sorts the items in the fridge by amount (disregards the actual measurement)
    {
        for (int i = 0; i < fridge.size()-1; i++)
        {
            if (fridge.get(i).getFoodAmount()>fridge.get(i+1).getFoodAmount())
            {
                Collections.swap(fridge, i, (i+1)); // pls let this slide :)
            }
        }

    }

    // Display methods (just changed what it says)
    public void displayContents() //display the items in the fridge
    {
        System.out.println("\nI-----Stuff in the fridge-----I\n");

        for (Ingredient ingredient : fridge) 
        {
            System.out.println(">> " + ingredient.getFoodName() + ", " + ingredient.getFoodAmount() + ingredient.getFoodMeasurement());
        }
        System.out.println("\nI-----------------------------I\n");
    }

    public void displayContentsForEdit() //display the items in the fridge for editing
    {
        System.out.println("\nI-----Select an Ingredient to Edit-----I\n");
        int i = 1;
        for (Ingredient ingredient : fridge) 
        {
            System.out.println(i+") >> " + ingredient.getFoodName() + ", " + ingredient.getFoodAmount() + ingredient.getFoodMeasurement());
            i++;
        }
        System.out.println("\nI-----------------------------I\n");
    }
    
    public void displayContentsForRemoval() //display the items in the fridge for removal
    {
        System.out.println("\nI-----Select an Ingredient to Remove-----I\n");
        int i = 1;
        for (Ingredient ingredient : fridge) 
        {
            System.out.println(i+") >> " + ingredient.getFoodName() + ", " + ingredient.getFoodAmount() + ingredient.getFoodMeasurement());
            i++;
        }
        System.out.println("\nI-----------------------------I\n");
    }
}
