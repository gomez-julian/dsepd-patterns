package tests;

import org.junit.jupiter.api.Test;
import singleton.SingletonClassic;
import singleton.SingletonRunnable;
import singleton.SingletonSubclassOne;
import singleton.SingletonType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    public void testIllegalCreation() {
        // The following line will not compile because the constructor is not visible.
        // SingletonClassic singletonClassic = new SingletonClassic();
    }

    @Test
    public void testSingletonEquality() {
        SingletonClassic firstsSingleton = SingletonClassic.getInstance(SingletonType.DEFAULT);
        assertNotNull(firstsSingleton);
        SingletonClassic secondSingleton = SingletonClassic.getInstance(SingletonType.DEFAULT);
        assertNotNull(secondSingleton);

        assertEquals(firstsSingleton, secondSingleton);
    }

    @Test
    public void testSubclassesInstances() {
        SingletonClassic singletonInstanceOne = SingletonClassic.getInstance(SingletonType.SUBCLASS_ONE);
        SingletonClassic singletonInstanceTwo = SingletonClassic.getInstance(SingletonType.SUBCLASS_ONE);
        assertEquals(singletonInstanceOne, singletonInstanceTwo);

        SingletonClassic singletonInstanceThree = SingletonClassic.getInstance(SingletonType.SUBCLASS_TWO);
        assertNotEquals(singletonInstanceOne, singletonInstanceThree);

        SingletonClassic singletonInstanceFour = SingletonClassic.getInstance(SingletonType.SUBCLASS_ONE);
        assertEquals(singletonInstanceTwo, singletonInstanceFour);
    }

    @Test
    public void testCreatingSubclasses() {
        SingletonClassic instanceOne = SingletonClassic.getInstance(SingletonType.SUBCLASS_ONE);
        SingletonClassic instanceTwo = SingletonClassic.getInstance(SingletonType.SUBCLASS_TWO);
        SingletonClassic instanceThree = SingletonClassic.getInstance(SingletonType.DEFAULT);
        SingletonClassic instanceFour = SingletonClassic.getInstance(SingletonType.DEFAULT);
        SingletonClassic instanceFive = SingletonClassic.getInstance(SingletonType.SUBCLASS_ONE);
        SingletonClassic instanceSix = SingletonClassic.getInstance(SingletonType.DEFAULT);
        SingletonClassic instanceSeven = SingletonClassic.getInstance(SingletonType.SUBCLASS_ONE);

        assertEquals(instanceOne.getInstancesCount(), instanceSeven.getInstancesCount());
        assertEquals(instanceSix.getInstancesCount(), 3);
    }

    @Test
    public void testSingletonThreads(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 3; i++)
            executorService.execute(new SingletonRunnable());
        executorService.shutdown();
        while (!executorService.isTerminated()){}
        System.out.println("Todos los hilos terminados");
    }

}
