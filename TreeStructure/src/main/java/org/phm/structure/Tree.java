package org.phm.structure;

import java.util.Optional;

public class Tree {

    private final TreeNode root;

    public Tree(int rootNumber, Character rootCharacter) {
        this.root = new TreeNode(rootNumber, rootCharacter);
    }
    public TreeNode getRoot() {
        return root;
    }


    public Optional<Character> searchCharacter(TreeNode node, int target) {
        if (node.number == target) {
            return Optional.of(node.character);
        }

        // Recursive search
        for (TreeNode child : node.children) {
            Optional<Character> result= searchCharacter(child, target);
            if (result.isPresent()) {
                return result;
            }
        }

        return Optional.empty();
    }
}
