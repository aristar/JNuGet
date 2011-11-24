package ru.aristar.jnuget;

import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * <?xml version="1.0" encoding="windows-1251" standalone="yes"?>
<service xml:base="Полный URL, куда должен быть задеполен сервлет" xmlns:atom="http://www.w3.org/2005/Atom" xmlns:app="http://www.w3.org/2007/app" xmlns="http://www.w3.org/2007/app">
<workspace>
<atom:title>Default</atom:title>
<collection href="Packages">
<atom:title>Packages</atom:title>
</collection>
</workspace>
</service>
 */
/**
 *
 * @author sviridov
 */
@XmlRootElement(name = "service", namespace = "http://www.w3.org/2007/app")
@XmlAccessorType(XmlAccessType.NONE)
public class MainUrl {

    public static class Workspace {

        @XmlElement(name = "title", namespace = "http://www.w3.org/2005/Atom")
        private String title = "Default";
    }
    
    private UrlFactory urlFactory;
    
    @XmlElement(name = "workspace", namespace = "http://www.w3.org/2007/app")
    private Workspace workspace = new Workspace();

    @XmlAttribute(name = "xml:base", namespace = "")
    private String getBaseUrl() {
        return "Полный URL, куда должен быть задеполен сервлет";
    }

    public void writeXml(Writer writer) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(this.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(this, writer);
    }
}
