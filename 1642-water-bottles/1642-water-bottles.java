class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while(numBottles >= numExchange) {
            int moreBottle = numBottles / numExchange;
            int remain = numBottles % numExchange;
            count += moreBottle;
            numBottles = moreBottle + remain;
        }
        return count;
    }
}