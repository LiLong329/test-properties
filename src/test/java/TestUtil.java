
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;


public class TestUtil {

	public static String publicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9MceQhx0hb64t/UvIJjmnjTw/D0/Ltdp9KgmfQko27KXpb3uHBcGbniGLVx7zrGr47FkswOxeNXTdX2KDeP3mcY8W5k9/Xlg4B7E6uW1x3AJdlwkIPzq58ZxZcspAjCCts9g6lR0h8HmdI0p/rLrAdDVolbMpWcuTp7dqnQKtoQIDAQAB";

	public static void main(String[] args) throws Exception {
		 String data = "hello world";
		
		// 获取公钥
		PublicKey publicKey = getPublicKey(publicKeyString);
		// 获取私钥
//		InputStream inputStream = SSORSAUtils.class.getResourceAsStream(privatePath);
//		Key privateKey =getKey(inputStream);
		// 公钥加密
		byte[] encryptedBytes = encrypt(data.getBytes(), publicKey);
//		String encodeBase64 = SsoRSAUtils.encoder.encodeToString(encryptedBytes);
//		System.out.println("加密后：" + new String(encodeBase64));
//
//		byte[] decode = SsoRSAUtils.decoder.decode(encodeBase64);
		// 私钥解密
		byte[] decryptedBytes = SsoRSAUtils.encrypt("sssss".getBytes());
		
		byte[] decrypt = decrypt(decryptedBytes, publicKey);
		System.out.println("解密后：" + new String(decrypt));
	}
//	public static String privateKeyString = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL0xx5CHHSFvri39S8gmOaeNPD8PT8u12n0qCZ9CSjbspelve4cFwZueIYtXHvOsavjsWSzA7F41dN1fYoN4/eZxjxbmT39eWDgHsTq5bXHcAl2XCQg/OrnxnFlyykCMIK2z2DqVHSHweZ0jSn+susB0NWiVsylZy5Ont2qdAq2hAgMBAAECgYBOSzhr7g43FRF+xLDEvlTjqsYAzqRWCAbH/0qGFpfBzQMH7HOxN8ecT79P+5i6fGK0apKou5nVjsezCNMq1zoymWd/63j5Sj+2FNAigMIzfK94SvUucWVt8C/zkdyF+JC3slnijW5D1coGeWAUCqjxDs/UDznMEuT5eMUbfDfb1QJBAPEzr5er6t0/EArtn8vX3uM6HpHiBamdv2ZSV1GPll4y/1aUd7wyVJ/WXVflXUGO+SgS4UBxuoruocW9y9XySoMCQQDIzUPrgn0S+xRxfKhGrI5iq9zeFEKWB5wlf341p5gv/6HH/1jLj/6dhWjSpgjIx45TKKCoaBydVdHNJZN5z34LAkEAxmvHgpUp07IiJ2tNrmo6cGEKbuYp1Fvx7WHFdVIS2BFJ3laqnUYmOYsmJL2J1vmf3CiT5ujoFYyzxjEZczorswJBAL/yb4WWM+dL+avORLFiS62IqdXkOg5eceXqbIPvk+v2Cfk7Xu8f031SRPRv4J/FGojlokW5V/kSSz42ODZNoScCQGUpaItFxHoArGyqjKcIVeGMTEsUzBvYlJLErxuuP+wmcf2FwQ/Dyz4N9DIeg3xLiMcben47ph50OFhOiZEc3M4=";

	static String privatePath = "ZX_PRIVATE.KEY"; // 私钥地址
	
	
	public static final Decoder decoder = Base64.getUrlDecoder();
	public static final Encoder encoder = Base64.getUrlEncoder();
	
	
	
	
	private static Key getKey(InputStream input) throws Exception, IOException {  
        Key key;  
        ObjectInputStream ois = null;  
        try {  
            /** 将文件中的私钥对象读出 */  
            ois = new ObjectInputStream(input);  
            key = (Key) ois.readObject();  
        } catch (Exception e) {  
            throw e;  
        } finally {  
            ois.close();  
        }  
        return key;  
    }  
	
	
	// 公钥加密
	public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");// java默认"RSA"="RSA/ECB/PKCS1Padding"
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(content);
	}

	// 私钥解密
	public static byte[] decrypt(byte[] content, Key privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(content);
	}

	// 将base64编码后的公钥字符串转成PublicKey实例
	public static PublicKey getPublicKey(String publicKey) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(publicKey.getBytes());
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(keySpec);
	}

	// 将base64编码后的私钥字符串转成PrivateKey实例
	public static PrivateKey getPrivateKey(String privateKey) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(privateKey.getBytes());
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(keySpec);
	}


}
