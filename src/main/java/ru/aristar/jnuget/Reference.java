package ru.aristar.jnuget;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Ссылка на файл.
 * @author Unlocker
 */
class Reference {
    
    public Reference(){}

    /**
     * Название файла ссылки.
     */
    @XmlAttribute(name = "file")
    private String file;
    
//    /**
//     * Возвращает имя файла ссылки.
//     * @return Имя файла ссылки.
//     */
//    public String getFile(){
//        return this.file;
//    }
    
    /**
     * Устанавлтвает имя файла ссылки.
     * @param file Новое имя файла.
     * @return Ссылка.
     */
    public Reference setFile(String file){
        this.file = file;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Reference)) {
            return false;
        } else {
            Reference o = (Reference) obj;
            return this.file.equals(o.file);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.file);
        return hash;
    }
}
