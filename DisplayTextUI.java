import java.util.Scanner;

public class DisplayTextUI 
{
    boolean runProgram = true;
    Fridge fridge = new Fridge();
    

    public DisplayTextUI() 
    {
        fridge = new Fridge(); // Initialize the fridge
        fridge.addIngredient(new Ingredient("egg", 3,Measurements.g));
        fridge.addIngredient(new Ingredient("chicken", 5,Measurements.kg));
        fridge.addIngredient(new Ingredient("milk", 3,Measurements.gal));
        fridge.addIngredient(new Ingredient("kiwi", 3,Measurements.units));

    }

    public void run()
    {
        while (runProgram)
        {
    
            System.out.println("---------------------------\nSelect a number between 1-4 \n 1-Sort alphabetically \n 2-Sort by quantity\n 3-Manage food in storage \n4-create meal \n 5-Display Stuff in the fridge\n6-Exit the program\n\n---------------------------\n");
            int userInput = getUserInt(1,6);

            switch(userInput)
            {
                case 1:
                //sort alphabetically
                    sortalphabetically();
                break;

                case 2:
                    sortbyquantity();
                //sort quantity
                break;

                case 3:
                    manageFood();
                //add or remove
                break;

                case 4:
                    createMeal();
                //meal stuff
                break;

                case 5:
                    
                    fridge.displayContents();
                //meal stuff
                break;
            
                case 6:
                runProgram = false;
                //exit
                break;
            
            }
        }
    }    


    // returns the number that the user typed in
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

    private void sortalphabetically() 
    {
        fridge.sortFridgeByName(); // Call the sortFridgeByName method
        wait(1000);
        fridge.displayContents(); // Display the sorted contents
        wait(1000);
    }
    private void sortbyquantity() 
    {
        fridge.sortFridgeByQuantity(); // Call the sortFridgeByAmount method
        wait(1000);
        fridge.displayContents(); // Display the sorted contents
        wait(1000);
    }

    private void manageFood() 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select operation: \n 1-Add ingredient \n 2-Remove ingredient");
        int operation = getUserInt(1, 2);

        switch (operation) 
        {
            case 1:
                // Add ingredient
                fridge.addIngredient(createIngredient());
                fridge.displayContents();

                break;
            case 2:
                // Remove ingredient
                System.out.println("Enter the name of the ingredient to remove:");
                String foodName = scanner.nextLine();
                fridge.removeIngredient(foodName);
                System.out.println("Ingredient removed successfully.");
                break;
        }
    }

    private Ingredient createIngredient() // user creates an ingredient
    {   

        String name = getUserIngName();
        System.out.println(name);
        Measurements measurement = getIngMeasurement();
        int amount = getUserIngAmount();


        Ingredient userIng = new Ingredient(name, amount, measurement);
        System.out.println("Successfully added " + userIng.getFoodName() +" to the Fridge\n");
        return userIng;
    }

    private String getUserIngName()
    {
        System.out.println("NAME:");
        Scanner userInput = new Scanner(System.in);

        return userInput.nextLine();
        

    }

    private int getUserIngAmount()
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

    private Measurements getIngMeasurement()
    {
        System.out.println("Enter the appropriate measurement for the Ingredient:\n 1-TBSP\n 2-TSP\n 3-OZ\n 4-C\n 5-QT\n 6-GAL\n 7-LB\n 8-ML\n 9-G\n 10-KG\n 11-L\n 12-L");
        int input = getUserInt(1, 12);
        return Measurements.values()[input];
    }

    private void createMeal() 
    {
        // Logic for creating a meal
        System.out.println("Creating a meal...");
    }

    private static void wait(int ms)// thing waits
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
