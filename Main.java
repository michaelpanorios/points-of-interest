public class Main {
    public static void main(String[] args) {
        //Creating an empty list of RankList type to be filled.
        RankList list = new RankList();

        //Inserting the first node to the list.
        Point point = new Point(5.4, 3.2);
        Record record = new Record(1, point, 6.5);
        list.insert(record);

        //Inserting the second node to the list
        Point point1 = new Point(1.4, 9.2);
        Record record1 = new Record(2, point1, 8.2);
        list.insert(record1);

        //Inserting the third node to the list
        Point point2 = new Point(2.2, 1.2);
        Record record2 = new Record(3, point2, 8);
        list.insert(record2);

        //Printing the whole list before the use of methods.
        System.out.println("Printing the whole list before the use of methods:");
        list.printList();

        //Creating Point p object for nearest method.
        /*Point p = new Point(9,9);

        System.out.println();//skippy line

        //Printing the list of nearest shops based on maximum distance
        System.out.println("Printing the list of nearest shops based on maximum distance:");
        RankList list1 = list.nearest(p,8.4);
        list1.printList();

        System.out.println();//skippy line

        System.out.println("Print the sorted list based on score:");
        list.sort();
        list.printList();

        System.out.println();//skippy line

        //Printing the nodes with best highscores based on number k.
        System.out.println("Print the higher score list based on argument k-nodes:");
        RankList list2=list.highScore(2);
        list2.printList();

        System.out.println();//skippy line

        //Printing the nodes based on minimum score.
        System.out.println("Printing the nodes based on minimum score:");
        RankList list3=list.highScore(8.1);
        list3.printList();

        System.out.println();//skippy line

        //Printing the nodes based on distance from my point p.
        System.out.println("Printing the nodes based on distance from my point p:");
        RankList list4=list.nearest(p,2);
        list4.printList();

        System.out.println();//skippy line

        //Represent the same Ranklist without duplicates ids.
        //Adding a same node.
        Point point3 = new Point(2.2, 1.2);
        Record record3 = new Record(3, point2, 8);
        list.insert(record3);
        System.out.println("Printing the same Ranklist without duplicates ids: ");
        RankList list5=list.inCommonWith(list);
        list5.printList();*/

        //--------------------------------------------------------------------------------------------------------------
        // A,B,C,D implementation.
        //Creating our point argument.
        Point p = new Point(9,9);

        System.out.println();//skippy line


        //About A implementation.
        RankList listA=list.answerOfA(p,list.size(),8.0);//Creating the final list based on distance and a given min score.
        System.out.println("A) List based on distance and a given min score: ");
        listA.printList();

        System.out.println();//skippy line

        //About B implementation.
        list.sortH();//Sort the entire list based on score, from highest one to lowest.
        RankList listB=list.answerOfB(p,7.0);//Creating a final list based on distance and a given max score.
        System.out.println("B) List based on distance and a given max score: ");
        listB.printList();

        System.out.println();//skippy line

        //About C implementation.
        list.sortL();
        RankList listC=list.answerOfC(p,11.0,8.0);
        System.out.println("C) List based on min score and given max distance: ");
        listC.printList();

        System.out.println();//skippy line

        //About D implementation.
        RankList listD=list.answerOfD(p,7.0);
        System.out.println("D) List based on pointers whose distance is less than max distance for 2 different spots: ");
        listD.printList();

    }
}
