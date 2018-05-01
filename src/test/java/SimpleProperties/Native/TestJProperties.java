package SimpleProperties.Native;

import SimpleProperties.Json.PropertiesStructure;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class TestJProperties
{

  private static final String TESTNAME = "testconfig";

  @Test
  public void canReadProperties() throws IOException
  {
    JProperties systemUnderTest = new JProperties(TESTNAME, getTestProperties());

    Map<String, Object> test = systemUnderTest.getPropertiesMap();

    assertTrue("entries", test.size() == 2);
    assertThat("entry", test, IsMapContaining.hasEntry("key2", "200"));
  }

  @Test
  public void canProducePropertiesStructure() throws IOException
  {
    JProperties systemUnderTest = new JProperties(TESTNAME, getTestProperties());

    PropertiesStructure ps = systemUnderTest.toJsonProperties();

    assertThat("smoke name", ps.getName(), Is.is(TESTNAME));
    assertThat("smoke entry", ps.getProperties(), IsMapContaining.hasEntry("key2", "200"));

  }


  private File getTestProperties()
  {
    return new File(TestJProperties.class.getResource("../../dummy.properties").getFile());
  }
}
