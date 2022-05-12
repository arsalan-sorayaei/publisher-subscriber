import java.util.Random;

public class Publisher implements Runnable {

    private Bufferimp buffer;

    public Publisher(Bufferimp buffer) {

        this.buffer = buffer;

    }

    @Override
    public void run() {
        while (true)
            buffer.writeTobuffer(new Random().nextInt(100));
    }


}
