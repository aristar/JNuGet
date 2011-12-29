package ru.aristar.jnuget;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Описание зависимости
 * @author Unlocker
 */
@XmlRootElement(name="dependency", namespace=NuspecFile.NUSPEC_XML_NAMESPACE)
class Dependency {

    /**
     * Идентификатор пакета
     */
    @XmlAttribute(name = "id")
    public String id;
    
    /**
     * Версия пакета
     */
    @XmlAttribute(name = "version")
    @XmlJavaTypeAdapter(value = VersionTypeAdapter.class)
    public Version version;
}
