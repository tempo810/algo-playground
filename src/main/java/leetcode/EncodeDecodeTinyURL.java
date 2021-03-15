package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class EncodeDecodeTinyURL {
    private static final char[] ENCODE_LIST = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static final String PREFIX = "http://tinyurl.com/";
    private final Map<String, String> urlMap = new HashMap<>();
    private int counter = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int localCounter;
        synchronized (this) {
            localCounter = counter++;
        }

        StringBuilder sb = new StringBuilder();
        while (localCounter != 0) {
            sb.append(ENCODE_LIST[localCounter % ENCODE_LIST.length]);
            localCounter /= ENCODE_LIST.length;
        }

        String suffix = sb.toString();
        urlMap.put(suffix, longUrl);

        return PREFIX + suffix;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl.substring(PREFIX.length() + 1));
    }
}
