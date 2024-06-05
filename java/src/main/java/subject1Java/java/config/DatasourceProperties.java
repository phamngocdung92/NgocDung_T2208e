package subject1Java.java.config;

import lombok.Getter;
import lombok.Setter;
import subject1Java.java.annotation.ConfigurationProperties;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;

@Getter
@Setter
@ConfigurationProperties(path = "./src/main/resources/subject1Java.properties")
public class DatasourceProperties{
    public static void main(String [] args){
        Class<?> clazz = DatasourceProperties.class;
        ConfigurationProperties config = clazz.getAnnotation(ConfigurationProperties.class);
        System.err.println(config.path());
    }
    private String username;
    private String password;
}