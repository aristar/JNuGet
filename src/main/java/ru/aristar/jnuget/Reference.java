package ru.aristar.jnuget;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unlocker
 */
@XmlRootElement(name="reference", namespace = NuspecFile.NUSPEC_XML_NAMESPACE)
class Reference {
    @XmlAttribute(name="file")
    public String file;
}
