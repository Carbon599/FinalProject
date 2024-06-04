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

    private Measurements getIngMeasurement() // returns the measurement
    {
        System.out.println("Enter the appropriate measurement for the Ingredient:\n 1-TBSP\n 2-TSP\n 3-OZ\n 4-C\n 5-QT\n 6-GAL\n 7-LB\n 8-ML\n 9-G\n 10-KG\n 11-L\n 12-pc (piece/s)");
        int input = getUserInt(1, 12);
        return Measurements.values()[input];
    }
    
    private int getUserInt(int min, int max)
    {
        Scanner scn = new Scanner(System.in);
            
        int userNumber = min - 1; // Set userNumber to be less than min, so that we enter the loop.
        String prompt = "Enter an integer between " + min + " and " + max + ": ";
        boolean repeat = false;
   
        while (userNumber < min || userNumber > max) // Note: || means or
        {
            // Modify the prompt based on whether we are repeating or not.
            if (repeat)
            {
                if (min==max) // added this just cause
                {
                System.out.println("Number can only be "+min+".\n");
                System.out.print(prompt);
                }
                else
                {
                System.out.println("Number must be at least " + min + " and at most " + max + ".\n");
                System.out.print(prompt);
                }
            }
            else
            {
                repeat = true;
                System.out.print(prompt);
            }
                
            // Loop as long as an integer has NOT been inputted.
            while (!scn.hasNextInt())
            {
                System.out.println("That is not an integer.\n");
                System.out.print(prompt);
                scn.next(); // Consume the next token. Note: scn.hasNextInt() does NOT consume the token.
            }

        // There is a valid integer, so grab that and store it in userNumber.
            userNumber = scn.nextInt();
        }
        return userNumber;
    }


    private String getUserIngName()// returns string
    {
        System.out.println("NAME:");
        Scanner userInput = new Scanner(System.in);

        return userInput.nextLine();
        

    }

    public Ingredient createIngredient() // user creates an ingredient //also used in meals
    {   

        String name = getUserIngName();
        Measurements measurement = getIngMeasurement();
        int amount = getUserIngAmount();


        Ingredient userIng = new Ingredient(name, amount, measurement);
        System.out.println("Successfully added " + userIng.getFoodName() +" to the Fridge\n");
        return userIng;
    }


}