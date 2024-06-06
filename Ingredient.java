import java.util.Scanner;
// measurments the user gets to choose from
enum Measurements 
{
    tbsp,
    tsp,
    oz,
    c,
    qt,
    pt,
    gal,
    lb,
    mL,
    g,
    kg,
    l,
    pc
}

public class Ingredient 
{
    // The parameters for the ingredient
    private String name;
    private int quantity;
    private Measurements Measurements;
    
    
    Ingredient(String name, int quantity, Measurements Measurements)
    {
        this.name = name;
        this.quantity = quantity;
        this.Measurements = Measurements;
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

    public Measurements getFoodMeasurement()
    {
        return this.Measurements;
    }

    public void setFoodAmount(int newAmount)
    {
        this.quantity = newAmount;
    }


    // User Inputs for creating an ingredient
    private int getUserIngAmount() // returns int
    {

        System.out.println("AMOUNT:");
        Scanner userInput = new Scanner(System.in);

        while (!userInput.hasNextInt())
        {
            System.out.println("Amount must not have a letter.");
            userInput.next();
        }
        
        return userInput.nextInt();
        

    }




}