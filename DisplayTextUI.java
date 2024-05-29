import java.util.Scanner;

public class DisplayTextUI 
{
    int userInput;
    boolean runProgram = true;

    Fridge fridge;

    public DisplayTextUI() 
    {
        fridge = new Fridge(); // Initialize the fridge
    }
    
    public void run()
    {
        // Testing only
        Ingredient egg = new Ingredient("egg", 3);
        fridge.addIngredient(egg);
        fridge.displayContents();

        Scanner scanner = new Scanner(System.in);

        while (runProgram)
        {
        
            System.out.println("The stuff in storage: (displays the food in storage and their parameters)");
            System.out.println("Select a number between 1-4 \n 1-Sort alphabetically \n 2-Sort by quantity\n 3-Manage food in storage \n4-create meal");
            int userInput = getUserInt(1,4);

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
                runProgram = false;
                //exit
                break;
            
            }
        }
    scanner.close();
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
        fridge.displayContents(); // Display the sorted contents
    }
    private void sortbyquantity() 
    {
        fridge.sortFridgeByAmount(); // Call the sortFridgeByAmount method
        fridge.displayContents(); // Display the sorted contents
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
                System.out.println("Enter the name of the ingredient:");
                String name = scanner.nextLine();
                System.out.println("Enter the amount of the ingredient:");
                int amount = scanner.nextInt();
                Ingredient ingredient = new Ingredient(name, amount);
                fridge.addIngredient(ingredient);
                System.out.println("Ingredient added successfully.");
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

    private void createMeal() 
    {
        // Logic for creating a meal
        System.out.println("Creating a meal...");
    }

}
