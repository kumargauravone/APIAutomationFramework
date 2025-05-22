package com.APIAutomationFramework.utils;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YAMLReader {

	public Map<String, Object> getQAData() {
        Yaml yaml = new Yaml();

        // Load from resources folder
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("TestDataYAML.yaml");
        if (inputStream == null) {
            throw new RuntimeException("YAML file not found in resources!");
        }

        Map<String, Object> yamlData = yaml.load(inputStream);
        return (Map<String, Object>) yamlData.get("QA");
    }

}
