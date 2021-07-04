class RankList {
    private Node first;
    private Node current;
    private int nodeCount;
    private Record record;

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public void printList() {
        Node current = first;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public RankList() {}

    //Calculating the numbers of nodes onto a list.
    public int size() { return nodeCount; }

    //Inserting a new node to a list.
    public int insert(Record poi) {
        Node node = new Node(poi); //making space for a node of type Node
        node.setNext(null);        //setting next pointer to null
        if (null == first) {       //when linked list is empty
            first = node;
            current = node;
        } else {                   //when linked list is non-empty
            current.setNext(node); //setting current pointer to inserted node
            current = node;        //setting current pointer to that node
        }
        return ++nodeCount;        //returning the size of the list
    }

    //Sorting the list based on high score.
    public void sortH() {
        if (size()>1) {
            for(int i = 0; i<size(); i++){
                Node current=this.first;
                Node next=this.first.next;
                for(int j=0;j<size()-1;j++){
                    if(current.getPoi().score<next.getPoi().score){
                        Record temp = current.getPoi();
                        current.poi=next.poi;
                        next.poi=temp;
                    }
                    current=next;
                    next=next.next;
                }
            }

        }
    }
    //Sorting the list based on low score
    public void sortL(){
        if (size()>1) {
            for(int i = 0; i<size(); i++){
                Node current=this.first;
                Node next=this.first.next;
                for(int j=0;j<size()-1;j++){
                    if(current.getPoi().score>next.getPoi().score){
                        Record temp = current.getPoi();
                        current.poi=next.poi;
                        next.poi=temp;
                    }
                    current=next;
                    next=next.next;
                }
            }

        }
    }

    public RankList nearest(Point p, int k) {
        RankList scoreList = new RankList();
        if(size()>1){
            for(int i=0;i<size();i++){
                Node current=this.first;
                Node next=this.first.next;
                for(int j=0;j<size()-1;j++){
                    if(current.getPoi().getLocation().dist(p)<next.getPoi().getLocation().dist(p)){
                        Record temp=current.getPoi();
                        current.poi=next.poi;
                        next.poi=temp;
                    }
                    current=next;
                    next=next.next;
                }
            }
        }
        Node current1=this.first;
        if(k>0 && k<=size()){
            for(int i=0;i<k;i++){
                scoreList.insert(current1.getPoi());
                current1=current1.getNext();
            }
            return scoreList;
        }
        return null;
    }

    public RankList nearest (Point p,double maxDist){
        RankList nearList = new RankList();
        Node current = this.first;
        while (current != null) {
            if((current.getPoi().getLocation().dist(p))<maxDist){//Finding the distance between the added points with p argument
                nearList.insert(current.getPoi()); //Insert the distances shorter than maxDist in a new list.
            }
            current = current.getNext();
        }
        return nearList;
    }

    public RankList highScore ( int k){
        RankList highscoreList = new RankList();
        Node current = this.first;
        if(k>0 && k<=size()){
            for(int i=0;i<k;i++){
                highscoreList.insert(current.getPoi());
                current=current.getNext();
            }
            return highscoreList;
        }
        return null;
    }

    public RankList highScoreC ( double minScore){
        RankList minscoreList = new RankList();
        Node current = this.first;
        for(int i=0;i<size();i++){
            if(current.getPoi().score<=minScore){
                minscoreList.insert(current.getPoi());
                current=current.getNext();
            }
        }
        return minscoreList;
    }

        public RankList highScore ( double minScore){
            RankList minscoreList = new RankList();
            Node current = this.first;
            for(int i=0;i<size();i++){
                if(current.getPoi().score>=minScore){
                    minscoreList.insert(current.getPoi());
                    current=current.getNext();
                }
            }
            return minscoreList;
        }

        public RankList inCommonWith (RankList rankList){
        RankList newRankList = new RankList();
        Node temp=first;
        Node current=this.first;
        Node previous=null;
        if(temp!=null && temp.getPoi().id==current.getPoi().id){
            first=temp.next;
            newRankList.insert(current.getPoi());
        }
        while(temp!=null && temp.getPoi().id!=current.getPoi().id){
            newRankList.insert(current.getPoi());
            previous=temp;
            temp=temp.next;
            current=current.next;
        }
        if(temp==null)
            previous.next=temp.next;

        return newRankList;
        }

        public RankList answerOfA(Point p,int k,double minScore){
        RankList aList= new RankList();
        aList=nearest(p,size()).highScore(minScore);
        return aList;
        }

        public RankList answerOfB(Point p,double maxDist){
        RankList bList = new RankList();
        bList=nearest(p,maxDist);
        return bList;
        }

        public RankList answerOfC(Point p,double maxDist,double minScore){
        RankList cList = new RankList();
        cList=highScoreC(minScore).nearest(p, maxDist);
        return cList;
        }

        public RankList answerOfD(Point p,double maxDist){
        RankList dList = new RankList();
        Node current = this.first;
        while (current != null) {
            int counter=0;
            if((current.getPoi().getLocation().dist(p))<maxDist){//Finding the distance between the added points with p argument
                counter++;
            }
            if(counter>=2)dList.insert(current.getPoi());
                current = current.getNext();
        }
        return dList;
        }

}
