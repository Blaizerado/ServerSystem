package de.ilovejava.configuration.serialization;

import java.util.Map;

public interface ConfigurationSerializable {

    public Map<String, Object> serialize();
}
