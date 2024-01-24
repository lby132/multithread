package thread.creation.example;

import java.math.BigInteger;

public class LongComputation {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000000000000"), new BigInteger("10000000000000")));

        // 스레드 인터럽트를 정상적으로 처리할 필요가 없을때 setDaemon(true) 를 하면 긴 계산을 하고 있는 스레드가 있어도 main스레드만 종료되어서 앱이 종료된다.
        thread.setDaemon(true);

        thread.start();
        Thread.sleep(100);
//        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base+"^"+power+" = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                // 인터럽트 되어서 앱 종료시키기
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("Prematurely interrupted computation");
//                    return BigInteger.ZERO;
//                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
