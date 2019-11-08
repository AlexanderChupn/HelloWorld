package com.example.layersdk;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;

// Layer SDK SessionFactory is abstract class, can be initialized only by provider from outside
// By making it abstract we have kept the key logic in LayerSDK while letting the configuration bit for LayerRunner, or testCode to do.
public abstract class SessionFactory {
    protected Configuration configNeo4j;
    // implement initConfiguration in the outside provider
    protected abstract Configuration getConfiguration();
    private org.neo4j.ogm.session.SessionFactory sfNeo4j;

    // initialize SessionFactory from provider, no SessionFactory constructor in LayerSDK
    public void initSessionFactory(String... packages){
        //add here the validation methods from M1
        //...
        sfNeo4j = new org.neo4j.ogm.session.SessionFactory(configNeo4j, packages);
    }

    // below are all wrapped Neo4j OGM methods as of M1
    public Session openSession(){
        return sfNeo4j.openSession();
    }

    public void close(){
        sfNeo4j.close();
    }
}
