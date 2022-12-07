import javax.net.ssl.HttpsURLConnection;
import java.net.*;
import java.io.*;
import java.security.cert.Certificate;

public class HttpsUrlReader {   // 오라클 서버의 인증서 확인
    public static void getUrlInfo() throws IOException {
        URL url = new URL("https://www.oracle.com/");
        System.out.println();
        System.out.println("URL Information");
        System.out.println("   URL Class Name: "+url.getClass().getName());
        System.out.println("   URL as String: "+url.toString());
        System.out.println("   URL Protocol: "+url.getProtocol());

        System.out.println();
        System.out.println("Connection Information");
        URLConnection con = url.openConnection();
        System.out.println("   Connection Class Name: "+con.getClass().getName());
        System.out.println("   Connection as String: "+con.toString());
    }
    public static void getHtml() throws Exception {
        URL url = new URL("https://www.oracle.com/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String line;
        while ((line = in.readLine()) != null)
            System.out.println(line);
        in.close();
    }
    public static void getCertificate() throws IOException {
        URL url = new URL("https://www.oracle.com/");
        System.out.println();
        System.out.println("URL Class Name: "+url.getClass().getName());

        URLConnection con = url.openConnection();
        System.out.println("Connection Class Name: "+con.getClass().getName());

        HttpsURLConnection scon = (HttpsURLConnection) con;
        scon.connect();
        Certificate[] certs = scon.getServerCertificates(); // 인증서 가져오기
        System.out.println("Server Certificate: "+certs[0].toString());
    }

    public static void main(String[] args) throws Exception {
        getUrlInfo();
        //getHtml();
        getCertificate();
    }
}
