package ru.aristar.jnuget;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Unlocker
 */
public class StringListTypeAdapterTest {
    
    @Test
    public void testMarshalUnmarshalWhenEmptyInput() throws Exception {
        // GIVEN
        StringListTypeAdapter adapter = new StringListTypeAdapter();
        final String emptyInput = "";
        
        // WHEN
        List<String> list = adapter.unmarshal(emptyInput);
        String listStr = adapter.marshal(list);
        
        // THEN
        Assert.assertEquals("Количество должно быть равно 0", 0, list.size());
        Assert.assertEquals("Строка должна быть пустой", emptyInput, listStr);
    }
    
    @Test
    public void testMarshalUnmarshalWhenSingleInput() throws Exception {
        // GIVEN
        StringListTypeAdapter adapter = new StringListTypeAdapter();
        final String singleInput = "tag1";
        
        // WHEN
        List<String> list = adapter.unmarshal(singleInput);
        String listStr = adapter.marshal(list);
        
        // THEN
        Assert.assertEquals("Количество должно быть равно 1", 1, list.size());
        Assert.assertEquals("Строка должна быть '"+singleInput+"'", 
                singleInput, listStr);
    }
    
    @Test
    public void testMarshalUnmarshalWhenSingleWhitespacedInput() throws Exception {
        // GIVEN
        StringListTypeAdapter adapter = new StringListTypeAdapter();
        final String singleInput = "tag1 suffix";
        
        // WHEN
        List<String> list = adapter.unmarshal(singleInput);
        String listStr = adapter.marshal(list);
        
        // THEN
        Assert.assertEquals("Количество должно быть равно 1", 1, list.size());
        Assert.assertEquals("Строка должна быть '"+singleInput+"'", 
                singleInput, listStr);
    }
    
    @Test
    public void testMarshalUnmarshalWhenMultipleInput() throws Exception {
        // GIVEN
        StringListTypeAdapter adapter = new StringListTypeAdapter();
        final String multipleInput = "tag1 suffix1, tag2 , tag3 suffix3 ";
        final String result = "tag1 suffix1,tag2,tag3 suffix3";
        
        // WHEN
        List<String> list = adapter.unmarshal(multipleInput);
        String listStr = adapter.marshal(list);
        
        // THEN
        Assert.assertEquals("Количество должно быть равно 3", 3, list.size());
        Assert.assertEquals("Строка должна быть '"+result+"'", result, listStr);
    }
    
}
