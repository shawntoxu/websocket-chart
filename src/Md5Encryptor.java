

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encryptor
  implements EncryptService
{
  private final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

  public String encrypt(String originalStr)
  {
    String resultString = null;
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      resultString = byteArrayToHexString(md.digest(originalStr.getBytes()));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return resultString;
  }

  private String byteArrayToHexString(byte[] b)
  {
    StringBuffer resultSb = new StringBuffer();
    for (int i = 0; i < b.length; i++) {
      resultSb.append(byteToHexString(b[i]));
    }
    return resultSb.toString();
  }

  private String byteToHexString(byte b)
  {
    int n = b;
    if (n < 0)
      n += 256;
    int d1 = n / 16;
    int d2 = n % 16;
    return this.hexDigits[d1] + this.hexDigits[d2];
  }

  public String decrypt(String decryptString) {
    throw new BusinessRuntimeException("Not implements");
  }
}