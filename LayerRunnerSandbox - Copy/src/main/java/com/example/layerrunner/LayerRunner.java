package com.example.layerrunner;
import com.example.layersdk.SessionFactory;
import com.example.layercode.EntryPoint;


public class LayerRunner {
    public static void main (String[] args) {
        // initialize Layer SDK SessionFactory with .properties file from the Layer Runner classpath
        String propFileName = new String("my.properties");
        System.out.println("properties file name = " + propFileName);
        EntryPoint EP = new EntryPoint();
        EP.start(runLayerCode(propFileName));
    }

    private static SessionFactory runLayerCode (String path) {
        //SessionFactoryProvider - *implemented in the LayerRunner* has it's own extension of sessionFactory which it configures.
        SessionFactoryProvider sessionFactoryProvider = new SessionFactoryProvider();
        sessionFactoryProvider.initConfiguration(path);
        return sessionFactoryProvider.getProviderFactory();
    }
}
