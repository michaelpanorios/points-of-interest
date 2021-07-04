class Node {
    public Record poi;
    public Node next;

    public Node(Record poi) {
        this.poi = poi;
    }

    public Record getPoi() {
        return poi;
    }

    public void setPoi(Record poi) {
        this.poi = poi;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        return poi.toString();
    }
}

