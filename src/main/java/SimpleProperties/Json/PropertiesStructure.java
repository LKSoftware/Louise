package SimpleProperties.Json;

import java.util.HashMap;
import java.util.Map;


/**
 * PropertiesStructure JSON class to parse too.
 *
 * @author leonk
 */
public class PropertiesStructure
{

  /**
   * All properties containing Key and Value.
   * HashMap usefull at this point to avoid double keys.
   */
  private Map<String, Object> properties = new HashMap<>();

  /**
   * The name of the {@link PropertiesStructure}.
   * Just for the sake of beautyness.
   */
  private String name;

  /**
   * Returns the name of the {@link PropertiesStructure}.
   *
   * @return String
   */
  public String getName()
  {
    return name;
  }

  /**
   * Sets the name of the {@link PropertiesStructure} if String is empty or null it will set it to 'Config'.
   *
   * @param name String
   */
  public void setName(String name)
  {
    if (name != null || !name.isEmpty())
    {
      this.name = name;
    }
    else
    {
      this.name = "Config";
    }
  }

  /**
   * Returns the properties of a {@link PropertiesStructure}.
   *
   * @return as HashMap<String, Object>
   */
  public Map<String, Object> getProperties()
  {
    return properties;
  }

  /**
   * Sets the PropertiesStructure for the {@link PropertiesStructure}
   *
   * @param properties as Map<String, Object>
   */
  public void setProperties(Map<String, Object> properties)
  {
    this.properties = properties instanceof HashMap ? properties : new HashMap<>(properties);
  }
}

