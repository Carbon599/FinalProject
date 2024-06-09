import java.util.ArrayList;
// the only recursion in the whole program......
public class MergeSort
{
  public static ArrayList<Ingredient> mergeSort(ArrayList<Ingredient> ar)
  {
    if (ar.size() <= 1) return ar;
    
    ArrayList<Ingredient> left, right;
    left = new ArrayList<Ingredient>();
    right = new ArrayList<Ingredient>();
    
    for (int i = 0; i < ar.size(); i++)
    {
      if (i % 2 != 0) left.add(ar.get(i));
      else right.add(ar.get(i));
    }

    left = mergeSort(left);
    right = mergeSort(right);


    return merge(left, right);
  }
  
  private static ArrayList<Ingredient> merge(ArrayList<Ingredient> left, ArrayList<Ingredient> right)
  {
    ArrayList<Ingredient> ret = new ArrayList<Ingredient>();
    
    while (!left.isEmpty() && !right.isEmpty())
    {
      if (left.get(0).getFoodName().compareToIgnoreCase(right.get(0).getFoodName()) < right.get(0).getFoodName().compareToIgnoreCase(left.get(0).getFoodName()))
      {

        ret.add(left.get(0));
        left.remove(0);
      }
      else
      {
        ret.add(right.get(0));
        right.remove(0);
      }
    }
    
    while (!left.isEmpty())
    {
      ret.add(left.get(0));
      left.remove(0);
    }
    
    while (!right.isEmpty())
    {
      ret.add(right.get(0));
      right.remove(0);
    }
    return ret;
  }
}