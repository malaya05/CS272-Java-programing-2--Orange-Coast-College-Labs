package edu.orangecoastcollege.cs272.ic07;

/**
 * The <code>HoorayListDemo</code> class simulates and tests the methods of the <code>HoorayList</code> data structure, including
 * adds (both implementations), removes (both implementations), set and toString.  Implicit in these methods are
 * calls to ensureCapacity, indexOf and contains.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class HoorayListDemo {

    /**
     * Main method is the entry point to the HoorayListDemo.
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // TODO: Uncomment once finished with the HoorayList data structure implementation


        HoorayList<String> words = new HoorayList<>();
        System.out.println("~~~Empty HoorayList~~~\n" + words);

        words.add("Aloha");
        words.add("Goodbye");
        System.out.println("\n~~~After adding Aloha and Goodbye~~~\n" + words);

        words.add(0, "Hola");
        words.add(0, "Hello");
        System.out.println("\n~~~After adding Hola and Hello at index 0~~~\n" + words);

        words.remove("Goodbye");
        System.out.println("\n~~~After removing Goodbye~~~\n" + words);

        words.add("JhoneTest");
        words.add("JhoneTest");
        words.add("JhoneTest");
        words.add("JhoneTest");
        words.add("JhoneTest");
        words.add("JhoneTest");
        words.add("JhoneTest");
        words.add("JhoneTest");
        words.add("JhoneTest");

        words.remove(0);
        System.out.println("\n~~~After removing element at index 0~~~\n" + words);
        words.set(1, "Adios");
        System.out.println("\n~~~After setting index 0 to Adios~~~\n" + words);
    }

}

