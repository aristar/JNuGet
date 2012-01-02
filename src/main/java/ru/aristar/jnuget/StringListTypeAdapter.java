package ru.aristar.jnuget;

import java.util.ArrayList;
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
        String[] temp = v.split("\\s*" + DELIMETER + "\\s*");
        List<String> result = new ArrayList<>();

        for (String str : temp) {
            String tag = str.trim();
            if (!tag.isEmpty()) {
                result.add(tag);
            }
        }

        return result;
    }

    @Override
    public String marshal(List<String> v) throws Exception {
        Iterator<String> iter = v.iterator();
        if (!iter.hasNext()) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(iter.next());
        while (iter.hasNext()) {
            buffer.append(DELIMETER).append(iter.next());
        }
        return buffer.toString();
    }
}
