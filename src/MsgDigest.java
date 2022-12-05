import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.Key;
import java.security.SecureRandom;

public class MsgDigest {
    public static void main(String[] args) {
        try {
            // 인스턴스 생성
            KeyGenerator generator = KeyGenerator.getInstance("DES"); // 대칭키 방식, 비밀키 생성기를 만듦
            SecureRandom random = new SecureRandom();
            generator.init(random); // random을 통해 generator를 초기화
            Key key = generator.generateKey();  // 비밀키 생성

            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(key);  // 다이제스트 메세지 생성에 비밀키를 활용

            String msg = "Welcom to java JCA!!";
            byte[] bytes = mac.doFinal(msg.getBytes());

            StringBuilder builder = new StringBuilder();
            for (byte b : bytes)
                builder.append(String.format("%02x", b));

            System.out.println(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}