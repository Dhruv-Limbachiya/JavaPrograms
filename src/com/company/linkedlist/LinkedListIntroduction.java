package com.company.linkedlist;

public class LinkedListIntroduction {
    Node head;

    public static void main(String[] args) {
        LinkedListIntroduction linkedList = new LinkedListIntroduction();
        initialNodes(linkedList);

        linkedList.printLinkedList();

        linkedList.printLength();

        System.out.println(linkedList.searchNode(-20));

        linkedList.getNodeByPosition(3);

        linkedList.findNodeFromTheEndOfLinkedList(7);

        linkedList.findMiddleNodeOfLinkedList();

        linkedList.findTotalOccurrence(10);

    }

    public static void initialNodes(LinkedListIntroduction linkedList) {
        Node node1 = new Node(10);
        linkedList.head = node1;

        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        Node node6 = new Node(60);

        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        node5.setNextNode(node6);
    }

    /**
     * Traverse the linked list.
     */
    protected void printLinkedList() {
        Node node = head;

        System.out.print("Linked List : [");
        while (node != null) {
            if (node.getNextNode() != null) {
                System.out.print(node.getData() + " -> ");
            } else {
                System.out.print(node.getData());
            }

            node = node.getNextNode();
        }
        System.out.print("]");
        System.out.println();
    }

    private int getLength() {
        if (head == null) {
            return 0;
        }

        Node currentNode = head;
        int length = 0;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNextNode();
        }

        return length;
    }

    protected void printLength() {
        System.out.println("Length : " + this.getLength());
    }

    /**
     * Searches node with the given key.
     *
     * @param key - key to match with node's data part.
     * @return - true if found else false.
     */
    private boolean searchNode(int key) {
        if (head == null) {
            return false;
        }

        Node currentNode = head;

        while (currentNode.getNextNode() != null) {
            if (currentNode.getData() == key) {
                return true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return false;
    }

    /**
     * Get node from any position.
     *
     * @param position - position in linked list.
     */
    private void getNodeByPosition(int position) {
        if (head == null) {
            return;
        }

        Node currentNode = head;
        int counter = 0;

        while (currentNode.getNextNode() != null && counter < position) {
            counter++;
            currentNode = currentNode.getNextNode();
        }

        if (counter == position)
            System.out.println("The node at index " + counter + " is " + currentNode.getData());
        else
            System.out.println("Invalid position");
    }

    /**
     * Find the nth node from the last of the linked list or in descending order.
     * @param positionFromLast = position to find the node in descending order.
     */
    private void findNodeFromTheEndOfLinkedList(int positionFromLast) {
        if (head == null) {
            return;
        }


        Node nodeA = head;
        Node nodeB = head;
        int pointer1 = 1;

        if(positionFromLast <= 0) {
            System.out.println("Invalid valid position.Please enter position from 1 to linked list length");
            return;
        }

        while (nodeA.getNextNode() != null) {
            if (pointer1 < positionFromLast) {
                // make k[positionFromLast] hops in the linked list.
                pointer1++;
                nodeA = nodeA.getNextNode();
            } else {
                // pointer one reached to kth position.
                pointer1++;
                // update pointer and nodeA.
                nodeA = nodeA.getNextNode();
                // start moving nodeB and move until nodeA reaches to null
                nodeB = nodeB.getNextNode();
            }
        }

        // If position specified is still greater than pointer which means linked list length.
        if (pointer1 < positionFromLast) {
            // if position is greater than the linked list length.
            System.out.println("Position must not be greater than linked list length");
        } else {
            System.out.println("Node from the last " + positionFromLast + " index is " + nodeB.getData());
        }

    }

    /**
     * Find the middle element in the linked list.
     * If the length of linked list is even like below
     *  1 -> 2 -> 3 -> 4  (2 and 3 are the middle element)
     *  then it will print second middle element.
     */
    private void findMiddleNodeOfLinkedList() {
        if(head == null){
            return;
        }

        Node nodeWith2xSpeed = head;
        Node normalNode = head;

        while(nodeWith2xSpeed != null && nodeWith2xSpeed.getNextNode() != null) {
            nodeWith2xSpeed = nodeWith2xSpeed.getNextNode().getNextNode();
            normalNode = normalNode.getNextNode();
        }

        System.out.println("Middle node is "+normalNode.getData());
    }

    /**
     * Method responsible for finding occurrence of the specified key in the linkedlist.
     * @param key = number to find occurrence for.
     */
    private void findTotalOccurrence(int key) {
        if(head == null) {
            return;
        }

        int numOfOccurrence = 0;

        Node node = head;

        while (node.getNextNode() != null) {
            if(node.getData() == key){
                numOfOccurrence++;
            }
            node = node.getNextNode();
        }

        if(numOfOccurrence > 0) {
            System.out.println("Num of occurrence of key "+key+" is "+numOfOccurrence+" times");
        } else {
            System.out.println("Unable to find any occurrence for the give key");
        }
    }
}

class Node {
    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
        nextNode = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}