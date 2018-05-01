package SimpleProperties;

/**
 * Properties Converter can convert both back and forth(JSON - properties)
 *
 * @author leonk
 */
public class Converter
{

  private static final Converter INSTANCE = new Converter();

  private Converter()
  {

  }

  public static Converter getInstance()
  {
    return INSTANCE;
  }


}
