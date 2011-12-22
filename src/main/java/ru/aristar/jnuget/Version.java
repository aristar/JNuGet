/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.aristar.jnuget;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author unlocker
 */
public class Version {
    
    private static Pattern parser = Pattern.compile("(\\d+)\\.?(\\d*)\\.?(\\d*)[.-]?(\\w*)");
    
    public static Version Parse(String input) throws Exception
    {
        Matcher matcher = parser.matcher(input);
        if(!matcher.find()){
            throw new Exception("Аргумент неправильный.");
        }
        int major = ParseInt(matcher.group(1));
        int minor = ParseInt(matcher.group(2));
        int build = ParseInt(matcher.group(3));
        String revision = matcher.group(4);
        return new Version(major, minor, build, revision);
    }

    private static int ParseInt(String group) {
        if(group == null || group.isEmpty())
            return 0;
        else
            return Integer.parseInt(group);
    }
    
    private final int major;
    private final int minor;
    private final int build;
    private final String revision;
    
    public Version(int major, int minor, int build, String revision)
    {
        this.major = major;
        this.minor = minor;
        this.build = build;
        this.revision = revision;
    }
    
    public int getMajor()
    {
        return major;
    }
    
    public int getMinor()
    {
        return minor;
    }
    
    public int getBuild()
    {
        return build;
    }
    
    public String getRevision()
    {
        return revision;
    }
    
}
