package com.company.linkedlist;

public class LinkedListInsertion extends LinkedListIntroduction {

    public static void main(String[] args) {

        LinkedListInsertion linkedList = new LinkedListInsertion();

        // get some initial nodes to perform further operation
        LinkedListInsertion.initialNodes(linkedList); // initialNodes() is inherited method from LinkedListIntroduction(parent class)

        // adds node at front with data specified.
        linkedList.addNodeAtFront(5);

        // prints the linked list. Again inherited method from parent class
        linkedList.printLinkedList();

        // prints the length of linked list (inherited one)
        linkedList.printLength();

        // adds node at specified position with specified data.
        linkedList.addNodeAtAnyPosition(2,15);

        // prints the linked list(inherited one)
        linkedList.printLinkedList();

        // prints the length of linked list (inherited one)
        linkedList.printLength();

        // adds note at the end of linked list with specified data/
        linkedList.addNodeAtTheEnd(50);

        // prints the linked list(inherited one)
        linkedList.printLinkedList();

        // prints the length of linked list (inherited one)
        linkedList.printLength();
    }

    /**
     * Add node at front position.
     */
    private void addNodeAtFront(int data) {
        Node node = new Node(data);

        if(head == null) {
            head = node; // If the linked list is empty then make new node as head directly.
            return;
        }

        node.setNextNode(head); // add head node address to new node next field which result our new node now points to entire linked list.

        head = node; // make new node as head of linked list.
    }

    /**
     * Add node at any position in linkedlist.
     * @param position - position to add.
     */
    private void addNodeAtAnyPosition( int position,int data){
        if(head == null){
            return;
        }

        int counter = 1;

        Node currentNode = head;

        Node node = new Node(data);

        // if the position to add node is 1 then simply reuse addNodeAtFront(data) method
        if(position == 1) {
            addNodeAtFront(data);
            return;
        }

        // traverse linked list until current node reaches to specified position - 1.
        while (currentNode.getNextNode() != null && counter < position) {
            counter++;
            currentNode = currentNode.getNextNode();
        }

        // cross-check the position is exactly same as we expect.
        if(currentNode.getNextNode() == null && counter == position) {
            // add node.
            node.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(node);
        }else  {
            System.out.println("Position is greater than the linked list size.");
            return;
        }

    }

    /**
     * Add node at the end of linked list.
     */
    private void addNodeAtTheEnd(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node; // If the linked list empty the make the new node as first or last node.
            return;
        }

        Node currentNode = head;

        // traverse linked list until it reaches to last element.
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        // add a new node at the end of linked list.
        currentNode.setNextNode(node);
    }
}
