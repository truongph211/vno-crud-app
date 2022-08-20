package com.example.phuong.vno.restful;

import com.example.phuong.vno.response.VnoResponse;
import com.example.phuong.vno.service.VnoService;
import com.example.phuong.vno.vo.VnoVO;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Produces(MediaType.APPLICATION_JSON)
@Path("vnos")
public class VnoServiceRest {

    private VnoService vnoService;

    public VnoServiceRest(VnoService vnoService) {
        this.vnoService = vnoService;
    }

    @Context
    UriInfo uri;

    // curl GET http://localhost:8181/cxf/api/vnos
    @GET
    @Path("/")
    public Collection<VnoVO> getVnos() {
        // Luc nay trong service  tra ra VO,
        // nen ngoai day minh chi thay dc VO va tra ra cho user thoi
        return vnoService.getVnos();
    }
    // curl GET http://localhost:8181/cxf/api/vnos/<id>


    @GET
    @Path("/{id}")
    public Response getVno(@PathParam("id") Integer id) {
        VnoVO vnoEntity = vnoService.getVno(id);
        return vnoEntity == null
                ? Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build()
                : Response.ok(vnoEntity).build();
    }

    // curl POST http://localhost:8181/cxf/api/vnos BODY
    @POST
    @Path("/") // pathparam always is Noun
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVno(VnoVO vnoVO) {
        System.out.println("Adding vno " + vnoVO.toString());
        try {
            vnoService.addVno(vnoVO);
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new VnoResponse(false, e.getMessage())).build();
        }
        return Response.ok().entity(new VnoResponse(true, "Added vno successfully")).build();
    }


    // curl PUT http://localhost:8181/cxf/api/vnos
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateVno(@PathParam("id") Integer id, VnoVO vnoEntity) {
        vnoEntity.setId(id);
        try {
            vnoService.updateVno(vnoEntity);
        } catch (Exception e) {
            // ok, nay neu ko co vno, trong service se throw exception
            // minh se catch exception do lai, roi xu ly cho nay
            // Minh se build lai response: Error code 400 va message (trong service tra ra)

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    // curl DELETE http://localhost:8181/cxf/api/vnos/<id>
    @DELETE
    @Path("/{id}")
    public Response deleteVno(@PathParam("id") Integer id) {
        // tuong tu cho delete
        try {
            vnoService.deleteVno(id);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }
}
