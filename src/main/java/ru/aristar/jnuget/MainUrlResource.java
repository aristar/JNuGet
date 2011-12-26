package ru.aristar.jnuget;

import java.io.StringWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Web Service
 *
 * @author sviridov
 */
@Path("")
public class MainUrlResource {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Класс с XML данными о корневом узле сайта NuGet
     */
    private static MainUrl mainUrl = new MainUrl();
    @Context
    private UriInfo context;

    /** Creates a new instance of MainUrlResource */
    public MainUrlResource() {
    }

    /**
     * Retrieves representation of an instance of ru.aristar.jnuget.MainUrlResource
     * @return 
     */
    @GET
    @Produces("application/xml")
    public Response getXml() {
        StringWriter writer = new StringWriter();
        try {
            mainUrl.writeXml(writer);
        } catch (JAXBException e) {
            final String errorMessage = "Ошибка преобразованифя XML";
            logger.error(errorMessage, e);
            return Response.serverError().entity(errorMessage).build();
        }
        return Response.ok(writer.toString(), MediaType.APPLICATION_XML).build();
    }

    /**
     * PUT method for updating or creating an instance of MainUrlResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
