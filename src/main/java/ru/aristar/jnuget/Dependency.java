package ru.aristar.jnuget;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Описание зависимости
 * @author Unlocker
 */
public class Dependency {

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
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Dependency)) {
            return false;
        } else {
            Dependency o = (Dependency) obj;
            return this.id.equals(o.id)
                    && this.version.equals(o.version);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.version);
        return hash;
    }
}
