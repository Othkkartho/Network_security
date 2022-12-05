import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MsgDigest {
    public static void main(String[] args) {
        try {
            // 암호화
            String text = "Hello world DES, Welcome to Cryptography.";
            KeyGenerator generator = KeyGenerator.getInstance("DES"); // DES 키 생성 알고리즘
            SecretKey key = generator.generateKey();
            Cipher enc = Cipher.getInstance("DES/ECB/PKCS5Padding"); // DES 암호화 알고리즘
            enc.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipher = enc.doFinal(text.getBytes());   // text -> cipher
            System.out.println("Cipher text bytes: " + cipher);

            // 복호화
            Cipher dec = Cipher.getInstance("DES/ECB/PKCS5Padding");
            dec.init(Cipher.DECRYPT_MODE, key);
            byte[] plain = dec.doFinal(cipher); // cipher -> plain
            System.out.println("Plain text bytes: " + plain);
            System.out.println("Plain text: " + new String(plain));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}