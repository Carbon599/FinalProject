import java.util.Scanner;
import java.util.ArrayList;

public class User 
{
    //initialize some things
    boolean runProgram = true;
    Fridge fridge = new Fridge();
    ListOfRecipes listMeals = new ListOfRecipes();

    private String longTextWall = "---------------------------\n"+
    "Select a number between 1-4 \n"+
    "---------------------------\n"+
    "I   1-Sort alphabetically \n"+
    "II  2-Sort by quantity\n"+
    "III 3-Manage food in storage \n"+
    "IV  4-Manage Meals \n"+
    "V   5-Exit the program\n"+
    "\n---------------------------\n";
    
    User() // is used to add some pre existing ingredients and meals (idk how else to)
    {
        // added some stuff in the fridge
        fridge.addIngredient(new Ingredient("egg", 3,Measurements.g));
        fridge.addIngredient(new Ingredient("chicken", 5,Measurements.kg));
        fridge.addIngredient(new Ingredient("milk", 4,Measurements.gal));
        fridge.addIngredient(new Ingredient("kiwi", 7,Measurements.pc));
        fridge.addIngredient(new Ingredient("fries", 750,Measurements.g));
        fridge.addIngredient(new Ingredient("gravy", 7,Measurements.pc));
        fridge.addIngredient(new Ingredient("salt", 20,Measurements.g));

        // add  apre-existing recipe for a meal
        ArrayList<Ingredient>  r = new ArrayList<Ingredient>();
        r.add(new Ingredient("fries", 750,Measurements.g));
        r.add(new Ingredient("gravy", 7,Measurements.pc));
        r.add(new Ingredient("salt", 20,Measurements.g));

        listMeals.addRecipe(new Meal("Poutine", r));

    }

    public void run()
    {
        while (runProgram)
        {
            fridge.displayContents();
            System.out.println(longTextWall);
            int userInput = getUserInt(1,5);

            switch(userInput)
            {
                case 1: //sort alphabetically
                    sortAlphabetically();
                break;

                case 2: //sort quantity
                    sortByQuantity();
                break;

                case 3: //add or remove meals 
                    manageFood();

                break;

                case 4:
                    manageMeals();  // has a set of premade meals
                                    // user has the ability to create meals   
                break;

                case 5:
                System.out.println("See you next time :D");
                wait(727);
                runProgram = false;
                //exit
                break;
            }
        }
    }    

    // the main functions
    private void sortAlphabetically() // 
    {
        fridge.sortFridgeByName(); // Call the sortFridgeByName method
        wait(750);
        System.out.println("Fridge sorted lexicographically (alphabetically)!");
        wait(750);

    }

    private void sortByQuantity() 
    {
        fridge.sortFridgeByQuantity(); // Call the sortFridgeByAmount method
        wait(750);
        System.out.println("Fridge sorted by quantity!");
        wait(750);

    }

    private void manageFood() 
    {
        /*
         manageFood() gives the user the option to add or remove ingredients from the "fridge"
         
         */

        
        System.out.println("Select operation: \n 1-Add ingredient \n 2-Remove ingredient \n3-Edit Ingredient\n 4-Back");
        int operation = getUserInt(1, 3);

        switch (operation) // will maybe add a feature where you can change the amount of the specified ingredient
        {
            case 1:
                // Add ingredient
                fridge.addIngredient(createIngredient());
                break;
            case 2:
                // Remove ingredient
                removeIngredient();
                break;
            case 3: 
                // lock in... Edits the Ingredient that the user specified
                editIngredient();
                break;
        }
    }

    private void manageMeals() 
    {

        //ok so this method manages meals // they can create their own meal and even remove some
        // Ask the user for the name of the meal
        // asks the user for the ingredients that are required for the meal
        // user can add x amount of ingredients. something like:   1st pass:"1-add ingredient 2-finish"  2nd pass: "1-add another ingredient 2-finish meal"

        wait(400);
        System.out.println("Kitchen:::: \n 1-Create a Recipe \n 2-View Recipes Available \n3-Remove a Recipe \n4-Create a MEAL\n 4-Back");
        int userInput = getUserInt(1, 4);

        switch (userInput) {
            case 1:
                createRecipe();
                break;
            case 2:
                listMeals.displayMeals();
                break;

            case 3:
                removeRecipe();
                break;

            case 4:
                System.out.println("WIP");
                break;
            
            case 5:
                break;
        
    
        }


        // Logic for creating a meal
       // System.out.println("Creating a meal...");
    }



