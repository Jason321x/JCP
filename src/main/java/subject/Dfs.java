package subject;


import dataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: Dfs
 * @description: TODO 类描述
 * @author: jxx
 * @date: 2021/2/27 4:30 PM
 **/
public class Dfs {

    public List<List<Integer>> levelOrder(BinaryTree root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        travel(root, 0, result);
        return result;
    }

    private void travel(BinaryTree root, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.value);
    }

    // 求岛屿的数量
    private int numsOfIsland(char[][] array){
        int m = array.length;
        if (m == 0) {
            return 0;
        }
        int n = array[0].length;
        int count = 0;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (array[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, char[][] array){
        dfs(i, j + 1, array);
        dfs(i + 1, j, array);
        dfs(i + 1, j + 1, array);
    }
}
