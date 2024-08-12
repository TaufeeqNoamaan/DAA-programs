import java.util.*;

public class TravellingSalesman {
    int n;
    int [][] adjmat;
    int [] verticeSet;

    public TravellingSalesman() {
        n = 4;
        adjmat = new int[][] {
                {0,10,15,20},
                {5,0,9,10},
                {6,13,0,10},
                {8,8,9,0}
        };
        verticeSet = new int[n-1];
        for (int i = 0; i < n; i++) {
            verticeSet[i-1] = i;
        }
    }

    public List<List<Integer>> permute(int [] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Permutation(0,nums,result);
        return result;
    }

    public void Permutation(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n: nums) list.add(n);
            result.add(list);
        }
        else {
            for (int j = i,  l = nums.length; j < l; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                Permutation(i+1, nums, result);
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