    // The getter for user inputs and more
    // this one is the "core" of "selection user inputs"
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
    

    //------------------the "get user inputs" for CONFIGURING(creating) an ingredient's attributes--------------------------------

    private Measurements getIngMeasurement() // returns the measurement
    {
        System.out.println("Enter the appropriate measurement for the Ingredient:\n 1-TBSP\n 2-TSP\n 3-OZ\n 4-C\n 5-QT\n 6-GAL\n 7-LB\n 8-ML\n 9-G\n 10-KG\n 11-L\n 12-pc (piece/s)");
        int input = getUserInt(1, 12);
        return Measurements.values()[input];
    }

    private float getUserIngAmount() // returns float
    {

        System.out.println("Amount:");
        Scanner userInput = new Scanner(System.in);

        while (!userInput.hasNextFloat())
        {
            System.out.println("Amount must not have a letter.");
            userInput.next();
        }
        
        return userInput.nextFloat();
        

    }

    private String getUserIngName() // returns string
    {
        System.out.println("Name of Ingredient: ");
        Scanner userInput = new Scanner(System.in);
        String ingredientName;
        do 
        {
            ingredientName = userInput.nextLine(); // consume token

            if (scanIngNames(ingredientName)) // *
            {
                System.out.println("Error: There is already an ingredient with the same name.");
                System.out.println("Name of Ingredient: ");
            }
        } 

        while (scanIngNames(ingredientName)); //  *loop if true
        
        return ingredientName;
        
    }

    //-------------the get user inputs for EDITING(already existing) an ingridient's attributes (pretty much copy and paste but it is what it is) -------------
    private Measurements editIngMeasurement() // returns the measurement
    {
        System.out.println("Enter the appropriate measurement for the Ingredient:\n 1-TBSP\n 2-TSP\n 3-OZ\n 4-C\n 5-QT\n 6-GAL\n 7-LB\n 8-ML\n 9-G\n 10-KG\n 11-L\n 12-pc (piece/s)");
        int input = getUserInt(1, 12);
        return Measurements.values()[input];
    }

    private float editUserIngAmount() // returns float
    {

        System.out.println("New Amount:");
        Scanner userInput = new Scanner(System.in);

        while (!userInput.hasNextFloat())
        {
            System.out.println("Amount must not have a letter.");
            userInput.next();
        }
        
        return userInput.nextFloat();
        

    }

    private String editUserIngName(String oldIngName) // returns string
    {
        System.out.println(" New Name of Ingredient: ");
        Scanner userInput = new Scanner(System.in);
        String ingredientName;
        do 
        {
            ingredientName = userInput.nextLine(); // consume token

            if (scanIngNamesEdit(ingredientName, oldIngName)) 
            {
                System.out.println("Error: There is already an ingredient with the same name.");
                System.out.println("New Name of Ingredient: ");
            }
        } 

        while (scanIngNamesEdit(ingredientName, oldIngName)); // loop if so
        
        return ingredientName;
        
    }


    // ------------------------------CREATE-REMOVE-METHODS-for--RECIPE-----------------------------------------------------

    private String getUserMealName() // returns string
    {
        System.out.println("Name of Meal: ");
        Scanner userInput = new Scanner(System.in);

        return userInput.nextLine();
    }


    private ArrayList<Ingredient> createListOfIngredients() // 
    {   
        ArrayList<Ingredient> list = new ArrayList<Ingredient>();
        boolean addMore = true;
        int counter = 1;
        System.out.println("Options: \n 1-Add an Ingredient \n2-Back (to menu)\n");
        int userInt = getUserInt(1,2);

        switch (userInt) {
            case 1:

            while (addMore)
            {
            System.out.println("Ingredient" + (counter)+":");
            list.add(createIngredientForRecipe());

            System.out.println("\nDo you want to add another ingredient?\n 1-Add Another Ingredient \n2-Finish Meal");
            int userIntTwo = getUserInt(1,2);

            switch (userIntTwo) {
                case 1:
                    addMore = true;
                    counter++;
                    break;
            
                case 2:
                    addMore = false;
                    break;
            }
            }
                break;
        
            case 2:

                break;
        }
        return list;

    }

