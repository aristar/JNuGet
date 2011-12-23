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
@XmlRootElement(name = "package", namespace = "http://schemas.microsoft.com/packaging/2011/08/nuspec.xsd")
public class NuspecFile {

    public static class Metadata {

        @XmlElement(name = "id", namespace = "http://schemas.microsoft.com/packaging/2011/08/nuspec.xsd")
        private String id;
        @XmlElement(name = "version", namespace = "http://schemas.microsoft.com/packaging/2011/08/nuspec.xsd")
        @XmlJavaTypeAdapter(value = VersiontypeAdapter.class)
        private Version version;
    }
    @XmlElement(name = "metadata", namespace = "http://schemas.microsoft.com/packaging/2011/08/nuspec.xsd")
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
}
