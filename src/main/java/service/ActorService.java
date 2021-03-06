package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.ActorFacade;
import model.Actor;
import model.Film;

@Path("/actors")
public class ActorService {
	
	@EJB 
	ActorFacade actorFacadeEJB;
	
	Logger logger = Logger.getLogger(ActorService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Actor> findAll(){
		return actorFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Actor find(@PathParam("id") Integer id) {
        return actorFacadeEJB.find(id);
    }
	
	
	///
		//
		//
		//
		//
		//obtiene films con id indicado
			@GET
		    @Path("{id}/films")
		    @Produces({"application/xml", "application/json"})
		    public List<Film> find_actors(@PathParam("id") Integer id) {
		        return actorFacadeEJB.find(id).obtenerFilm();
		    }
			
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(Actor entity) {
        actorFacadeEJB.create(entity);
    }

   

}
