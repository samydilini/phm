package org.phm.structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    Tree tree;

    @BeforeEach
    public void setUp() {
        tree = new Tree(1, 'R');
        TreeNode node2 = new TreeNode(2, 'A');
        TreeNode node3 = new TreeNode(3, 'B');
        TreeNode node4 = new TreeNode(4, 'C');

        tree.getRoot().addChild(node2);
        node2.addChild(node3);
        node2.addChild(node4);
    }

    @Test
    public void searchShouldReturnCharacterWhenNumberedNodeFound() {
        Optional<Character> result = tree.searchCharacter(tree.getRoot(), 3);
        assertEquals("B", result.get().toString());
    }

    @Test
    public void searchShouldReturnEmptyWhenNumberedNodeNotFound() {
        Optional<Character> result = tree.searchCharacter(tree.getRoot(), 123);
        assertTrue(result.isEmpty());
    }

}