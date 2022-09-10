package singleton;

public class SingletonSubclassOne extends SingletonClassic{
    private static SingletonClassic instance = null;

    private SingletonSubclassOne(){
        super("Subclass One");
    }

    public static SingletonClassic getInstance(){
        if(instance == null) instance = new SingletonSubclassOne();
        return instance;
    }

    @Override
    public void getMessage(){
        System.out.println("Hello from SingletonSubclass One");
    }
}
