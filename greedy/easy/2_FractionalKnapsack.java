/*Problem Statement: The weight of N items and their corresponding values are given. 
We have to put these items in a knapsack of weight W such that the total value obtained is maximized.

Note: We can either take the item as a whole or break it into smaller units.

Example:

Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

Output: 240.00

Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. 
Total value = 100 + 60 + 80 = 240.00 


To achieve this, items should be sorted in decreasing order with respect to their value /weight. 
Once the items are sorted we can iterate. 
Pick up items with weight lesser than or equal to the current capacity of the knapsack. 
In the end, if the weight of an item becomes more than what we can carry, break the item into smaller units. 

*/

import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


class MyComparator implements Comparator<Pair>{
	public int compare(Pair a, Pair b){
		double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
	}
}
public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            
        //sorting in decreasing order according to value/weight 
			Arrays.sort(items, new MyComparator());
			
			int curWeight=0;
			double finalVal=0;

			for(int i=0; i<items.length; i++){
				if(curWeight+items[i].weight <= w){
					curWeight+=items[i].weight;
					finalVal+=items[i].value;
				}else{
                    //taking fractional value
					int remain=w-curWeight;
					finalVal+=((double)items[i].value / (double)items[i].weight) * (double)remain;

					break;
				}
			}
			return finalVal;
    }
}
