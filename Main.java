public class Main
{
    public static void main(String[] args)
    {
        Ingredient nr = new Ingredient("bon", 3);

        System.out.println(nr.getFoodAmount() + nr.getFoodName());
    }
}