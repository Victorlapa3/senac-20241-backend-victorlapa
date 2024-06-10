package service.vemnox1;

import java.util.ArrayList;
import java.util.List;


import exception.VemNoX1Exception;
import model.entity.vemnox1.Jogador;
import model.entity.vemnox1.Partida;
import model.repository.vemnox1.JogadorRepository;
import model.repository.vemnox1.PartidaRepository;


public class JogadorService {

	private JogadorRepository repository = new JogadorRepository();
	private PartidaRepository repoPartida = new PartidaRepository();

	public Jogador salvar(Jogador novaJogador) {
		return repository.salvar(novaJogador);
	}

	public boolean atualizar(Jogador jogadorEditado) {
		return repository.alterar(jogadorEditado);
	}

	public boolean excluir(int id) throws VemNoX1Exception   {
		if(repoPartida.consultarPorPessoa(id).isEmpty()) {
			return repository.excluir(id);
		} else {
			throw new VemNoX1Exception("O jogador de id " + id + " não pode ser excluído pois possui " + repoPartida.consultarPorPessoa(id).size()
					+ " jogadores cadastrados.");
		}
	}

	public Jogador consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

	public List<Jogador> consultarTodas() {
		return repository.consultarTodos();
	}
}
