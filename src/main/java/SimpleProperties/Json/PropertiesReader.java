package SimpleProperties.Json;

import com.google.gson.Gson;

import java.io.File;
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

  public PropertiesReader(String json)
  {
    propertiesStructure = GSON.fromJson(json, PropertiesStructure.class);
  }

  public PropertiesReader(Reader json)
  {
    propertiesStructure = GSON.fromJson(json, PropertiesStructure.class);
  }

  public String getName()
  {
    return propertiesStructure.getName();
  }

  public Map<String, Object> getProperties()
  {
    return propertiesStructure.getProperties();
  }

  public String asString()
  {
    return propertiesStructure.toString();
  }

}
