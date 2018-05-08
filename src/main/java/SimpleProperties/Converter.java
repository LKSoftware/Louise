package SimpleProperties;

import SimpleProperties.Json.PropertiesFactory;
import SimpleProperties.Json.PropertiesReader;
import SimpleProperties.Native.JavaProperties;

import java.util.Map;
import java.util.Properties;

/**
 * Can convert both back and forth(JSON - properties)
 *
 * @author leonk
 */
public class Converter
{

  private static final Converter INSTANCE = new Converter();

  private Converter()
  {
    //NO
  }

  /**
   * Returns the singleton instance of {@link Converter}
   * @return Instance of Converter.
   */
  public static Converter getInstance()
  {
    return INSTANCE;
  }

  /**
   * Creates a new JavaProperties object and returns {@link Properties}.
   * @param config Name of the config. Not held in the properties file itself!
   * @param properties Map containing properties.
   * @return {@link Properties}
   */
  public Properties toProperties(String config, Map<Object,Object> properties)
  {
    return new JavaProperties(config).toJProperties(properties);
  }

  /**
   * Creates {@link Properties} from JSON String.
   * @param json JSON as String.
   * @return {@link Properties}
   */
  public Properties toProperties(String json)
  {
    PropertiesReader pReader = new PropertiesReader(json);
    return new JavaProperties(pReader.getName()).toJProperties(pReader.getProperties());
  }

  /**
   * Creates a new {@link PropertiesFactory} and returns a Json String.
   * @param config Name of the config
   * @param properties Map containing properties.
   * @return Json String
   */
  public String toJson(String config, Map<Object,Object> properties)
  {
    return new PropertiesFactory(config, properties).toString();
  }

  /**
   * Creates a JSON properties from {@link Properties}.
   * @param configName Name of the config.
   * @param properties {@link Properties}
   * @return JSON as String.
   */
  public String toJson(String configName, Properties properties)
  {
    JavaProperties jp = new JavaProperties(configName);
    jp.load(properties);
    return new PropertiesFactory(configName, jp.getPropertiesMap()).toString();
  }

}