    private void createRecipe()
    {
        System.out.println("\nOptions: \n 1-Create a Meal \n 2-back");
        int userInt = getUserInt(1,2);

        switch (userInt) {
            case 1:
            String name = getUserMealName(); // couldve added an option go back to here if the user mistyped the name, but ran we out of time. SO just send the user back to menu Lol
            ArrayList<Ingredient> listOfIng = createListOfIngredients();

            Meal e = new Meal(name, listOfIng); 
            System.out.println("\nSucccessfully Added \"" + e.getMealName() +"\" to the list of available meals");
            listMeals.addRecipe(e);
            wait(727);
                break;
        
            case 2:
            wait(272);
            System.out.println("\ngoing back...");
                wait(727);
                break;
        }
    }

    private void removeRecipe()
    {
        listMeals.displayRecipeForRemoval();
        int recipeToRemove = getUserInt(0, listMeals.getRecipeListSize()-1);
        wait(450); 
        listMeals.removeMeal(recipeToRemove);
        System.out.println("Recipie removed successfully...");
        wait(727);

    }
    
    private Ingredient createIngredientForRecipe() // user creates an ingredient //also used in meals
    {   

        String name = getUserIngName();
        Measurements measurement = getIngMeasurement();
        float amount = getUserIngAmount();


        Ingredient userIng = new Ingredient(name, amount, measurement);
        System.out.println("Successfully added " + userIng.getFoodName() +" to the Ingredients list for the meal \n");
        return userIng;
    }



    // -------------------CREATE-REMOVE-and-EDIT-METHODS-for--INGREDIENT-------------------
    private Ingredient createIngredient() // user creates an ingredient 
    {   

        String name = getUserIngName();                 // get the name (if user inputs a name that is already existing, ask again)
        Measurements measurement = getIngMeasurement(); // get the measurement
        float amount = getUserIngAmount();              // get the amount (if not a number base 10, ask again)

        Ingredient userIng = new Ingredient(name, amount, measurement); //create an Ingredient object 
        System.out.println("Successfully added " + userIng.getFoodName() +" to the Fridge\n");
        return userIng; // returns the ingredient to be added to the ingredients list (fridge)
    }

    private void removeIngredient() //user removes an ingredient from the fridge
    {
        fridge.displayContentsForRemoval(); // displays the ingredient list for removal D:
        int itemToRemove = getUserInt(1, fridge.getFridgeSize()); // get the position of the ingredient to be removed
        wait(450);                                                 // I love waiting
        fridge.removeIngredient(itemToRemove-1);                      // remove the ingredient from the fridge!!!!!!!!
        System.out.println("Ingredient removed successfully.");     // indeed
        wait(750); 
    }

    private void editIngredient() //user edits an ingredient from the fridge
    {
        fridge.displayContentsForEdit(); // displays the ingredients eligible for edits
        int itemToEdit = getUserInt(1, fridge.getFridgeSize()); // get position of the ingredient in the list that the user wants to edit
        Ingredient ingredientToEdit = fridge.getIngredient(itemToEdit-1); // GET THAT INGREDIENT!!!
        wait(450);                                                 // I love waiting
        ingredientToEdit.setFoodName(editUserIngName(ingredientToEdit.getFoodName()));            // Sets name
        ingredientToEdit.setFoodMeasurement(editIngMeasurement());  // Sets Measurement
        ingredientToEdit.setFoodAmount(editUserIngAmount());        // Sets Amount
        System.out.println("Ingredient edited successfully.");   // Done :D
        wait(750);
    }



    // fancy stuff
    //the list scanners
    private boolean scanIngNames(String tryIngredient) // return true if there is a ingredient with the same name
    {
        boolean e = false;
        for (int i = 0; i <fridge.getFridgeSize(); i++)
        {
            if (fridge.getIngName(i).equalsIgnoreCase(tryIngredient))
            {
                e =true;
            }     
        }
        return e;
   
    }

    private boolean scanIngNamesEdit(String tryIngredient1, String oldIngName) // return true if there is a ingredient with the same name 
    {                                                                          // BUT NOT THE SAME AS THE "oldIngName"
        boolean e = false;                                                     // There's a difference guys!!!!
        for (int i = 0; i <fridge.getFridgeSize(); i++)
        {
            if (fridge.getIngName(i).equalsIgnoreCase(tryIngredient1))
            {
                if (tryIngredient1.equalsIgnoreCase(oldIngName))
                {
                    break;

                }
                else;
                {
                e = true;
                }
            }    
        }
        return e;
   
    }

    private static void wait(int ms) // thing waits in miliseconds
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
