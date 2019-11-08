package com.example.layerrunner;
import com.example.layersdk.*;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.config.Configuration;

public class SessionFactoryProvider {
    private ProviderFactory providerSF;
    private class ProviderFactory extends SessionFactory {
        // implement abstract method to initilize Configuration with the .property file name from the Layer Runner classpath
        protected void initConfiguration(String fileName) {
            System.out.println("Initializing configuration");
            ConfigurationSource props = new ClasspathConfigurationSource(fileName);
            this.configNeo4j = new Configuration.Builder(props).build();
        }
    }

    public void initConfiguration(String fileName) {
        System.out.println("Creating instance of SessionFactory from SessionFactoryProvider");
        providerSF = new ProviderFactory();
        providerSF.initConfiguration(fileName);
    }

    public ProviderFactory getProviderFactory() {
        return providerSF;
    }

    public SessionFactoryProvider () {
        System.out.println("Creating instance of SessionFactoryProvider");
    }
}
