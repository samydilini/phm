package org.phm.structure;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int number;
    public Character character;
    public List<TreeNode> children;

    public TreeNode(int number, Character character) {
        this.number = number;
        this.character = character;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
    }
}
