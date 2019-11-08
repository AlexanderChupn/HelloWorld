package com.example.layercode;
import com.example.layersdk.*;

// Sample code for testing with embedded driver
// LayerDeveloper can't instantiate the sessionFactory because it is abstract, he has to get it from the provider.
public class TestLayerCode {
    public static void main (String[] args) {
        String propFileName = new String("my.properties");
        System.out.println("properties file name = " + propFileName);
        // By naming the provider TestSessionFactoryProvider we have made it easy for the developer to spot if someone copies code from the test case into the entryPoint code and ends up using the TestProvider instead of the one passed into the entryPoint.
        TestSessionFactoryProvider testProvider = new TestSessionFactoryProvider();
        testProvider.initConfiguration("");
        SessionFactory aSF=testProvider.getProviderFactory();
        aSF.initSessionFactory("com.example.layer");
        aSF.openSession();
        aSF.close();
    }
}
