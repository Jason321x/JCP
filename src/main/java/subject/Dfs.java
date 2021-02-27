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
}
