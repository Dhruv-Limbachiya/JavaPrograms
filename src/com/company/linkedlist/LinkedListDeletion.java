package com.company.linkedlist;

public class LinkedListDeletion extends LinkedListIntroduction {

    public static void main(String[] args) {

        LinkedListDeletion linkedList = new LinkedListDeletion();

        // get some initial nodes to perform further operation
        LinkedListDeletion.initialNodes(linkedList); // initialNodes() is inherited method from LinkedListIntroduction(parent class)

        // prints the linked list. Again inherited method from parent class
        linkedList.printLinkedList();

        // prints the length of linked list (inherited one)
        linkedList.printLength();

        // deletes node using specified key or data.
        linkedList.deleteNodeUsingKey(30);

        // prints the linked list(inherited one)
        linkedList.printLinkedList();

        // prints the length of linked list (inherited one)
        linkedList.printLength();

        // deletes node at specified position
        linkedList.deleteNodeAtAnyPosition(5);

        // prints the linked list(inherited one)
        linkedList.printLinkedList();

        // prints the length of linked list (inherited one)
        linkedList.printLength();

        // deletes from the end of the linked list.
        linkedList.deleteNodeFromEnd();

        // prints the linked list(inherited one)
        linkedList.printLinkedList();

        // prints the length of linked list (inherited one)
        linkedList.printLength();
    }

    /**
     * Delete node if data matches with the specified key.
     * @param key - value which is used to find node.
     */
    private void deleteNodeUsingKey(int key) {
        if (head == null) {
            return;
        }

        Node currentNode = head;

        Node previousNode = currentNode; // tracks the previous node of the current node.

        // traverse linked list until it find the node whose data matches with given key.
        while (currentNode.getData() != key) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode(); // move to next node.
        }

        // make previous node points to current node next node which eliminates current node from the linked list.
        previousNode.setNextNode(currentNode.getNextNode());
    }


    /**
     * Delete node at any position in the linked list.
     * @param position - position or location of element to delete.
     */
    private void deleteNodeAtAnyPosition(int position) {
        if (head == null) {
            return;
        }

        Node currentNode = head;


        // If the position of node is first.
        if (position == 0) {
            head = currentNode.getNextNode(); // simply change head to current next node which eliminate the first or current node of the linked list.
            return;
        }

        Node previousNode = currentNode; // tracks previous node.

        int counter = 0;

        // traverse linked list until current node reaches to specified position - 1.
        while (currentNode.getNextNode() != null && counter < position) {
            counter++;
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        // cross-check the position is exactly same as we expect.
        if (currentNode.getNextNode() == null && counter == position) {
            // delete node by changing previous node next to current node next(eliminate the current node).
            previousNode.setNextNode(currentNode.getNextNode());
        } else {
            System.out.println("Position is greater than the linked list size.");
            return;
        }
    }


    /**
     * Delete the last node of the linked list.
     */
    private void deleteNodeFromEnd() {
        if (head == null) {
            return;
        } else if (head.getNextNode() == null) {
            System.out.println("Only one node is present");
        }

        Node currentNode = head;

        Node previous = currentNode; // tracks the previous node.

        // traverse linked list until it reaches to the end.
        while (currentNode.getNextNode() != null) {
            previous = currentNode;
            currentNode = currentNode.getNextNode();
        }

        // make previous node next to null which basically remove the current node from the linked list.
        previous.setNextNode(null);

        /**
         * Another logic
         *  while(curr.next.next != null)
         *  {
         *      curr = curr.next;
         *  }
         *  curr.next = null;
         */
    }
}
