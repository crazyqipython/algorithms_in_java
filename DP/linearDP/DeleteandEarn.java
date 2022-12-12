import java.util.*;

class DeleteandEarn{
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] val = new int[n];

        for (int num : nums) {
            val[num] += num;
        }

        int take = 0, skip = 0;

        for (int i = 1; i < n; i++) {
            int takei = skip + val[i];
            int skipi = Math.max(take, skip);

            take = takei;
            skip = skipi;
        }

        return Math.max(take, skip);
    }
}