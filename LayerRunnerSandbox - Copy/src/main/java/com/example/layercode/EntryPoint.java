package com.example.layercode;
import com.example.layersdk.SessionFactory;
import org.neo4j.ogm.session.Session;


public class EntryPoint {
    public void start(SessionFactory providerFactory) {
        System.out.println("LayerCode");
        System.out.println("Getting access to instance of SessionFactory");
        providerFactory.initSessionFactory("com.example.layer");
        Session SS=providerFactory.openSession();
        providerFactory.close();
    }
}
