package ru.aristar.jnuget;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Версия пакета
 * @author unlocker
 */
public class Version implements Comparable<Version> {

    /**
     * Выражение разбора
     */
    private static Pattern pattern = Pattern.compile("(\\d+)\\.?(\\d*)\\.?(\\d*)\\.?(.*)");

    
    private static Integer parseInt(String group) {
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
        Integer major = parseInt(matcher.group(1));
        Integer minor = parseInt(matcher.group(2));
        Integer build = parseInt(matcher.group(3));
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

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(major.intValue());
        if (minor != null) {
            buffer.append(".").append(minor.intValue());

            if (build != null) {
                buffer.append(".").append(build.intValue());

                if (revision != null) {
                    if (!revision.startsWith("-")) {
                        buffer.append(".");
                    }
                    buffer.append(revision);
                }
            }
        }


        return buffer.toString();
    }

    public int compareTo(Version o) {
        if (this.equals(o)) {
            return 0;
        } else {
            if (this.major > o.major
                    || (this.major == o.major && compareIntegerPossibleNull(this.minor, o.minor) > 0)
                    || (this.major == o.major && this.minor == o.minor && compareIntegerPossibleNull(this.build, o.build) > 0)
                    || (this.major == o.major && this.minor == o.minor && this.build == o.build
                    && compareStringPossibleNull(this.revision, o.revision) > 0)) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private int compareStringPossibleNull(String str1, String str2) {
        if (stringsNullOrEqual(str1, str2)) {
            return 0;
        } else {
            if (str1 == null && str2 != null) {
                return 1;
            } else if (str1 != null && str2 == null) {
                return -1;
            } else {
                return str1.compareToIgnoreCase(str2);
            }
        }
    }

    private int compareIntegerPossibleNull(Integer int1, Integer int2) {
        if (int1 == null && int2 == null) {
            return 0;
        } else {
            if (int1 == null && int2 != null) {
                return -1;
            } else if (int1 != null && int2 == null) {
                return 1;
            } else {
                return int1.compareTo(int2);
            }
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