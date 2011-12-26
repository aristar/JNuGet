package ru.aristar.jnuget;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author unlocker
 */
public class Version implements Comparable<Version> {

    private static Pattern pattern = Pattern.compile("(\\d+)\\.?(\\d*)\\.?(\\d*)\\.?(.*)");

    private static Integer ParseInt(String group) {
        if (group == null || group.isEmpty()) {
            return null;
        } else {
            return Integer.parseInt(group);
        }
    }
    private final Integer major;
    private final Integer minor;
    private final Integer build;
    private final String revision;

    public Version(Integer major, Integer minor, Integer build, String revision) {
        this.major = major;
        this.minor = minor;
        this.build = build;
        this.revision = revision;
    }

    Version(Object[] object) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Integer getMajor() {
        return major;
    }

    public Integer getMinor() {
        return minor;
    }

    public Integer getBuild() {
        return build;
    }

    public String getRevision() {
        return revision;
    }

    public static Version parse(String input) throws Exception {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new Exception("Аргумент неправильный. " + input);
        }
        Integer major = ParseInt(matcher.group(1));
        Integer minor = ParseInt(matcher.group(2));
        Integer build = ParseInt(matcher.group(3));
        String revision = matcher.group(4);
        return new Version(major, minor, build, revision);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Version)) {
            return false;
        } else {
            Version o = (Version) obj;
            return this.major == o.major
                    && this.minor == o.minor
                    && this.build == o.build
                    && stringsNullOrEqual(this.revision, o.revision);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.major);
        hash = 89 * hash + Objects.hashCode(this.minor);
        hash = 89 * hash + Objects.hashCode(this.build);
        hash = 89 * hash + Objects.hashCode(this.revision);
        return hash;
    }
    
    public int compareTo(Version o) {
        if (this.equals(o)) {
            return 0;
        } else {
            if(this.major > o.getMajor() && this.minor > o.getMinor() 
                    && this.build > o.getBuild() 
                    && this.revision.compareToIgnoreCase(o.getRevision()) > 0)
                return 1;
            else 
                return -1;
        }
    }

    private boolean stringsNullOrEqual(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }
        // Сравнение без учета регистра.
        return str1.toLowerCase().equals(str2.toLowerCase());
    }
}