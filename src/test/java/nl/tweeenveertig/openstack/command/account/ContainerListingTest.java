package nl.tweeenveertig.openstack.command.account;

import nl.tweeenveertig.openstack.command.ObjectStoreListElement;
import nl.tweeenveertig.openstack.util.ClasspathTemplateResource;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class ContainerListingTest {

    @Test
    public void testUnmarshallingSingleElement() throws IOException {
        String jsonString = new ClasspathTemplateResource("/sample-container-listing.json").loadTemplate();
        ObjectMapper mapper = new ObjectMapper();
        ObjectStoreListElement listing = mapper.readValue(jsonString, ObjectStoreListElement.class);
        assertEquals("Amersfoort", listing.name);
        assertEquals(48, listing.count);
        assertEquals(1028296, listing.bytes);
    }

    @Test
    public void testUnmarshallingList() throws IOException {
        String jsonString = new ClasspathTemplateResource("/sample-container-list.json").loadTemplate();
        ObjectMapper mapper = new ObjectMapper();
        ObjectStoreListElement[] list = mapper.readValue(jsonString, ObjectStoreListElement[].class);
        assertEquals(4, list.length);
    }

}
