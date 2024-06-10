package service.carros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import exception.CarrosException;
import exception.VacinacaoException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.carros.Carro;
import model.entity.carros.Montadora;
import model.entity.vacinacao.Pessoa;
import model.repository.montadora.MontadoraRepository;
import model.repository.vacinacao.PessoaRepository;
import model.seletor.carros.CarroSeletor;

public class MontadoraService {

//	public ArrayList<Montadora> consultarTodas() {
//		return this.gerarMockMontadoras();
//	}
	
//	public ArrayList<Montadora> gerarMockMontadoras() {
//		ArrayList<Montadora> montadoras = new ArrayList<>();
//		montadoras.add(new Montadora(1, "Toyota", "Japão", "João Almeida", LocalDate.of(2004, 1, 1)));
//		montadoras.add(new Montadora(2, "Ford", "Estados Unidos", "Roberto Carlos", LocalDate.of(1903, 6, 16)));
//        montadoras.add(new Montadora(3, "Volkswagen", "Alemanha", "Martin Winterkorn", LocalDate.of(1937, 5, 28)));
//        montadoras.add(new Montadora(4, "GM", "Estados Unidos", "Mary Barra", LocalDate.of(1908, 9, 16)));
//        montadoras.add(new Montadora(5, "Honda", "Japão", "Takahiro Hachigo", LocalDate.of(1948, 9, 24)));
//        montadoras.add(new Montadora(6, "Nissan", "Japão", "Makoto Uchida", LocalDate.of(1933, 12, 26)));
//
//		return montadoras;
//	}
	
	private MontadoraRepository repository = new MontadoraRepository();
	public Montadora salvar(Montadora novaMontadora) throws CarrosException {
		
		return repository.salvar(novaMontadora);
	}
	  public List<Montadora> consultarTodos() {
	        List<Montadora> montadoras = repository.consultarTodos();
	        
	        return montadoras;
	    }
//	private ArrayList<Carro> filtrarPorAno(ArrayList<Carro> carros, CarroSeletor seletor) {
//		Predicate<Carro> intervalo;
//		if(seletor.getAnoInicial() != null && seletor.getAnoFinal() != null) {
//			intervalo = carro -> carro.getAno() >= seletor.getAnoInicial() && carro.getAno() <= seletor.getAnoFinal();
//		} else if(seletor.getAnoInicial() != null) {
//			intervalo = carro -> carro.getAno() >= seletor.getAnoInicial();
//		} else {
//			intervalo = carro ->  carro.getAno() <= seletor.getAnoFinal(); 
//		}
//	}
	
}
