class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long lo = 1;
        long hi = (long) coins[0] * k;

        int totalMasks = 1 << n;
        long[] lcm = new long[totalMasks];

        lcm[0] = 1;

        // Calculate LCM for every subset
        for (int mask = 1; mask < totalMasks; mask++) {
            int bit = Integer.numberOfTrailingZeros(mask);
            int prev = mask & (mask - 1);

            long g = gcd(lcm[prev], coins[bit]);
            long value = lcm[prev] / g;

            // Avoid overflow
            if (value > hi / coins[bit]) {
                lcm[mask] = hi + 1;
            } else {
                lcm[mask] = value * coins[bit];
            }
        }

        // Binary search
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (count(mid, lcm, n) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private long count(long x, long[] lcm, int n) {
        long result = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long d = lcm[mask];

            if (d > x) {
                continue;
            }

            long multiples = x / d;

            if (Integer.bitCount(mask) % 2 == 1) {
                result += multiples;
            } else {
                result -= multiples;
            }
        }

        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}