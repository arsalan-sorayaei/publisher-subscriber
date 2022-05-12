import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        System.out.println("*****enter inputs*****");
        System.out.println("enter publisher numbers");
        int Pnumbers = scn.nextInt();
        System.out.println("enter subscriber numbers");
        int Snumbers = scn.nextInt();
        System.out.println("enter buffers numbers");
        int qnumbers = scn.nextInt();

        Bufferimp[] buffer = new Bufferimp[qnumbers];
        //making buffers
        for (int i = 0; i < qnumbers; i++) {
            buffer[i] = new Bufferimp();
        }
        //assign buffers to publisher
        Publisher[] publishers = new Publisher[Pnumbers];
        for (int i = 0; i < Pnumbers; i++) {
            publishers[i] = new Publisher(buffer[new Random().nextInt(qnumbers)]);
        }

        //assign subscriber to buffer
        Subscriber[] subscribers = new Subscriber[Snumbers];

        for (int i = 0; i < Snumbers; i++) {
            int bufferNumber = new Random().nextInt(qnumbers);

            Set<Bufferimp> bufset = new HashSet<>();

            for (int j = 0; j < bufferNumber; j++) {
                bufset.add(buffer[new Random().nextInt(qnumbers)]);
            }
            List<Bufferimp> bufferimpList = new ArrayList<>();

            bufferimpList.addAll(bufset);
            subscribers[i] = new Subscriber(bufferimpList);
        }


        for (Publisher p : publishers) {
            new Thread(p).start();
        }

        for (Subscriber s : subscribers) {
            new Thread(s).start();
        }


    }
}
