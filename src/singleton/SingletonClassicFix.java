package singleton;

public class SingletonClassicFix {
    private static SingletonClassicFix instance = null;
    private static int instancesCount = 0;

    protected SingletonClassicFix() {
        System.out.println("\n Se creó una instancia ");
        instancesCount++;
    }

    public int addTo(int x, int y){
        return x + y;
    }

    public static SingletonClassicFix getInstance() {
        if(instance == null) instance = new SingletonClassicFix();
        return instance;
    }

    public int getInstancesCount(){
        return instancesCount;
    }
}
