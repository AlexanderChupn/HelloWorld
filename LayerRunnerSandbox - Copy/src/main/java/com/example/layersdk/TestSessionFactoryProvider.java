package com.example.layersdk;
import com.example.layersdk.*;
//import org.neo4j.ogm.config.ClasspathConfigurationSource;
//import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.config.Configuration;

public class TestSessionFactoryProvider {
    private ProviderFactory providerSF;
    private class ProviderFactory extends SessionFactory {
        // implement abstract method to initilize Configuration with the .property file name from the Layer Code classpath. Or just simple embedded driver without .properties file.
        protected void initConfiguration(String fileName) {
            System.out.println("Initializing embedded test configuration from TestSessionFactoryProvider");
            //ConfigurationSource props = new ClasspathConfigurationSource(fileName);
            this.configNeo4j = new Configuration.Builder(/*props*/).build();
        
        }
    }

    public void initConfiguration(String fileName) {
        System.out.println("Creating instance of SessionFactory from TestSessionFactoryProvider");
        providerSF = new ProviderFactory();
        providerSF.initConfiguration(fileName);
    }

    public ProviderFactory getProviderFactory() {
        return providerSF;
    }

    public TestSessionFactoryProvider () {
        System.out.println("Creating instance of TestSessionFactoryProvider");
    }
}
