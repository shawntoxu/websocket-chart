import java.io.PrintStream;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESEncryptor
  implements EncryptService
{
  public static final String ALGORITHM = "DES";
  private static String strDefaultKey = "yeahmobi";
  private static final Log LOGGER = LogFactory.getLog(DESEncryptor.class);
  private SecretKey desKey;

  public DESEncryptor()
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(strDefaultKey.getBytes());
      byte[] pswKey = md.digest();
      DESKeySpec desKeySpec = new DESKeySpec(pswKey);
      SecretKeyFactory desKeyFac = SecretKeyFactory.getInstance("DES");
      this.desKey = desKeyFac.generateSecret(desKeySpec);
    } catch (Exception e) {
      e.printStackTrace();
      LOGGER.error(e.getMessage());
    }
  }

  public String encrypt(String password)
  {
    String enStr = null;
    try {
      Cipher encryptCipher = Cipher.getInstance("DES");
      encryptCipher.init(1, this.desKey);

      byte[] enPassword = encryptCipher.doFinal(password.getBytes("UTF8"));

      enStr = new BASE64Encoder().encode(enPassword);
    }
    catch (Exception e) {
      e.printStackTrace();
      LOGGER.error(e.getMessage());
    }

    return enStr;
  }

  public String decrypt(String password)
  {
    String deStr = null;
    try
    {
      Cipher decryptCipher = Cipher.getInstance("DES");
      decryptCipher.init(2, this.desKey);

      byte[] dePassword = new BASE64Decoder().decodeBuffer(password);

      byte[] dec = decryptCipher.doFinal(dePassword);

      deStr = new String(dec, "UTF8");
    }
    catch (Exception e) {
      e.printStackTrace();
      LOGGER.error(e.getMessage());
    }

    return deStr;
  }

  public static void main(String[] args)
    throws Exception
  {
    DESEncryptor d = new DESEncryptor();
    String s = d.encrypt("12354");
    System.out.println(s.toString());
//    String b = d.decrypt(s);
//    System.out.println(b);
//    String e = d.decrypt("eH44aD3KLpg=");
//    String e = d.decrypt("xCCLuXUi9C/Ew4ywFV7RQuRFOkQ=");
//
//    System.out.print(e);
  }
}