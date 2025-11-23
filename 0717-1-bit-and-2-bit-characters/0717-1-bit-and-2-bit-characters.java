class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0;

        while (idx < bits.length - 1) {
            if (bits[idx] == 0) {
                idx++;
            } else {
                idx += 2;
            }
        }

        return idx == bits.length - 1;
    }
}
