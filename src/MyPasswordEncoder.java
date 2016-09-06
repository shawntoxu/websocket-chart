

import com.liferay.portal.kernel.util.DigesterUtil;
import java.io.PrintStream;
import javax.validation.constraints.NotNull;
import org.jasig.cas.authentication.handler.PasswordEncoder;

public class MyPasswordEncoder
  implements PasswordEncoder
{

  @NotNull
  private final String algorithm;

  public MyPasswordEncoder(String algorithm)
  {
    this.algorithm = algorithm;
  }

  public String encode(String password) {
    return DigesterUtil.digest(this.algorithm, new String[] { password });
  }

  public static void main(String[] args)
  {
    MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder("SHA");
//    xCCLuXUi9C/Ew4ywFV7RQuRFOkQ=
    String result = myPasswordEncoder.encode("111111");
    System.out.println(result);
  }
}