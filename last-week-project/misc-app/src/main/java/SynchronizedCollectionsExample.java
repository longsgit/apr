
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedCollectionsExample {
    public static void main(String[] args) {

        //Collections.synchronizedList(new ArrayList<>());
        //Iterator and some other thread tries to modify the collection, you get a ConcurrentModificationException

        List<Integer> numbers = new ArrayList<>(); //Collections.synchronizedList(new ArrayList<>());
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

//        Iterator<Integer> iterator = numbers.iterator();
//        while(iterator.hasNext()) {
//            //System.out.println(iterator.next());
//            //numbers.add(10000);
//        }

        //Thread safe, concurrent list
        //every time any thread that adds an item, it generates a new collection with the (prev values + new value added)
        CopyOnWriteArrayList<Integer> numbersLst = new CopyOnWriteArrayList<>(numbers);
        Iterator<Integer> itr = numbersLst.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            numbersLst.add(1000);
        }
        System.out.println(numbersLst);
    }
}
