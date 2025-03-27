class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 1;
        int low = 1;
        int high = 100000;
        
        while (low <= high) {
            int mid = (low + high)/2;
            
            long time = 0;
            boolean isSolved = true;

            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= mid) {
                    time += times[i];
                } else {
                    int wrongCnt = diffs[i] - mid;

                    time += (times[i] * wrongCnt) + times[i];

                    if (i > 0) {
                        time += times[i - 1] * wrongCnt;
                    }
                }
                if (time > limit) {
                    isSolved = false;
                    break;
                }
            }
            if (isSolved) {
                level = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return level;
    }
}