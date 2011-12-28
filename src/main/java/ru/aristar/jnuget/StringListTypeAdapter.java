package ru.aristar.jnuget;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Unlocker
 */
public class StringListTypeAdapter extends XmlAdapter<String, List<String>> {

    private final String DELIMETER = ",";

    @Override
    public List<String> unmarshal(String v) throws Exception {
        return Arrays.asList(v.split("\\s*,\\s*"));
    }

    @Override
    public String marshal(List<String> v) throws Exception {
        Iterator<String> iter = v.iterator();
        if (!iter.hasNext()) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(String.valueOf(iter.next()));
        while (iter.hasNext()) {
            buffer.append(DELIMETER).append(String.valueOf(iter.next()));
        }
        return buffer.toString();
    }
}
