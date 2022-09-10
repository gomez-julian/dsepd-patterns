package singleton;

public class SingletonClassic {
    static SingletonClassic instance = null;
    private static int instancesCount = 0;

    private SingletonClassic() {
        System.out.println("\n Se creó una instancia ");
        instancesCount++;
    }

    protected SingletonClassic(String message) {
        System.out.println("\n Se creó una instancia desde protected: " + message);
        instancesCount++;
    }

    private static SingletonClassic getInstance() {
        if (instance == null) instance = new SingletonClassic();
        return instance;
    }

    public static synchronized SingletonClassic getInstance(SingletonType type) {
        return
                switch (type) {
                    case SUBCLASS_ONE -> SingletonSubclassOne.getInstance();
                    case SUBCLASS_TWO -> SingletonSubclassTwo.getInstance();
                    default -> SingletonClassic.getInstance();
                };
    }

    public int addTo(int x, int y) {
        return x + y;
    }

    public int getInstancesCount() {
        return instancesCount;
    }

    public void getMessage() {
        System.out.println("Hello from SingletonClassic");
    }
}
