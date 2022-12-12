public class MaximumProfitinJobScheduling {
    private Map<Integer, Integer> mem;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for(int i=0; i<n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b)-> a[0] - b[0]);
        
        mem = new HashMap<>();
        return dfs(0, jobs);
    }

    public int dfs(int cur, int[][] jobs){
        if(cur == jobs.length) return 0;

        if(mem.containsKey(cur)) return mem.get(cur);

        int next = findNext(cur, jobs);
        int incPro = jobs[cur][2] + (next == -1?0: dfs(next, jobs));
        int exclPro = dfs(cur + 1, jobs);

        mem.put(cur, Math.max(incPro, exclPro));

        return Math.max(incPro, exclPro);
    }

    public int findNext(int cur, int[][] jobs){
        for(int next = cur+1; next < jobs.length; next++){
            if(jobs[next][0] >= jobs[cur][1]){
                return next;
            }
        }

        return -1;
    }
}
