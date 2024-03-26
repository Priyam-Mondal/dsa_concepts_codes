/*N – The maximum unit of food you can buy each day.
S – Number of days you are required to survive.
M – Unit of food required each day to survive.
Currently, it’s Monday, and she needs to survive for the next S days.
Find the minimum number of days on which you need to buy food from the shop so that 
she can survive the next S days, or determine that it isn’t possible to survive.

Example 1:

Input: S = 10, N = 16, M = 2
Output: 2
Explaination: One possible solution is to 
buy a box on the first day (Monday), 
it’s sufficient to eat from this box up to 
8th day (Monday) inclusive. Now, on the 9th 
day (Tuesday), you buy another box and use 
the chocolates in it to survive the 9th and 
10th day.
Example 2:

Input: S = 10, N = 20, M = 30
Output: -1
Explaination: She can’t survive even if 
she buy food because the maximum number 
of units she can buy in 1 day is less the 
required food for 1 day. */


class Solution{
    // Function to calculate the minimum number of days to buy food
    static int minimumDays(int S, int N, int M){
        // Calculate the number of Sundays within S days
        int sunday = S / 7;
        // Calculate the number of days available for buying food
        int buyingDays = S - sunday;
        // Initialize the variable to store the answer
        int ans = 0;
        // Calculate the total amount of food needed for M weeks
        int totalFood = S * M;

        // Check if the total food can be bought evenly over N days
        if(totalFood % N == 0){
            // If so, assign the answer as totalFood divided by N
            ans = totalFood / N;
        } else {
            // If not evenly divisible, add one more day to cover the remaining food
            ans = totalFood / N + 1;
        }
        
        // Check if the required days to buy food is less than or equal to the available buying days
        if(ans <= buyingDays){
            // If so, return the calculated minimum days
            return ans;
        } else {
            // If not, return -1 indicating it's not possible to buy food within S days
            return -1;
        }
    }
}
