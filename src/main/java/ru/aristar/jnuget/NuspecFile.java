package ru.aristar.jnuget;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Класс, содержащий информацию о пакете NuGet
 * @author sviridov
 */
@XmlRootElement(name = "package", namespace = NuspecFile.NUSPEC_XML_NAMESPACE)
public class NuspecFile {

    /**
     * Класс содержащий метаанные пакета NuGet
     */
    public static class Metadata {

        //TODO Добавить поля
        /**
         * Уникальный идентификатор пакета
         */
        @XmlElement(name = "id", namespace = NUSPEC_XML_NAMESPACE)
        private String id;
        /**
         * Версия пакета
         */
        @XmlElement(name = "version", namespace = NUSPEC_XML_NAMESPACE)
        @XmlJavaTypeAdapter(value = VersionTypeAdapter.class)
        private Version version;
        /**
         * Короткое описание пакета
         */
        @XmlElement(name = "title", namespace = NUSPEC_XML_NAMESPACE)
        private String title;
        /**
         * Список авторов пакета
         */
        @XmlElement(name = "authors", namespace = NUSPEC_XML_NAMESPACE)
        private String authors;
        /**
         * Список владельцев пакета
         */
        @XmlElement(name = "owners", namespace = NUSPEC_XML_NAMESPACE)
        private String owners;
        /**
         * Требуется ли запрос лицензии
         */
        @XmlElement(name = "requireLicenseAcceptance", namespace = NUSPEC_XML_NAMESPACE)
        private Boolean requireLicenseAcceptance;
        /**
         * Описание пакета
         */
        @XmlElement(name = "description", namespace = NUSPEC_XML_NAMESPACE)
        private String description;
        /**
         * Кому пренадлежат права на пакет
         */
        @XmlElement(name = "copyright", namespace = NUSPEC_XML_NAMESPACE)
        private String copyright;
        /**
         * Список меток, разделенных запятыми
         */
        @XmlElement(name = "tags", namespace = NUSPEC_XML_NAMESPACE)
        @XmlJavaTypeAdapter(value = StringListTypeAdapter.class)
        private List<String> tags;
        
//        @XmlElement(name = "tags", namespace = NUSPEC_XML_NAMESPACE)
//        private List<Reference> references;
    }
    /**
     * Метаданные пакета
     */
    @XmlElement(name = "metadata", namespace = NUSPEC_XML_NAMESPACE)
    private Metadata metadata;

    /**
     * @return Уникальный идентификатор пакета
     */
    public String getId() {
        return metadata.id;
    }

    /**
     * @return Версия пакета
     */
    public Version getVersion() {
        return metadata.version;
    }

    /**
     * @return Короткое описание пакета
     */
    public String getTitle() {
        return metadata.title;
    }

    /**
     * @return Список авторов пакета
     */
    public String getAuthors() {
        return metadata.authors;
    }

    /**
     * @return Список владельцев пакета
     */
    public String getOwners() {
        return metadata.owners;
    }

    /**
     * @return Требуется ли запрос лицензии
     */
    public boolean isRequireLicenseAcceptance() {
        if (metadata.requireLicenseAcceptance == null) {
            return false;
        } else {
            return metadata.requireLicenseAcceptance;
        }
    }

    /**
     * @return Описание пакета
     */
    public String getDescription() {
        return metadata.description;
    }

    /**
     * @return Кому пренадлежат права на пакет
     */
    public String getCopyright() {
        return metadata.copyright;
    }

    //TODO Добавить проверку схемы
    /**
     * Восстанавливает информацию о пакете из XML
     * @param data XML
     * @return распознанная информация о пакете
     * @throws JAXBException ошибка преобразования XML
     */
    public static NuspecFile Parse(byte[] data) throws JAXBException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        return Parse(inputStream);
    }

    //TODO Добавить проверку схемы
    /**
     * Восстанавливает информацию о пакете из XML
     * @param inputStream XML
     * @return распознанная информация о пакете
     * @throws JAXBException ошибка преобразования XML
     */
    public static NuspecFile Parse(InputStream inputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(NuspecFile.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        NuspecFile result = (NuspecFile) unmarshaller.unmarshal(inputStream);
        return result;
    }
    /**
     * Пространство имен для спецификации пакета NuGet
     */
    public static final String NUSPEC_XML_NAMESPACE = "http://schemas.microsoft.com/packaging/2011/08/nuspec.xsd";
}
