package ru.aristar.jnuget;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sviridov
 */
public class VersiontypeAdapterTest {

    @Test
    public void testUnmarshal() throws Exception {
        VersiontypeAdapter adapter = new VersiontypeAdapter();
        Version version = adapter.unmarshal("1.2.3-asdasdas");
        assertEquals("Преобразование строки в версию", new Version(1, 2, 3, "-asdasdas"), version);
    }
}
