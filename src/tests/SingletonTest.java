package tests;

import singleton.SingletonClassic;
import singleton.SingletonClassicFix;

public class SingletonTest {
    public static void main(String[] args) {
        //Pruebas con el Singleton sin areglar
        /**
        //Marca error del alcance del contructor
        SingletonClassic singleton = new SingletonClassic();
        System.out.println(singleton.addTo(3,4));
        System.out.println(singleton.getInstancesCount());
        //Error
        new SingletonClassic();
        System.out.println(singleton.getInstancesCount());
        //Marca error del alcance de instancia
        SingletonClassic.instance.getInstancesCount();
         **/

        //Pruebas con el Singleton arreglado
        SingletonClassicFix singletonFix = SingletonClassicFix.getInstance();
        System.out.println(singletonFix.addTo(3,4));
        System.out.println(singletonFix.getInstancesCount());
    }
}
