import java.util.ArrayList;

public class Meal // create templates for a certain meal, check if fridge has enough of it 

{                   

    private String name;
    private ArrayList<Ingredient> ingredients;

    Meal(String name, ArrayList<Ingredient> ingredients)
    {
        this.name = name;
        this.ingredients = ingredients;
    }

    // getters 
    public String getMealName()
    {
        return this.name;
    }

    public ArrayList<Ingredient> getIngredientsList()
    {
        return this.ingredients;
    }
    
    // setters

    public void setMealName(String newName)
    {
        this.name = newName;
    }

}
