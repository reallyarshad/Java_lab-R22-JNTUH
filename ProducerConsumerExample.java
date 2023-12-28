import java.util.LinkedList;

class SharedResource {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public SharedResource(int capacity) {
        this.capacity = capacity;
    }

    public void produce() throws InterruptedException {
        int item = (int) (Math.random() * 100); // Simulating production of an item

        synchronized (this) {
            while (buffer.size() == capacity) {
                // Buffer is full, wait for consumer to consume
                wait();
            }

            System.out.println("Produced: " + item);
            buffer.add(item);

            // Notify consumer that an item is available to consume
            notify();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == 0) {
                // Buffer is empty, wait for producer to produce
                wait();
            }

            int consumedItem = buffer.removeFirst();
            System.out.println("Consumed: " + consumedItem);

            // Notify producer that space is available in the buffer
            notify();
        }
    }
}

class Producer implements Runnable {
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sharedResource.produce();
                Thread.sleep(1000); // Simulating some production time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sharedResource.consume();
                Thread.sleep(1000); // Simulating some consumption time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(5);

        // Creating producer and consumer threads
        Thread producerThread = new Thread(new Producer(sharedResource));
        Thread consumerThread = new Thread(new Consumer(sharedResource));

        // Starting the threads
        producerThread.start();
        consumerThread.start();
    }
}
