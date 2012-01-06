package ru.aristar.jnuget;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unlocker
 */
@XmlRootElement(name="entry")
public class PackageEntry {
    
    @XmlElement(name="id")
    private String id;
}
