package com.company.linkedlist;

public class LinkedListDeletion extends LinkedListIntroduction {

    public static void main(String[] args) {
        LinkedListDeletion linkedList = new LinkedListDeletion();

        LinkedListDeletion.initialNodes(linkedList); // Create some initial nodes.

        linkedList.printLinkedList();

        linkedList.printLength();

        linkedList.deleteNodeUsingKey(30);

        linkedList.printLinkedList();

        linkedList.printLength();

        linkedList.deleteNodeAtAnyPosition(5);

        linkedList.printLinkedList();

        linkedList.printLength();

        linkedList.deleteNodeFromEnd();

        linkedList.printLinkedList();

        linkedList.printLength();
    }

    /**
     * Delete node if data matches with the specified key.
     * @param key - value which is used to find node.
     */
    private void deleteNodeUsingKey(int key) {
        if(head == null) {
            return;
        }

        Node currentNode = head;

        Node previousNode = currentNode;

        while (currentNode.getData() != key) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        previousNode.setNextNode(currentNode.getNextNode());
    }


    private void deleteNodeAtAnyPosition(int position) {
        if(head == null) {
            return;
        }

        Node currentNode = head;


        // If the position of node is first.
        if(position == 0) {
            head = currentNode.getNextNode();
            return;
        }

        Node previousNode = currentNode;

        int counter = 0;

        while (currentNode.getNextNode() != null && counter < position) {
            counter++;
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        if(currentNode.getNextNode() == null && counter == position) {
            previousNode.setNextNode(currentNode.getNextNode());
        } else  {
            System.out.println("Position is greater than the linked list size.");
            return;
        }
    }


    private void deleteNodeFromEnd() {
        if(head == null){
            return;
        } else if(head.getNextNode() == null) {
            System.out.println("Only one node is present");
        }

        Node currentNode = head;
        Node previous = currentNode;

        while (currentNode.getNextNode() != null) {
            previous = currentNode;
            currentNode = currentNode.getNextNode();
        }

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
