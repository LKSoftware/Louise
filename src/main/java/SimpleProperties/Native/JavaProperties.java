package SimpleProperties.Native;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * Represents the native {@link Properties} and uses it to extract properties from it.
 *
 * @author leonk
 */
public class JavaProperties
{

  private Properties properties;

  private final String configName;

  /**
   * Creates a new {@link JavaProperties} with a given configName.
   *
   * @param configName The name of the config.
   * @throws IOException if file not found.
   */
  public JavaProperties(String configName)
  {
    this.configName = configName;
  }

  /**
   * Loads a properties from File.
   *
   * @param file       The .properties file.
   * @throws IOException
   */
  public void load(File file) throws IOException
  {
    properties = new Properties();
    properties.load(new FileInputStream(file));
  }

  /**
   * Loads a properties from InputStream.
   *
   * @param stream     direct input stream containing {@link Properties}.
   * @throws IOException
   */
  public void load(InputStream stream) throws IOException
  {
    properties = new Properties();
    properties.load(stream);
  }

  public void load(Properties properties)
  {
    this.properties = properties;
  }

  /**
   * Generates a map containing Properties from {@link Properties}.
   *
   * @return a Map<Object, Object>
   */
  public Map<Object, Object> getPropertiesMap()
  {
    Map<Object, Object> map = new HashMap<>();
    if (properties != null)
    {
      properties.stringPropertyNames().forEach(name -> map.put(name, properties.getProperty(name)));
    }
    return map;
  }

  /**
   * Returns properties as {@link Properties}.
   *
   * @param properties as Map<Object,Object>
   * @return {@link Properties}
   */
  public Properties toJProperties(Map<Object, Object> properties)
  {
    Properties props = new Properties();
    props.putAll(properties);
    return props;
  }
}
