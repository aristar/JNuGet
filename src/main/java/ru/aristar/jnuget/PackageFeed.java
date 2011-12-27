package ru.aristar.jnuget;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unlocker
 */
@XmlRootElement(name="feed", namespace="http://www.w3.org/2005/Atom")
class PackageFeed {
    
    @XmlElement(name="title")
    private String title = "Packages";
    
    @XmlElement(name="id")
    private String id;
    
    @XmlElement(name="updated", type=Date.class)
    private Date updated;
    
    private List<PackageEntry> entries;
}
