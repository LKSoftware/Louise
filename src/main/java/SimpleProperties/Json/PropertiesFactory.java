package SimpleProperties.Json;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


/**
 * Factory to create a JSON {@link PropertiesStructure} object and generating it as a JSON String.
 *
 * @author leonk
 */
public class PropertiesFactory
{

  private static final Gson GSON = new Gson();

  private final PropertiesStructure jsonObject;

  /**
   * Creates a new {@link PropertiesFactory} containing a config name and all jsonObject key, value based.
   * <br>
   * Make sure to provide a {@link HashMap}.
   *
   * @param configName The name of the config object (not filename)
   * @param properties The properties as {@link HashMap}.
   */
  public PropertiesFactory(String configName, Map<String, Object> properties)
  {
    if (properties != null && properties instanceof Map)
    {
      jsonObject = new PropertiesStructure();
      createJsonProperties(configName,
                           properties instanceof HashMap ? properties : new HashMap<>(properties));
    }
    else
    {
      throw new IllegalArgumentException(
        "The given type for properties is not allowed ( " + properties.getClass() + " ).");
    }

  }

  private void createJsonProperties(String configName, Map<String, Object> properties)
  {
    jsonObject.setName(configName);
    jsonObject.setProperties(properties);
  }

  /**
   * Returns the PropertiesStructure as JSON {@link PropertiesStructure} object.
   *
   * @return As {@link PropertiesStructure}
   */
  public PropertiesStructure toJsonProperties()
  {
    return jsonObject;
  }

  /**
   * Returns the {@link PropertiesStructure} as a JSON String.
   *
   * @return As String containing JSON object.
   */
  @Override
  public String toString()
  {
    return GSON.toJson(jsonObject, PropertiesStructure.class);
  }
}
