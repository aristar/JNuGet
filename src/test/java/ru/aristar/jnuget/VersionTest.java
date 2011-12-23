package ru.aristar.jnuget;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author unlocker
 */
public class VersionTest {

    @Test
    public void TestConstructor() throws Exception {
        //GIVEN
        String strVersion = "1.2.3.4";
        //WHEN
        Version version = Version.parse(strVersion);
        //THEN
        Assert.assertEquals("Major", Integer.valueOf(1), version.getMajor());
        Assert.assertEquals("Minor", Integer.valueOf(2), version.getMinor());
        Assert.assertEquals("Build", Integer.valueOf(3), version.getBuild());
        Assert.assertEquals("Revision", "4", version.getRevision());
    }
}
