import java.util.Vector;
import java.io.InputStream;
import java.io.IOException;
import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.5.36
// 

public final class d
{
    private static d aClassd;
    private static DataInputStream aClassDataInputStream;
    private static String aClassString;
    
    private d() {
    }
    
    public static String aClassString(String string, final String str, final String str2) {
        int i;
        do {
            if ((i = string.indexOf(str)) >= 0) {
                string = string.substring(0, i) + str2 + string.substring(i + str.length());
            }
        } while (i >= 0);
        return string;
    }
    
    public static String aClassString(final int n) {
        return aClassString(n, null);
    }
    
    private static synchronized String aClassString(int n, final String[] array) {
        if (d.aClassString == null) {
            d.aClassString = System.getProperty("microedition.locale");
        }
        try {
            if (d.aClassd == null) {
                d.aClassd = new d();
            }
            if (d.aClassDataInputStream == null) {
                InputStream in;
                if ((in = d.aClassd.getClass().getResourceAsStream("/lang." + d.aClassString)) == null) {
                    in = d.aClassd.getClass().getResourceAsStream("/lang.xx");
                }
                if (in == null) {
                    return "X";
                }
                (d.aClassDataInputStream = new DataInputStream(in)).mark(512);
            }
            d.aClassDataInputStream.skipBytes(n << 1);
            d.aClassDataInputStream.skipBytes(d.aClassDataInputStream.readUnsignedShort() - (n << 1) - 2);
            String utf1 = d.aClassDataInputStream.readUTF();
            if (!d.aClassDataInputStream.markSupported()) {
                d.aClassDataInputStream.close();
                d.aClassDataInputStream = null;
            }
            else {
                try {
                    d.aClassDataInputStream.reset();
                }
                catch (IOException ex) {
                    d.aClassDataInputStream.close();
                    d.aClassDataInputStream = null;
                }
            }
            return (String)utf1;
        }
        catch (IOException ex2) {
            d.aClassDataInputStream = null;
            return "E";
        }
    }
    
    private static boolean aBoolean(final String s, final String s2, int index, int n) {
        while (index != s.length() || n != s2.length()) {
            if (index == s.length() || n == s2.length()) {
                return false;
            }
            switch (s2.charAt(n)) {
                case '?': {
                    ++index;
                    ++n;
                    continue;
                }
                case '*': {
                    if (n == s2.length() - 1) {
                        return true;
                    }
                    if (aBoolean(s, s2, index, n + 1)) {
                        return true;
                    }
                    ++index;
                    continue;
                }
                default: {
                    if (s.charAt(index) == s2.charAt(n)) {
                        ++index;
                        ++n;
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static StringBuffer aClassStringBuffer(final InputStream inputStream) {
        final StringBuffer sb = new StringBuffer();
        try {
            if ((char)inputStream.read() != ' ') {
                return sb;
            }
            int read;
            while ((read = inputStream.read()) >= 0) {
                if ((char)read != '\r') {
                    if ((char)read == '\n') {
                        sb.append((Object)aClassStringBuffer(inputStream));
                        break;
                    }
                    sb.append((char)read);
                }
            }
        }
        catch (IOException ex) {}
        return sb;
    }
    
    static {
        d.aClassd = null;
        d.aClassDataInputStream = null;
        final String property = System.getProperty("microedition.platform");
        boolean b = false;
        final StringBuffer sb = new StringBuffer();
        if (d.aClassd == null) {
            d.aClassd = new d();
        }
        Label_0266: {
            final InputStream resourceAsStream;
            if ((resourceAsStream = d.aClassd.getClass().getResourceAsStream("/META-INF/MANIFEST.MF")) != null) {
                while (true) {
                    Label_0140: {
                        try {
                            int read;
                            while ((read = resourceAsStream.read()) >= 0) {
                                if ((char)read != '\r') {
                                    if ((char)read == '\n') {
                                        if (sb.toString().trim().startsWith("Nokia-Platform:")) {
                                            sb.append((Object)aClassStringBuffer(resourceAsStream));
                                            break Label_0140;
                                        }
                                        sb.delete(0, sb.length());
                                    }
                                    else {
                                        sb.append((char)read);
                                    }
                                }
                            }
                            break Label_0266;
                        }
                        catch (IOException ex) {
                            continue;
                        }
//                        continue;
                    }
                    String obj = sb.toString().trim().substring(15);
                    final Vector<String> vector = new Vector<String>();
                    int index;
                    while ((index = obj.indexOf("@")) != -1) {
                        vector.addElement(obj.substring(0, index));
                        obj = obj.substring(index + 1, obj.length());
                    }
                    vector.addElement(obj);
                    for (int i = 0; i < vector.size(); ++i) {
                        if (aBoolean(property, vector.elementAt(i).trim(), 0, 0)) {
                            b = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if (!b) {
                System.exit(0);
            }
        }
        d.aClassString = null;
    }
}
