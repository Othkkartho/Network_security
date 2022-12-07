import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAHandler {
    public static void main(String[] args) {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = generator.generateKeyPair();

            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

            Cipher encrypt = Cipher.getInstance("RSA");
            encrypt.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] cipherText = encrypt.doFinal("This is cold day".getBytes());
            System.out.println(cipherText);

            Cipher decrpt = Cipher.getInstance("RSA");
            decrpt.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] plainText = decrpt.doFinal(cipherText);
            System.out.println(new String(plainText));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }
}