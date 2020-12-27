package homework.Race;


import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private static Semaphore semaphore;

    public Tunnel(int size) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров, вместимость туннеля: " + size;

        semaphore = new Semaphore(size, true);
    }

    @Override
    public void go(Car c) {

            try {
                try {
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                    semaphore.acquire();
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(c.getName() + " закончил этап: " + description);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
