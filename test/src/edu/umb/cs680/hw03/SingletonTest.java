package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class SingletonTest {

    @Test
    public void verifyInstanceNotNull(){
        Singleton instance = Singleton.getInstance();
        
        assertNotNull(instance);
    }

    @RepeatedTest(10)
    public void verifyIdenticalInstance(){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        
        assertSame(instance1, instance2);
    }

}
