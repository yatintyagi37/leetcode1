import java.util.*;

class Solution {
    long hi;
    int n;
    int[] coins;
    List<List<Long>> sets;

    public long findKthSmallest(int[] coins, int k) {
        this.coins = coins;
        this.n = coins.length;

        long minCoin = Long.MAX_VALUE;
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long lo = minCoin;
        hi = minCoin * k;

        // sets[i] stores LCMs of combinations having i coins
        sets = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            sets.add(new ArrayList<>());
        }

        // Generate all combinations and their LCM
        for (int i = 0; i < n; i++) {
            setCreation(1L, 1, i);
        }

        // Binary Search
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (getRank(mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private void setCreation(long val, int setNumber, int idx) {
        val = lcm(val, coins[idx]);

        if (val > hi) {
            return;
        }

        sets.get(setNumber).add(val);

        for (int i = idx + 1; i < n; i++) {
            setCreation(val, setNumber + 1, i);
        }
    }

    private long getRank(long value) {
        long rank = 0;

        for (int i = 1; i <= n; i++) {
            for (long lcmValue : sets.get(i)) {

                if (i % 2 != 0) {
                    rank += value / lcmValue;
                } else {
                    rank -= value / lcmValue;
                }
            }
        }

        return rank;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}