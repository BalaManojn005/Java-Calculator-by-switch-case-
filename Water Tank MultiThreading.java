import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger waterLevel = new AtomicInteger(50);
    static final int MAX_CAPACITY = 100;
    static final int MIN_CAPACITY = 0;

    public static void main(String[] args) {
        InletThread inlet = new InletThread();
        OutletThread outlet = new OutletThread();
        WaterControllerThread controller = new WaterControllerThread();

        inlet.start();
        outlet.start();
        controller.start();
    }
    static class InletThread extends Thread {
        public void run() {
            while (true) {
                if (waterLevel.get() < MAX_CAPACITY) {
                    waterLevel.getAndIncrement();  // Simulate inlet
                    System.out.println("Inlet: Water Level = " + waterLevel.get());
                }
                try {
                    Thread.sleep(100); // simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class OutletThread extends Thread {
        public void run() {
            while (true) {
                if (waterLevel.get() > MIN_CAPACITY) {
                    waterLevel.getAndDecrement();  // Simulate outlet
                    System.out.println("Outlet: Water Level = " + waterLevel.get());
                }
                try {
                    Thread.sleep(150); // simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class WaterControllerThread extends Thread {
        public void run() {
            while (true) {
                int level = waterLevel.get();
                if (level == MAX_CAPACITY) {
                    System.out.println("Controller: Water is FULL!");
                } else if (level == MIN_CAPACITY) {
                    System.out.println("Controller: Water is EMPTY!");
                } else {
                    System.out.println("Controller: Water Level = " + level);
                }

                try {
                    Thread.sleep(500); // less frequent check
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
