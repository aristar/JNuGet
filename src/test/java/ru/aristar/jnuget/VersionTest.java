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
    
    @Test
    public void TestGreaterMajor() throws Exception {
        // GIVEN
        String newerStr = "2.1.0";
        String olderStr = "1.2";
        Version older = Version.parse(olderStr);
        Version newer = Version.parse(newerStr);
        
        // WHEN 
        int result = older.compareTo(newer);
        
        // THEN
        Assert.assertEquals("Версия "+olderStr+" должна быть старше, чем "+newerStr, -1, result);
    }
    
    @Test
    public void TestGreaterMinor() throws Exception {
        // GIVEN
        String newerStr = "1.3";
        String olderStr = "1.2.0";
        Version older = Version.parse(olderStr);
        Version newer = Version.parse(newerStr);
        
        // WHEN 
        int result = older.compareTo(newer);
        
        // THEN
        Assert.assertEquals("Версия "+olderStr+" должна быть старше, чем "+newerStr, -1, result);
    }
    
    @Test
    public void TestGreaterBuild() throws Exception {
        // GIVEN
        String newerStr = "1.1.3";
        String olderStr = "1.1";
        Version older = Version.parse(olderStr);
        Version newer = Version.parse(newerStr);
        
        // WHEN 
        int result = older.compareTo(newer);
        
        // THEN
        Assert.assertEquals("Версия "+olderStr+" должна быть старше, чем "+newerStr, -1, result);
    }
    
    @Test
    public void TestGreaterRevision() throws Exception {
        // GIVEN
        String newerStr = "1.2.3-beta";
        String olderStr = "1.2.3-alpha";
        Version older = Version.parse(olderStr);
        Version newer = Version.parse(newerStr);
        
        // WHEN 
        int result = older.compareTo(newer);
        
        // THEN
        Assert.assertEquals("Версия "+olderStr+" должна быть старше, чем "+newerStr, -1, result);
    }
}
