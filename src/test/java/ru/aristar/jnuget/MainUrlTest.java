package ru.aristar.jnuget;

import java.io.InputStream;
import java.io.StringWriter;
import org.junit.Ignore;
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
        mainUrl.writeXml(writer);
        System.out.println(writer.toString());
    }

    @Test
    @Ignore
    public void testUnmarshallMainUrlFromXml() throws Exception {
        //GIVEN
        InputStream inputStream = MainUrlTest.class.getResourceAsStream("/main.document.xml");
        //WHEN
        MainUrl result = MainUrl.parse(inputStream);
        //THEN
        assertEquals("URL сервлета", "Полный URL, куда должен быть задеполен сервлет", result.getBaseUrl());
        assertEquals("Описание пакета", "Default", result.getTitle());
        fail("Тестовый метод не дописан");
    }
}
