package singleton;

public class SingletonSubclassTwo extends SingletonClassic{
    private static SingletonClassic instance = null;

    private SingletonSubclassTwo(){
        super("Subclass Two");
    }

    public static SingletonClassic getInstance(){
        if(instance == null) instance = new SingletonSubclassTwo();
        return instance;
    }

    @Override
    public void getMessage(){
        System.out.println("Hello from SingletonSubclass Two");
    }
}
