

public class BusinessRuntimeException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  private Throwable rootCause;
  private String errorKey;
  private String[] errorParam;
  private Object[] errorObjectParam;

  public BusinessRuntimeException(String arg0)
  {
    super(arg0);
    this.errorKey = arg0;
    this.rootCause = this;
  }

  public BusinessRuntimeException()
  {
  }

  public BusinessRuntimeException(String s, Throwable e) {
    this(s);
    if ((e instanceof BusinessRuntimeException))
      this.rootCause = ((BusinessRuntimeException)e).rootCause;
    else
      this.rootCause = e;
  }

  public BusinessRuntimeException(Throwable e)
  {
    this("", e);
  }

  public Throwable getRootCause() {
    return this.rootCause;
  }

  public String getErrorKey()
  {
    return this.errorKey;
  }

  public Object[] getErrorObjectParam()
  {
    return this.errorObjectParam;
  }

  public void setErrorObjectParam(Object[] errorObjectParam) {
    this.errorObjectParam = errorObjectParam;
  }

  public BusinessRuntimeException(String key, Object[] objectParam) {
    this(key);
    this.errorObjectParam = objectParam;
  }

  public String[] getErrorParam() {
    return this.errorParam;
  }

  public void setErrorParam(String[] errorParam) {
    this.errorParam = errorParam;
  }
}