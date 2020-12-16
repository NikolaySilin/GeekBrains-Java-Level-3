public class ThreeThreads {

    static Object monitor = new Object();    // Создаю обьект, будет выступать в роли монитора.
    static volatile int currentNumber = 1;   // volatile для того что-бы не кешировалось.
    static final int operationsNumber = 5;   // Количество оперций

    public static void main(String[] args) {

        // Первый поток для разделителя)
        new Thread(() -> {
            try {
                for (int i = 0; i < operationsNumber; i++) {
                    synchronized (monitor) {
                        while (currentNumber != 1) {
                            monitor.wait();
                        }
                        System.out.print("| ");
                        currentNumber = 2;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < operationsNumber; i++) {
                    synchronized (monitor) {
                        while (currentNumber != 2) {
                            monitor.wait();
                        }
                        System.out.print("A");
                        currentNumber = 3;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < operationsNumber; i++) {
                    synchronized (monitor) {
                        while (currentNumber != 3) {
                            monitor.wait();
                        }
                        System.out.print("B");
                        currentNumber = 4;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < operationsNumber; i++) {
                    synchronized (monitor) {
                        while (currentNumber != 4) {
                            monitor.wait();
                        }
                        // System.out.print("C" + " | ");  ну типа можно было сделать и так разделитель)
                        System.out.print("C");
                        currentNumber = 5;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 5й поток для разделителя))
        new Thread(() -> {
            try {
                for (int i = 0; i < operationsNumber; i++) {
                    synchronized (monitor) {
                        while (currentNumber != 5) {
                            monitor.wait();
                        }
                        System.out.print(" | ");
                        currentNumber = 1;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
