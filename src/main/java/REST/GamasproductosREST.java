package REST;

import java.util.List;

import DAO.Gamasproductos;
import DAO.GamasproductosDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("gamasproductos")
public class GamasproductosREST {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gamasproductos> getAll(@QueryParam("gama") String gama) {
		GamasproductosDAO gamasproductosdao = new GamasproductosDAO();
		List<Gamasproductos> lista;
		if (gama != null) {
			lista = gamasproductosdao.getAll(gama);
		} else {
			lista = gamasproductosdao.getAll();
		}
		return lista;
	}

	@GET
	@Path("/{gama}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("gama") String gama) {
		Response r;
		GamasproductosDAO gamasproductosdao = new GamasproductosDAO();
		Gamasproductos gamas = gamasproductosdao.get(gama);
		if (gamas == null) {
			r = Response.status(Response.Status.NOT_FOUND).entity("El producto con gama " + gama + " no existe ")
					.build();
		} else {
			r = Response.status(Response.Status.OK).entity(gamas).build();
		}
		return r;
	}

	@PUT
	@Path("/{gama}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualiza(@PathParam("gama") String gama, Gamasproductos gamasproductos) {
		Response r;
		GamasproductosDAO gamasproductosdao = new GamasproductosDAO();
		Gamasproductos gamas = gamasproductosdao.get(gama);
		if (gamas == null) {
			r = Response.status(Response.Status.NOT_FOUND).entity("El producto con gama " + gama + " no existe ")
					.build();
		} else if (gamasproductos.getGama() == null) {
			r = Response.status(Response.Status.BAD_REQUEST).entity("Faltan datos obligatorios").build();
		} else {
			gamas.setGama(gamasproductos.getGama());
			gamas.setDescripcionTexto(gamasproductos.getDescripcionTexto());
			gamas.setDescripcionHtml(gamasproductos.getDescripcionHtml());
			gamas.setImagen(gamasproductos.getImagen());
			gamas = gamasproductosdao.update(gamas);
			r = Response.status(Response.Status.OK).entity(gamas).build();
		}
		return r;
	}

	@DELETE
	@Path("/{gama}")
	public Response borrado(@PathParam("gama") String gama) {
		System.out.println("Gama " + gama);
		Response r;
		GamasproductosDAO gamasproductosdao = new GamasproductosDAO();
		Gamasproductos gamas = gamasproductosdao.get(gama);
		if (gamas == null) {
			r = Response.status(Response.Status.NOT_FOUND).entity("El producto con gama " + gama + " no existe ")
					.build();
		} else {
			gamasproductosdao.delete(gama);
			r = Response.status(Response.Status.OK).build();
		}
		return r;
	}
}
