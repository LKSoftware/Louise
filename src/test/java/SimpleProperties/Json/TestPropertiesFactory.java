package SimpleProperties.Json;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * @author leonk
 */
public class TestPropertiesFactory
{

  @Test
  public void canCreateProperties()
  {
    Map<String, Object> props = new HashMap<>();
    props.put("key1", 200);
    props.put("key2", "test");


    PropertiesFactory systemUnderTest = new PropertiesFactory("TestConfig", props);
    PropertiesStructure result = systemUnderTest.toJsonProperties();

    assertTrue("ConfigName", result.getName().equals("TestConfig"));
    assertThat("PropertiesStructure", result.getProperties(), equalTo(props));

  }
}
