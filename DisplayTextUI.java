import java.util.Scanner;

public class DisplayTextUI 
{
    boolean runProgram = true;
    //initialize
    Fridge fridge = new Fridge();
    Meal meal = new Meal();
    

    public DisplayTextUI() 
    {
        fridge = new Fridge(); // Initialize the fridge
        fridge.addIngredient(new Ingredient("egg", 3,Measurements.g));
        fridge.addIngredient(new Ingredient("chicken", 5,Measurements.kg));
        fridge.addIngredient(new Ingredient("milk", 4,Measurements.gal));
        fridge.addIngredient(new Ingredient("kiwi", 7,Measurements.pc));

    }

    public void run()
    {
        while (runProgram)
        {

            fridge.displayContents();
            System.out.println("---------------------------\nSelect a number between 1-4 \n---------------------------\nI   1-Sort alphabetically \nII  2-Sort by quantity\nIII 3-Manage food in storage \nIV  4-create meal \nV   5-Display Stuff in the fridge\nVI  6-Exit the program\n\n---------------------------\n");
            int userInput = getUserInt(1,6);

            switch(userInput)
            {
                case 1:
                //sort alphabetically
                    sortAlphabetically();
                break;

                case 2:
                    sortByQuantity();
                //sort quantity
                break;

                case 3:
                    manageFood();
                //add or remove
                break;

                case 4:
                    manageMeals();
                //meal stuff
                // has a set of premade meals
                // user has the ability to create meals
                // 
                
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

    private void sortAlphabetically() // 
    {
        fridge.sortFridgeByName(); // Call the sortFridgeByName method
        wait(750);

    }

    private void sortByQuantity() 
    {
        fridge.sortFridgeByQuantity(); // Call the sortFridgeByAmount method
        wait(750);

    }

    private void manageFood() // 
    {
        Ingredient newIngredient = new Ingredient(null, 0, null); //idk but it works
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Select operation: \n 1-Add ingredient \n 2-Remove ingredient \n 3-Back");
        int operation = getUserInt(1, 3);

        switch (operation) 
        {
            case 1:
                // Add ingredient
                fridge.addIngredient(newIngredient.createIngredient());
                fridge.displayContents();

                break;
            case 2:
                // Remove ingredient
                System.out.println("Enter the name of the ingredient to remove:");
                String foodName = scanner.nextLine();
                wait(450);
                fridge.removeIngredient(foodName);
                System.out.println("Ingredient removed successfully.");
                wait(750);
                break;
            case 3:

                break;
        }
    }

    private void manageMeals() // 
    {

        //ok so
        //Ask the user for the name of the meal
        // ask the user for the ingredients that are required for the meal
        // user can add x amount of ingredients. something like:   1st pass:"1-add ingredient 2-finish"  2nd pass: "1-add another ingredient 2-finish meal"
        wait(400);
        System.out.println("Kitchen::::: \n 1-Create a Meal\n 2-View Meals Available 3-Remove Meals\n 4-Back");
        int userInput = getUserInt(1, 2);

        switch (userInput) {
            case 1:
                ;
                break;
            case 2:
            
                break;

            case 3:
                
                break;

            case 4:
            
                break;
        
    
        }


        // Logic for creating a meal
       // System.out.println("Creating a meal...");
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
