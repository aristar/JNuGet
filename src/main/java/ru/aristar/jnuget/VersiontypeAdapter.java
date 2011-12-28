package ru.aristar.jnuget;

import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 *
 * @author sviridov
 */
public class VersionTypeAdapter extends XmlAdapter<String, Version> {

    @Override
    public String marshal(Version version) throws Exception {
        if (version == null) {
            return null;
        } else {
            return version.toString();
        }
    }

    @Override
    public Version unmarshal(String string) throws Exception {
        if (string == null) {
            return null;
        } else {
            return Version.parse(string);
        }
    }
}
