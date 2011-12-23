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

    }
}
