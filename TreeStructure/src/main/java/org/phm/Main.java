package org.phm;

import org.apache.commons.lang3.StringUtils;
import org.phm.structure.Tree;
import org.phm.structure.TreeNode;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = createTree();

        System.out.println("#############################");
        System.out.println("Welcome to tree structure solution");
        System.out.println("To search enter a valid number \n to exit enter X");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String inString;

        do {
            inString = scanner.nextLine().trim().toUpperCase();
            if (StringUtils.isNumeric(inString)) {
                Optional<Character> result = tree.searchCharacter(tree.getRoot(), Integer.parseInt(inString));
                System.out.println(result.map(character -> "Character is " + character).orElse("Character not found to the given number"));
            } else {
                System.out.println(inString + " is not a valid input");
            }

        } while (!inString.equals("X"));
        System.out.println("You are exiting the system");
        scanner.close();
        System.out.println("#############################");


    }

    private static Tree createTree() {
        Tree tree = new Tree(1, 'R');
        TreeNode node2 = new TreeNode(4, 'G');
        TreeNode node3 = new TreeNode(2, 'F');
        TreeNode node4 = new TreeNode(8, 'Q');

        TreeNode node21 = new TreeNode(6, 'H');
        TreeNode node22 = new TreeNode(10, 'E');

        tree.getRoot().addChild(node2);
        tree.getRoot().addChild(node3);
        tree.getRoot().addChild(node4);

        node2.addChild(node21);
        node2.addChild(node22);

        TreeNode node31 = new TreeNode(5, 'Z');
        TreeNode node32 = new TreeNode(7, 'P');
        TreeNode node33 = new TreeNode(11, 'L');

        node3.addChild(node31);
        node3.addChild(node32);
        node3.addChild(node33);

        TreeNode node311 = new TreeNode(3, 'X');

        node31.addChild(node311);

        TreeNode node41 = new TreeNode(9, 'U');

        node4.addChild(node41);

        TreeNode node411 = new TreeNode(12, 'T');
        TreeNode node412 = new TreeNode(13, 'D');

        node41.addChild(node411);
        node41.addChild(node412);

        return tree;
    }
}