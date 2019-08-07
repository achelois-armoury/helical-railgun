package com.achelois.helical.core;

import com.achelois.helical.core.settings.Setting;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class Settings {

    private static Setting self;

    static synchronized Setting getInstance() {
        if (self == null) {

            Yaml yaml = new Yaml(new Constructor(Setting.class));
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("testrail.yml");

            self = yaml.load(inputStream);
            return self;
        }

        return self;
    }

    @Override
    public String toString() {
        return self.toString();
    }
}
