package model.repository.montadora;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.carros.Montadora;
import model.entity.vacinacao.Pessoa;
import model.repository.Banco;
import model.repository.BaseRepository;

public class MontadoraRepository implements BaseRepository<Montadora> {
	public Montadora salvar(Montadora novaMontadora) {
		String sql = " INSERT INTO montadora (nome, paisFundacao, nomePresidente, dataFundacao) "
				+ " VALUES(?, ?, ?, ?) ";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);

		try {
			stmt.setString(1, novaMontadora.getNome());
			stmt.setString(2, novaMontadora.getPaisFundacao());
			stmt.setString(3, novaMontadora.getNomePresidente());
			stmt.setDate(4, Date.valueOf(novaMontadora.getDataFundacao()));

			stmt.execute();
			ResultSet resultado = stmt.getGeneratedKeys();
			if (resultado.next()) {
				novaMontadora.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar nova montadora");
			System.out.println("Erro: " + e.getMessage());
		}

		return novaMontadora;
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
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = " SELECT * FROM montadora WHERE id=" + id + " ";
		ResultSet rs = null;
		Montadora m = null;

		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				m = preencherRs(rs);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar montadora por id");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(rs);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return m;
	}

	@Override
	public ArrayList<Montadora> consultarTodos() {
		Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        String query = " SELECT * FROM imovel ";
        ResultSet rs = null;
        ArrayList<Montadora> montadoras = new ArrayList<>();

        try{
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Montadora m = preencherRs(rs);
                montadoras.add(m);
            }
        } catch (SQLException e){
            System.out.println("Erro ao consultar todos as montadoras");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(rs);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return montadoras;
	}

	public Montadora preencherRs(ResultSet rs) throws SQLException {
		Montadora m = new Montadora();

		m.setId(rs.getInt("id"));
		m.setNome(rs.getString("nome"));
		m.setPaisFundacao(rs.getString("paisFundacao"));
		m.setNomePresidente(rs.getString("nomePresidente"));
		m.setDataFundacao(rs.getDate("dataFundacao").toLocalDate());

		return m;
	}

}
