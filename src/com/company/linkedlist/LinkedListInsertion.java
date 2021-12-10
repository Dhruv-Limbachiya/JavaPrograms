package com.company.linkedlist;

public class LinkedListInsertion extends LinkedListIntroduction {

    public static void main(String[] args) {
        LinkedListInsertion linkedList = new LinkedListInsertion();
        LinkedListInsertion.initialNodes(linkedList);

        linkedList.addNodeAtFront(5);

        linkedList.printLinkedList();

        linkedList.printLength();

        linkedList.addNodeAtAnyPosition(2,15);

        linkedList.printLinkedList();

        linkedList.printLength();

        linkedList.addNodeAtTheEnd(50);

        linkedList.printLinkedList();

        linkedList.printLength();
    }

    /**
     * Add node at front position.
     */
    private void addNodeAtFront(int data) {
        Node node = new Node(data);

        if(head == null) {
            head = node; // If there is the linked list is empty then make new node as head directly.
            return;
        }

        node.setNextNode(head);
        head = node;
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

        if(position == 1) {
            addNodeAtFront(data);
            return;
        }

        while (currentNode.getNextNode() != null && counter < position) {
            counter++;
            currentNode = currentNode.getNextNode();
        }

        if(currentNode.getNextNode() == null && counter == position) {
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

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(node);
    }
}
