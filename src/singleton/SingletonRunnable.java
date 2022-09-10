package singleton;

public class SingletonRunnable implements Runnable{
    @Override
    public void run() {
        SingletonClassic singletonClassic =
                SingletonClassic.getInstance(SingletonType.DEFAULT);
        System.out.println("Instancia creada, total de instancias: " +
                singletonClassic.getInstancesCount());
    }
}
