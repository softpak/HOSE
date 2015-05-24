package net.minecraft.server;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpUtilities {

    public static final ListeningExecutorService a = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool((new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("Downloader %d").build()));
    private static final AtomicInteger b = new AtomicInteger(0);
    private static final Logger c = LogManager.getLogger();

    public static String a(Map<String, Object> map) {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();

            if (stringbuilder.length() > 0) {
                stringbuilder.append('&');
            }

            try {
                stringbuilder.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
            } catch (UnsupportedEncodingException unsupportedencodingexception) {
                unsupportedencodingexception.printStackTrace();
            }

            if (entry.getValue() != null) {
                stringbuilder.append('=');

                try {
                    stringbuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                } catch (UnsupportedEncodingException unsupportedencodingexception1) {
                    unsupportedencodingexception1.printStackTrace();
                }
            }
        }

        return stringbuilder.toString();
    }

    public static String a(URL url, Map<String, Object> map, boolean flag) {
        return a(url, a(map), flag);
    }

    private static String a(URL url, String s, boolean flag) {
        try {
            Proxy proxy = MinecraftServer.getServer() == null ? null : MinecraftServer.getServer().ax();

            if (proxy == null) {
                proxy = Proxy.NO_PROXY;
            }

            HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection(proxy);

            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpurlconnection.setRequestProperty("Content-Length", "" + s.getBytes().length);
            httpurlconnection.setRequestProperty("Content-Language", "en-US");
            httpurlconnection.setUseCaches(false);
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);
            DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());

            dataoutputstream.writeBytes(s);
            dataoutputstream.flush();
            dataoutputstream.close();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
            StringBuffer stringbuffer = new StringBuffer();

            String s1;

            while ((s1 = bufferedreader.readLine()) != null) {
                stringbuffer.append(s1);
                stringbuffer.append('\r');
            }

            bufferedreader.close();
            return stringbuffer.toString();
        } catch (Exception exception) {
            if (!flag) {
                HttpUtilities.c.error("Could not post to " + url, exception);
            }

            return "";
        }
    }
}
