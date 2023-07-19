import java.util.*;

public class Solution46 {

    // 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    //深度优先遍历
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        //当前元素是否使用过 标记位 便于回溯
        boolean[] used = new boolean[length];
        //当前排列的内容
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(nums, length, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums, int length, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> result) {
        //深度等于数组长度时 停止遍历
        if (depth == length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, path, used, result);
            path.removeLast();
            used[i]=false;
        }
    }
}
