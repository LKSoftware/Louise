package SimpleProperties;

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
