
public class msort
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    int len = 5;
    
    int [] myArray = new int[len];
    
    for (int i=0; i< len; i++)
    {
      myArray[i] = (int)(Math.random()*1000);
      System.out.println("i="+ i+ "value=" + myArray[i] + "    " );
      
    }
    
    int sorted[] = mergesort(myArray);
    System.out.println("" );
    for (int i=0; i< sorted.length; i++)
    {
      
      System.out.println("i="+ i+ "value=" + sorted[i] + "    " );
      
    }
    
  }

  private static int [] mergesort(int[] unsortedArray)
  {
    
    //base case
    //return if only 1 element
    if(unsortedArray.length <= 1)
      return unsortedArray;
    
    //Split array into 2
    int [] A = new int[unsortedArray.length/2];
    int [] B = new int[unsortedArray.length - A.length];
    System.arraycopy(unsortedArray, 0, A, 0, A.length );
    System.arraycopy(unsortedArray, A.length, B, 0, B.length );
    //merge the 2 halves
    return merge(mergesort(A),mergesort(B), unsortedArray);
    
  }

  private static int [] merge(int[] sortedLeft, int[] sortedRight, int[]unsortedArray)
  {
    int[]tempArray = unsortedArray;
    //replace elements in tempArray with merged and sorted elements from the SortedLeft and SortedRight Arrays
    int leftPointer = 0;
    int rightPointer = 0;
    boolean  someOneIsOutOfBounds = false;
    for(int i = 0; i < tempArray.length; i++)
    {
      if(leftPointer >= sortedLeft.length || rightPointer >= sortedRight.length)
      {
        someOneIsOutOfBounds = true;
      }
      if (!someOneIsOutOfBounds)
      {
        if (sortedLeft[leftPointer] < sortedRight[rightPointer])
        {
          tempArray[i] = sortedLeft[leftPointer];
          leftPointer++;
        }
        else
        {
          tempArray[i] = sortedRight[rightPointer];
          rightPointer++;
        }
      }
      else
      {
        if(leftPointer >= sortedLeft.length)
        {
          //copy elements of sortedRight to tempArray
          tempArray[i] = sortedRight[rightPointer];
          rightPointer++;
          
        }
        else
        {
          //copy elements of sortedLeft to tempArray
          tempArray[i]= sortedLeft[leftPointer];
          leftPointer++;
        }
        break;
      }
      
    }
    
    //MainArray is sorted after this call
     return tempArray;
  }

 
  
  
  
  
  
  
}
