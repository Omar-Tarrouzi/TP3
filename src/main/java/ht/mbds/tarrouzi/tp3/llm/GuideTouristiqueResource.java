package ht.mbds.tarrouzi.tp3.llm;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {
    @Inject
    private GuideTouristiqueService guideTouristiqueService;
    @GET
    @Path("lieu/{ville_ou_pays}/{nb}")
    @Produces(MediaType.APPLICATION_JSON)

    public String endroitsDeVisiteAvecNombre(
            @PathParam("ville_ou_pays") String villeOuPays,
            @PathParam("nb") int nb) {

        return guideTouristiqueService.conseiller(villeOuPays, nb);

}}
