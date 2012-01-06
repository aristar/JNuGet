package ru.aristar.jnuget;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unlocker
 */
@XmlRootElement(name="link")
public class Link {
    @XmlAttribute(name="rel")
    private final String rel;
    @XmlAttribute(name="title")
    private final String title;    
    @XmlAttribute(name="href")
    private final String href;

    public Link(String rel, String title, String href) {
        this.rel = rel;
        this.title = title;
        this.href = href;
    }
}
