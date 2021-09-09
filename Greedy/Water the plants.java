// Variation of N meetings in one room
// First create an array of ranges for every sprinkler. Now sort the array in ascending order of the leftmost boundaries. Now traverse the array and pick the sprinklers whose left boundary is greater than Currrent Right Boundary and so on. Finally if the Right Most Boundary is greater than or equal to N print count else print -1.
class pair
{
    int x;
    int y;
    pair(int x1,int y1)
    {
        x = x1;
        y = y1;
    }
}
    
class GFG 
{
  
    // Function to find minimum number of
    // sprinkler to be turned on
    static int minSprinklers(int arr[], int N)
    {
      
        // Stores the leftmost and rightmost
        // point of every sprinklers
        ArrayList<pair> V= new ArrayList<pair>();
        
        // Traverse the array arr[]
        for (int i = 0; i < N; i++) {
            if (arr[i] > -1) {
                V.add(new pair(i - arr[i], i + arr[i]));
            }
        }
      
        // Sort the array sprinklers in
        // ascending order by first element
        Collections.sort(V, new Comparator<pair>() {
            @Override public int compare(pair p1, pair p2)
            {
                return p1.x - p2.x;
            }
        });
    
        // Stores the rightmost range
        // of a sprinkler
        int maxRight = 0;
      
        // Stores minimum sprinklers
        // to be turned on
        int res = 0;
    
        int i = 0;
    
        // Iterate until maxRight is
        // less than N
        while (maxRight < N) {
    
            // If i is equal to V.size()
            // or V[i].first is greater
            // than maxRight
    
            if (i == V.size() || V.get(i).x > maxRight) {
                return -1;
            }
            // Stores the rightmost boundary
            // of current sprinkler
            int currMax = V.get(i).y;
    
            // Iterate until i+1 is less
            // than V.size() and V[i+1].first
            // is less than or equal to maxRight
            while (i + 1 < V.size()
                   && V.get(i+1).x <= maxRight) {
    
                // Increment i by 1
                i++;
              
                // Update currMax
                currMax = Math.max(currMax, V.get(i).y);
            }
    
            // If currMax is less than the maxRight
            if (currMax < maxRight) {
                // Return -1
                return -1;
            }
          
            // Increment res by 1
            res++;
    
            // Update maxRight
            maxRight = currMax + 1;
    
            // Increment i by 1
            i++;
        }
      
        // Return res as answer
        return res;
    }
  
  // Driver code
    public static void main (String[] args)
    {
        int arr[] = { -1, 2, 2, -1, 0, 0 };
        int N = 6 ;
      
        // Function call
        System.out.println(minSprinklers(arr, N));
    }
}
