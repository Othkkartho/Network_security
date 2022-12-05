import java.security.MessageDigest;

public class MsgDigest {
    public static void main(String[] args) {
        try {
            // 인스턴스 생성
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String msg = "Welcome to Java JCA!!";

            digest.update(msg.getBytes());
            byte[] bytes = digest.digest();    // digest 생성

            StringBuilder builder = new StringBuilder();
            for (byte b : bytes)
                builder.append(String.format("%02x", b));

            System.out.println(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}