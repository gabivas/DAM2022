package en.ase.grupa1097.retea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpsManager {
    private URL url;
    private String adresaUrl;
    private HttpsURLConnection conexiune;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

    public HttpsManager(String adresaUrl) {
        this.adresaUrl = adresaUrl;
    }

    public String process(){
        try {
            return getRezultatHttps();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            inchidereConexiuni();
        }
        return null;
    }

    private void inchidereConexiuni(){
        try {
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        conexiune.disconnect();
    }

    private String getRezultatHttps() throws IOException {
        trustEveryone();
        url= new URL(adresaUrl);
        conexiune= (HttpsURLConnection)
                url.openConnection();
        inputStream=conexiune.getInputStream();
        inputStreamReader=new
                InputStreamReader(inputStream);
        bufferedReader = new
                BufferedReader(inputStreamReader);
        StringBuilder sb=new StringBuilder();
        String linie;
        while((linie=bufferedReader.readLine())!=null){
            sb.append(linie);
        }
        return sb.toString();


    }

    private void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }});
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager(){
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {}
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {}
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }}}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(
                    context.getSocketFactory());
        } catch (Exception e) { // should never happen
            e.printStackTrace();
        }
    }
}
