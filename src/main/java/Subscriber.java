import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Subscriber implements Runnable {
    private List<Bufferimp> bufferimps;

    public Subscriber(List<Bufferimp> bufferimps) {
        this.bufferimps = bufferimps;
    }

    @Override
    public void run() {
        read();
    }

    public List<Bufferimp> getBufferimps() {
        return bufferimps;
    }

    public void read() {
        if (!this.bufferimps.isEmpty()) {
            Lock lock = new ReentrantLock();

            int index = new Random().nextInt(bufferimps.size());
            bufferimps.get(index).pop();

        }

    }
}
