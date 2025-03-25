/*
Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 

Constraints:

1 <= cardPoints.length <= 105
1 <= cardPoints[i] <= 104
1 <= k <= cardPoints.length
*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //cards ops at ends --> 2 pointers
        // cards in array --> consecutive --> sliding window

        int lsum=0,rsum=0,max_sum=0;

        //initial --> all k cards from left pickup only

        for(int i=0;i<k;i++){
            lsum +=cardPoints[i];
        }
        max_sum = lsum;

        //furtherly, entire k cards be taken like one card minus at left side leads to one card add at right side

        //new index for rightside
        int r_ind=cardPoints.length-1;

        //index at left is i here,and the removal of each one card is like right (k-1) to left(0)
        for(int i=k-1;i>=0;i--){
            lsum = lsum - cardPoints[i];  //left sum related (removal)
            rsum = rsum + cardPoints[r_ind]; //right sum related (add)

            max_sum = Math.max(max_sum, lsum+rsum); // max of current new calculated sum or previous existing sum is max_sum
            
            r_ind --;

        }
        return max_sum;
    }
}
