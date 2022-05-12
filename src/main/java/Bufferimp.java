
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

public class Bufferimp {

    private Queue<Integer> queue;
    private Lock lock;
    private int size;
    private int MAX_LENGTH = 3;

    public Bufferimp() {
        lock = new ReentrantLock();
        this.size = 5;
        queue = new LinkedList<>();
    }

    public Lock getLock() {
        return lock;
    }

    public int getSize() {
        return size;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }


    public void pop() {

        try {
            while (true) {
                if (!queue.isEmpty()) {
                    lock.lock();
                    int pop = queue.remove();
                    System.out.println(currentThread().getName() + " pop : \n" + pop);
                    lock.unlock();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("queue is empty");
        }

    }

    public boolean writeTobuffer(int number) {

        if (queue.size() < MAX_LENGTH) {
            lock.lock();
            queue.add(number);
            System.out.println(currentThread().getName() + " add : \n" + number);
            lock.unlock();
            return true;
        }
        return false;


    }

}
