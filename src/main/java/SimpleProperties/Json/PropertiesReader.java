package SimpleProperties.Json;

import com.google.gson.Gson;

import java.io.Reader;
import java.util.Map;


/**
 * Interprets a JSON config.
 *
 * @author leonk
 */
public class PropertiesReader
{

  private static final Gson GSON = new Gson();

  private final PropertiesStructure propertiesStructure;

  /**
   * Creates a PropertiesStructure from JSON.
   *
   * @param json JSON as String
   */
  public PropertiesReader(String json)
  {
    propertiesStructure = GSON.fromJson(json, PropertiesStructure.class);
  }

  /**
   * Creates a PropertiesStructure from JSON.
   *
   * @param json JSON as Reader
   */
  public PropertiesReader(Reader json)
  {
    propertiesStructure = GSON.fromJson(json, PropertiesStructure.class);
  }

  /**
   * Returns the name of the given properties.
   *
   * @return PropertiesStructure name
   */
  public String getName()
  {
    return propertiesStructure.getName();
  }

  /**
   * Returns all the properties as Map.
   *
   * @return a Map
   */
  public Map<Object, Object> getProperties()
  {
    return propertiesStructure.getProperties();
  }

  /**
   * Returns the PropertiesStructure as String.
   *
   * @return a JSON String
   */
  @Override
  public String toString()
  {
    return propertiesStructure.toString();
  }

}
