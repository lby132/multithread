package thread.creation.example;

public class ThreadPriority {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.start();

        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        // task2 우선 순위를 가장 높게 설정
        task2.setPriority(Thread.MAX_PRIORITY);
        task2Thread.start();

        for(int i = 301; i <= 399; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\\nTask3 Finish");
    }

}

class Task1 extends Thread {
    @Override
    public void run() {
        System.out.println("\\nTask1 Start");
        for(int i = 101; i <= 199; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\\nTask1 Finish");
    }
}

class Task2 extends Thread {
    @Override
    public void run() {
        System.out.println("\\nTask2 Start");
        for(int i = 201; i <= 299; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\\nTask2 Finish");
    }
}