

import org.apache.commons.dbcp.BasicDataSource;

public class CustomDataSource extends BasicDataSource
{
  public void setPassword(String password)
  {
    DESEncryptor des = new DESEncryptor();
    this.password = des.decrypt(password);
  }
}