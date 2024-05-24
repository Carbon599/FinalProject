public class Ingredient 
{
    
    private String name;
    private int quantity;

    Ingredient(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public String getFoodName()
    {
        return this.name;
    }

    public int getFoodAmount()
    {
        return this.quantity;
    }




}
