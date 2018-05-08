package SimpleProperties.Native;

import SimpleProperties.Json.PropertiesStructure;
import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Unit Test for {@link JavaProperties}.
 *
 * @author leonk
 */
public class TestJavaProperties
{

  private static final String TESTNAME = "testconfig";

  @Test
  public void canReadProperties() throws IOException
  {
    JavaProperties systemUnderTest = new JavaProperties(TESTNAME);
    systemUnderTest.load(getTestProperties());

    Map<Object, Object> test = systemUnderTest.getPropertiesMap();

    assertTrue("entries", test.size() == 2);
    assertThat("entry", test, IsMapContaining.hasEntry("key2", "200"));
  }


  private File getTestProperties()
  {
    return new File(TestJavaProperties.class.getResource("../../dummy.properties").getFile());
  }
}
