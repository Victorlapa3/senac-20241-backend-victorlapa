package controller.carros;

import java.util.List;

import exception.CarrosException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.carros.Montadora;
import service.carros.CarroService;
import service.carros.MontadoraService;

@Path("/montadora")
public class MontadoraController {

	private CarroService carroService = new CarroService();
	private MontadoraService montadoraService = new MontadoraService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Montadora salvar(Montadora novaMontadora) throws CarrosException {

		return montadoraService.salvar(novaMontadora);
	}

	@GET
	@Path("/todos")
	public List<Montadora> consultarTodas() {
		return montadoraService.consultarTodos();
	}
}