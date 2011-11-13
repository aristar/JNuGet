package ru.aristar.jnuget;

import java.io.StringWriter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sviridov
 */
public class MainUrlTest {

    @Test
    public void testMarshallToXml() throws Exception {
        MainUrl mainUrl = new MainUrl();
        StringWriter writer = new StringWriter();
        mainUrl.wirteXml(writer);
        System.out.println(writer.toString());
    }
}
