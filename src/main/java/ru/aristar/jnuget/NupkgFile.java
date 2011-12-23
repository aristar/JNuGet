package ru.aristar.jnuget;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.bind.JAXBException;

/**
 *
 * @author sviridov
 */
public class NupkgFile {

    private NuspecFile nuspecFile;

    public NupkgFile(InputStream inputStream) throws IOException, JAXBException {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ZipEntry entry;
        loop:
        while ((entry = zipInputStream.getNextEntry()) != null) {
            if (!entry.isDirectory() && entry.getName().endsWith(".nuspec")) {
                byte[] buffer = new byte[(int) entry.getSize()];
                zipInputStream.read(buffer, 0, buffer.length);
                nuspecFile = NuspecFile.Parse(buffer);
                break loop;
            }
        }
    }

    public NuspecFile getNuspecFile() {
        return nuspecFile;
    }

    public void setNuspecFile(NuspecFile nuspecFile) {
        this.nuspecFile = nuspecFile;
    }
}
