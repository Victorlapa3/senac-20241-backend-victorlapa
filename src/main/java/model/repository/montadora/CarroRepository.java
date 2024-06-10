package model.repository.montadora;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.entity.carros.Carro;
import model.entity.carros.Montadora;
import model.repository.Banco;
import model.repository.BaseRepository;
import model.seletor.carros.CarroSeletor;

public class CarroRepository implements BaseRepository<Montadora> {

	@Override
	public Montadora salvar(Montadora novaEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Montadora entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Montadora consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Montadora> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Carro> consultarComSeletor(CarroSeletor seletor) {
		ArrayList<Carro> carros = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet rs = null;

		String query = " SELECT c.* FROM carro c ";

		if (seletor.temFiltro()) {
			query = preencherFiltros(seletor, query);
		}

		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Carro c = preencherRs(rs);
				carros.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar carros com seletor");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return carros;
	}

	public Carro preencherRs(ResultSet rs) throws SQLException {
		Carro c = new Carro();

		c = new Carro();
		c.setId(rs.getInt("id"));
		c.setModelo(rs.getString("modelo"));
		c.setPlaca(rs.getString("placa"));
		c.setAno(rs.getInt("ano"));
		c.setValor(rs.getDouble("valor"));

		return c;
	}

	public void preencherPstmt(Carro carro, PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, carro.getModelo());
		pstmt.setString(2, carro.getPlaca());
		pstmt.setInt(3, carro.getMontadora().getId());
		pstmt.setInt(5, carro.getAno());
		pstmt.setDouble(4, carro.getValor());
	}

	public String preencherFiltros(CarroSeletor seletor, String query) {
	    query += " WHERE ";
	    boolean primeiro = true;

	    if (seletor.getModelo() != null && !seletor.getModelo().trim().isEmpty()) {
	        if (!primeiro) {
	            query += " AND ";
	        }
	        query += " UPPER(c.modelo) LIKE UPPER('%" + seletor.getModelo() + "%') ";
	        primeiro = false;
	    }

	    if (seletor.getNomeMarca() != null && !seletor.getNomeMarca().trim().isEmpty()) {
	        if (!primeiro) {
	            query += " AND ";
	        }
	        query += " UPPER(m.nome) LIKE UPPER('%" + seletor.getNomeMarca() + "%') ";
	        primeiro = false;
	    }

	    if (seletor.getAnoInicial() != null && seletor.getAnoFinal() != null) {
	        if (!primeiro) {
	            query += " AND ";
	        }
	        query += " c.ano BETWEEN " + seletor.getAnoInicial() + " AND " + seletor.getAnoFinal();
	        primeiro = false;
	    }

	    if (seletor.getValorInicial() != null && seletor.getValorFinal() != null) {
	        if (!primeiro) {
	            query += " AND ";
	        }
	        query += " c.valor BETWEEN " + seletor.getValorInicial() + " AND " + seletor.getValorFinal();
	        primeiro = false;
	    }

	    return query;
	}

//	private Integer id;
//	private String modelo;
//	private String placa;
//	private Montadora montadora;
//	private Integer ano;
//	private Double valor;

}
