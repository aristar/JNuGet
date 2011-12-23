package ru.aristar.jnuget;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sviridov
 */
public class NuspecFileTest {

    @Test
    public void testParseMethod() throws Exception {
        final String fileName = "/test.nuspec.xml";
        NuspecFile result = NuspecFile.Parse(NuspecFileTest.class.getResourceAsStream(fileName));
        assertEquals("Идентификатор пакета", "Neolant.ProjectWise.IsolationLevel.Implementation", result.getId());
        assertEquals("Версия пакета", Version.parse("1.4.7.550"), result.getVersion());
        fail("Тест не дописан");
    }
}
