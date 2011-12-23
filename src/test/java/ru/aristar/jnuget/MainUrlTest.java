package ru.aristar.jnuget;

import java.io.StringWriter;
import org.junit.Test;

/**
 *
 * @author sviridov
 */
public class MainUrlTest {

    @Test
    public void testMarshallToXml() throws Exception {
        MainUrl mainUrl = new MainUrl();
        StringWriter writer = new StringWriter();
        mainUrl.writeXml(writer);
        System.out.println(writer.toString());

//        File file = new File("sfdasd");
//        ZipInputStream inputStream = new ZipInputStream(new FileInputStream(file));
//        ZipEntry entry;
//        loop:
//        while ((entry = inputStream.getNextEntry()) != null) {
//            if (!entry.isDirectory() && entry.getName().endsWith(".nuspec")) {
//                byte[] buffer = new byte[(int) entry.getSize()];
//                inputStream.read(buffer, 0, buffer.length);
//                
//                break loop;
//            }
//        }

    }
}
