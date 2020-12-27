package homework.Race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private static boolean winnerFound;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private int count;
    private CyclicBarrier cyclicBarrier;
    private CountDownLatch countDownLatch;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
    }

    public static synchronized void checkWinner(Car c) {
        if (!winnerFound) {
            System.out.println(c.name + " - Пришел первым");
            winnerFound = true;
        }
    }


    @Override
    public void run() {
                try {
                    System.out.println(this.name + " готовится");
                    Thread.sleep(500 + (int) (Math.random() * 800));
                    System.out.println(this.name + " готов");
                    cyclicBarrier.await();
                    cyclicBarrier.await();
                    for (int i = 0; i < race.getStages().size(); i++) {
                        race.getStages().get(i).go(this);
                    }
                    checkWinner(this);
                    cyclicBarrier.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }

    }
}

