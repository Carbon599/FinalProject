public class Ingredient 
{
    // The parameters for the ingredient
    private String name;
    private int quantity;
    
    
    Ingredient(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }


    // the getters and setters
    public String getFoodName()
    {
        return this.name;
    }

    public int getFoodAmount()
    {
        return this.quantity;
    }

    public void setFoodAmount(int newAmount)
    {
        this.quantity = newAmount;
    }

    public void createIngredient() // user creates an ingredient
    {

    }
    




}
