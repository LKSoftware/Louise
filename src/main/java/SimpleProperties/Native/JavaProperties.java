package SimpleProperties.Native;

import SimpleProperties.Json.PropertiesFactory;
import SimpleProperties.Json.PropertiesStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * JavaProperties represents the native {@link java.util.Properties} and uses it to extract properties from it.
 *
 * @author leonk
 */
public class JavaProperties
{

  private final java.util.Properties properties;

  private final String configName;

  /**
   * Creates a new {@link JavaProperties} and loads a property from file.
   *
   * @param configName The name of the config.
   * @param file       The .properties file.
   * @throws IOException if file not found.
   */
  public JavaProperties(String configName, File file) throws IOException
  {
    this.configName = configName;
    properties = new java.util.Properties();
    properties.load(new FileInputStream(file));
  }

  /**
   * Creates a new {@link JavaProperties} and loads a property from stream.
   *
   * @param configName The name of the config.
   * @param stream     direct input stream containing {@link java.util.Properties}.
   * @throws IOException if file not found.
   */
  public JavaProperties(String configName, InputStream stream) throws IOException
  {
    this.configName = configName;
    properties = new java.util.Properties();
    properties.load(stream);
  }

  /**
   * Generates a map containing Properties from {@link java.util.Properties}.
   *
   * @return a Map<String, Object>
   */
  Map<String, Object> getPropertiesMap()
  {
    Map<String, Object> map = new HashMap<>();
    if (properties != null)
    {
      properties.stringPropertyNames().forEach(name -> map.put(name, properties.getProperty(name)));
    }
    return map;
  }

  /**
   * Returns properties as {@link java.util.Properties}.
   *
   * @param properties as Map<String,Object>
   * @return {@link java.util.Properties}
   */
  public java.util.Properties toJProperties(Map<String, Object> properties)
  {
    java.util.Properties props = new java.util.Properties();
    props.putAll(properties);
    return props;
  }

  /**
   * Returns a {@link PropertiesStructure} with all properties.
   *
   * @return PropertiesStructure
   */
  public PropertiesStructure toPropertiesStructure()
  {
    PropertiesFactory factory = new PropertiesFactory(configName, getPropertiesMap());
    return factory.toJsonProperties();
  }
}
