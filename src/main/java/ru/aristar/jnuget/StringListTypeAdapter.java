package ru.aristar.jnuget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Unlocker
 */
public class StringListTypeAdapter extends XmlAdapter<String, List<String>> {

    private final String DELIMETER = ",";
    private static Pattern emptyString = Pattern.compile("^\\s*$");

    @Override
    public List<String> unmarshal(String v) throws Exception {
        List<String> result = new ArrayList<>
                (Arrays.asList(v.split("\\s*" + DELIMETER + "\\s*")));
        if (result.size() == 1) {
            String raw = result.get(0);
            if (raw.isEmpty() || emptyString.matcher(raw).find()) {
                result.remove(0);
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
