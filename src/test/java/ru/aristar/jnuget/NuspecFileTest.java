package ru.aristar.jnuget;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sviridov
 */
public class NuspecFileTest {
    
    @Test
    public void testParseMethod() throws Exception {
        final String fileName = "/test.nuspec.xml";
        NuspecFile result = NuspecFile.Parse(NuspecFileTest.class.getResourceAsStream(fileName));
        assertEquals("Идентификатор пакета", "Neolant.ProjectWise.IsolationLevel.Implementation", result.getId());
        assertEquals("Версия пакета", Version.parse("1.4.7.550"), result.getVersion());
        assertEquals("Краткое описание", "Реализация уровня изоляции ProjecWise API", result.getTitle());
        assertEquals("Авторы", "НЕОЛАНТ", result.getAuthors());
        assertEquals("Владельцы", "НЕОЛАНТ", result.getOwners());
        assertEquals("Требуется подтверждение лицензии", false, result.isRequireLicenseAcceptance());
        assertEquals("Описание", "Реализация контрактов уровня изоляции ProjecWise API", result.getDescription());
        assertEquals("Права", "НЕОЛАНТ", result.getCopyright());
    }
    
    @Test
    public void testParseWithReferences() throws Exception {
        // GIVEN
        final String fileName = "/NUnit.nuspec.xml";
        Reference dll = new Reference().setFile("nunit.framework.dll");
        Reference xml = new Reference().setFile("nunit.framework.xml");
        Reference[] references = new Reference[]{dll, xml};
        String[] tags = new String[]{"Unit test"};

        // WHEN
        NuspecFile result = NuspecFile.Parse(NuspecFileTest.class.getResourceAsStream(fileName));

        // THEN
        assertEquals("Идентификатор пакета", "NUnit", result.getId());
        assertEquals("Версия пакета", Version.parse("2.5.9.10348"), result.getVersion());
        assertEquals("Авторы", "NUnit", result.getAuthors());
        assertEquals("Владельцы", "NUnit", result.getOwners());
        assertEquals("Требуется подтверждение лицензии", false, result.isRequireLicenseAcceptance());
        assertEquals("Описание", "Пакет модульного тестирования", result.getDescription());
        assertEquals("Права", "Copyright 2011", result.getCopyright());
        assertEquals("Количество меток", tags.length, result.getTags().size());
        assertEquals("Метки", tags, result.getTags().toArray());
        assertEquals("Количество ссылок", references.length, result.getReferences().size());
        assertEquals("Ссылки", references, result.getReferences().toArray());
    }
    
    @Test
    public void testParseWithDependencies() throws Exception {
        // GIVEN
        final String fileName = "/NHibernate.nuspec.xml";
        Dependency dep = new Dependency();
        dep.id = "Iesi.Collections";
        dep.version = Version.parse("3.2.0.4000");
        Dependency[] dependencies = new Dependency[]{dep};
        String[] tags = new String[]{"ORM", "DataBase", "DAL", "ObjectRelationalMapping"};

        // WHEN
        NuspecFile result = NuspecFile.Parse(NuspecFileTest.class.getResourceAsStream(fileName));

        // THEN
        assertEquals("Идентификатор пакета", "NHibernate", result.getId());
        assertEquals("Версия пакета", Version.parse("3.2.0.4000"), result.getVersion());
        assertEquals("Авторы", "NHibernate community, Hibernate community", result.getAuthors());
        assertEquals("Владельцы", "NHibernate community, Hibernate community", result.getOwners());
        assertEquals("Требуется подтверждение лицензии", false, result.isRequireLicenseAcceptance());
        assertEquals("Описание", 
                "NHibernate is a mature, open source object-relational mapper for the .NET framework. It's actively developed , fully featured and used in thousands of successful projects.", 
                result.getDescription());
        assertEquals("Краткое описание", 
                "NHibernate is a mature, open source object-relational mapper for the .NET framework. It's actively developed , fully featured and used in thousands of successful projects.", 
                result.getSummary());
        assertEquals("Количество меток", tags.length, result.getTags().size());
        assertEquals("Метки", tags, result.getTags().toArray());
        assertEquals("Количество зависимостей", dependencies.length, result.getDependencies().size());
        assertEquals("Зависимости", dependencies, result.getDependencies().toArray());
    }
}