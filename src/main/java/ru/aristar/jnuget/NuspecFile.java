package ru.aristar.jnuget;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sviridov
 */
@XmlRootElement(name = "package", namespace = NuspecFile.NUSPEC_XML_NAMESPACE)
public class NuspecFile {

    public static final String NUSPEC_XML_NAMESPACE = "http://schemas.microsoft.com/packaging/2011/08/nuspec.xsd";

    public static class Metadata {

        @XmlElement(name = "id", namespace = NUSPEC_XML_NAMESPACE)
        private String id;
        @XmlElement(name = "version", namespace = NUSPEC_XML_NAMESPACE)
        @XmlJavaTypeAdapter(value = VersiontypeAdapter.class)
        private Version version;
        @XmlElement(name = "title", namespace = NUSPEC_XML_NAMESPACE)
        private String title;
        @XmlElement(name = "authors", namespace = NUSPEC_XML_NAMESPACE)
        private String authors;
    }
    @XmlElement(name = "metadata", namespace = NUSPEC_XML_NAMESPACE)
    private Metadata metadata;

    public static NuspecFile Parse(byte[] data) throws JAXBException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        return Parse(inputStream);
    }

    public static NuspecFile Parse(InputStream inputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(NuspecFile.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        NuspecFile result = (NuspecFile) unmarshaller.unmarshal(inputStream);
        return result;
    }

    public String getId() {
        return metadata.id;
    }

    public Version getVersion() {
        return metadata.version;
    }

    public String getTitle() {
        return metadata.title;
    }

    public String getAuthors() {
        return metadata.authors;
    }
}
