package singleton;

public class SingletonClassic {
    static SingletonClassic instance = null;
    private static int instancesCount = 0;

    SingletonClassic() {
        System.out.println("\n Se creó una instancia ");
        instancesCount++;
    }

    public int addTo(int x, int y){
        return x + y;
    }

    public static SingletonClassic getInstance() {
        if(instance == null) instance = new SingletonClassic();
        return instance;
    }

    public int getInstancesCount(){
        return instancesCount;
    }
}
