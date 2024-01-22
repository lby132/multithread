package thread.creation.example;

public class ThreadException {

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            //실행될 코드는 새로운 스레드
            throw new RuntimeException("Intentional Exception");
        });

        thread.setName("Misbehaving thread");

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("A critical error happened in thread " + t.getName()
                    + " the error is " + e.getMessage());
        });
        thread.start();
    }
}
