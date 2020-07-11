import java.util.Arrays;

public class threadLesson {

    private static final int size = 1000000;
    private static final int h = size / 2;
    private static float[] arr = new float[size];



    public static void main(String[] args) {

        Arrays.fill(arr, 1);
        System.out.println("When thread is one, time is - " + timeToOneThread() + "ms");

        Arrays.fill(arr, 1);
        System.out.println("When multithreading, time is - " + timeToMultithreading() + "ms");
    }

    public static long timeToOneThread() {

        long startTime = System.currentTimeMillis();

        ourLoop(arr);

        long finishTime = System.currentTimeMillis();

        return finishTime - startTime;
    }


    public static long timeToMultithreading() {
        long startTime = System.currentTimeMillis();
        int h = size / 2;
        float[] array1 = new float[h];
        float[] array2 = new float[h];
        System.arraycopy(arr, 0, array1, 0, h);
        System.arraycopy(arr, h, array2, 0, h);

        Thread thread1 = new Thread(() -> {
            ourLoop(array1);
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            ourLoop(array2);
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(array1, 0, arr, 0, h);
        System.arraycopy(array2, 0, arr, h, h);

        long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }

    private static void ourLoop(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
