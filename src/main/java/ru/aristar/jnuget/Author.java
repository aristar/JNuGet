/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.aristar.jnuget;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unlocker
 */
@XmlRootElement(name="author")
public class Author {
    
    @XmlElement(name="name")
    private String name;

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
