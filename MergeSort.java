import java.util.ArrayList;

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
      if (left.get(0).getFoodAmount() <= right.get(0).getFoodAmount())
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