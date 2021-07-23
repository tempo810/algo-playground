package leetcode;

/**
 * @author Tempo
 */
public class ValidIPAddress {
    public String validIPAddress(String IP) {
        char[] ip = IP.toCharArray();
        if (v4(ip)) {
            return "IPV4";
        }
        if (v6(ip)) return "IPV6";
        return "NEITHER";
    }

    private boolean v6(char[] ip) {
        int l = 0;
        int r = 0;
        int section = 0;
        while (l < ip.length) {
            if (r == ip.length || ip[r] == ':') {
                if (r - l > 4) {
                    return false;
                }
                l = ++r;
                section++;
            } else {
                if (!Character.isAlphabetic(ip[r]) && !Character.isDigit(ip[r])) {
                    return false;
                }
                r++;
            }
        }
        return section == 8 && (Character.isDigit(ip[ip.length - 1]) || Character.isAlphabetic(ip[ip.length - 1]));
    }

    private boolean v4(char[] ip) {
        int l = 0;
        int r = 0;
        int section = 0;
        while (l < ip.length) {
            if (r == ip.length || ip[r] == '.') {
                if (l != r - 1 && ip[l] == '0') {
                    return false;
                }
                int value = 0;
                for (int i = l; i < r; i++) {
                    value *= 10;
                    value += ip[i] - 48;
                }
                if (value > 255) {
                    return false;
                }
                l = ++r;
                section++;
            } else {
                if (!Character.isDigit(ip[r])) {
                    return false;
                }
                r++;
            }
        }
        return section == 4 && Character.isDigit(ip[ip.length - 1]);
    }
}
