/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.aristar.jnuget;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author unlocker
 */
public class VersionTest {
    
    @Test
    public void TestConstructor() throws Exception
    {
        String strVersion = "1.2.3.4";
        Version version = Version.parse(strVersion);
        Assert.assertEquals("Major", 1, version.getMajor());
        Assert.assertEquals("Minor", 2, version.getMinor());
        Assert.assertEquals("Build", 3, version.getBuild());
        Assert.assertEquals("Revision", "4", version.getRevision());
    }
    
}
