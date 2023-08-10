package com.franca.restassureddemo.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlReader {
    public static String getLocalUrl() {
        Yaml yaml = new Yaml();
        InputStream inputStream = YamlReader.class.getClassLoader().getResourceAsStream("application.yaml");
        Map<String, Map<String, String>> valuesMap = yaml.load(inputStream);

        return valuesMap.get("local").get("url");
    }

    public static String getSchema(String classSchema){
        Yaml yaml = new Yaml();
        InputStream inputStream = YamlReader.class.getClassLoader().getResourceAsStream("application.yaml");
        Map<String, Map<String, String>> valuesMap = yaml.load(inputStream);

        return valuesMap.get("schema").get(classSchema);
    }
}
