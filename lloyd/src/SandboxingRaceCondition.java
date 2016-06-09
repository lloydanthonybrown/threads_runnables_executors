public class SandboxingRaceCondition {
    public static void main(String[] args)
    {
        System.out.println("We're going to count books in a bag.\n");
        System.out.println("There are 10 books in the bag to start with.\n");

        SandboxingRaceCondition bookBag = new SandboxingRaceCondition(10);

        Runnable addBook = bookBag.new AddBook();
        Runnable removeBook = bookBag.new RemoveBook();

        Thread T1 = new Thread(addBook);
        Thread T2 = new Thread(removeBook);
        T1.start();
        T2.start();
    }

    public SandboxingRaceCondition(int initialBookCount)
    {
        counter = initialBookCount;
    }
    public int counter;

    public class AddBook implements Runnable
    {
        public AddBook(){ }
        public int increaseBookCount()
        {
            return ++counter;
        }
        public void run()
        {
            while (counter < 30)
            {
                System.out.println("One book was added to the book bag. Now there are " + increaseBookCount() + ".");
            }
        }
    }

    public class RemoveBook implements Runnable
    {
        public RemoveBook(){ }
        public int  decreaseBookCount()
        {
            return --counter;
        }
        public void run()
        {
            while (counter > 0)
            {
                System.out.println("One book was discarded from the book bag. Now there are " + decreaseBookCount() + ".");
            }
        }
    }
}
