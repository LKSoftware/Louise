package SimpleProperties.Native;

import SimpleProperties.Json.PropertiesFactory;
import SimpleProperties.Json.PropertiesStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * JProperties represents the native {@link java.util.Properties} and uses it to extract properties from it.
 *
 * @author leonk
 */
public class JProperties
{

  private final java.util.Properties properties;

  private final String configName;

  /**
   * Creates a new {@link JProperties} and loads a property from file.
   *
   * @param configName The name of the config.
   * @param file       The .properties file.
   * @throws IOException if file not found.
   */
  public JProperties(String configName, File file) throws IOException
  {
    this.configName = configName;
    properties = new java.util.Properties();
    properties.load(new FileInputStream(file));
  }

  /**
   * Creates a new {@link JProperties} and loads a property from stream.
   *
   * @param configName The name of the config.
   * @param stream     direct input stream containing {@link java.util.Properties}.
   * @throws IOException if file not found.
   */
  public JProperties(String configName, InputStream stream) throws IOException
  {
    this.configName = configName;
    properties = new java.util.Properties();
    properties.load(stream);
  }

  /**
   * Generates a map containing Properties from {@link java.util.Properties}.
   *
   * @return A Map
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
   * Returns a {@link PropertiesStructure} with all properties.
   *
   * @return PropertiesStructure
   */
  public PropertiesStructure toJsonProperties()
  {
    PropertiesFactory factory = new PropertiesFactory(configName, getPropertiesMap());
    return factory.toJsonProperties();
  }


}
