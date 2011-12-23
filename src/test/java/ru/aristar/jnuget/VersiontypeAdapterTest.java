package ru.aristar.jnuget;

import org.junit.Test;
import static org.junit.Assert.*;
import org.semver.Version;

/**
 *
 * @author sviridov
 */
public class VersiontypeAdapterTest {

    @Test
    public void testUnmarshal() throws Exception {
        VersiontypeAdapter adapter = new VersiontypeAdapter();
        Version version = adapter.unmarshal("1.2.3asdasdas");
        assertEquals("Преобразование строки в версию", new Version(new Object[]{1, 2, 3, "asdasdas"}), version);
    }
}
