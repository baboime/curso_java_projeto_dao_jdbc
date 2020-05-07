package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{
	
	private Connection conexao;
	
	public VendedorDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirPeloId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor buscarPeloId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conexao.prepareStatement(
					"SELECT vendedor.*,departamento.Nome as NomeDoDepartamento "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.IdDepartamento = departamento.Id "
					+ "WHERE vendedor.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Departamento dep = instanciandoDepartamento(rs);
				Vendedor obj = instanciarVendedor(rs, dep);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private Vendedor instanciarVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("Id"));
		obj.setNome(rs.getString("Nome"));
		obj.setEmail(rs.getString("Email"));
		obj.setDataDeNascimento(rs.getDate("DataDeNascimento"));
		obj.setSalarioBase(rs.getDouble("SalarioBase"));
		obj.setDepartamento(dep);
		return obj;
	}

	private Departamento instanciandoDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("IdDepartamento"));
		dep.setNome(rs.getString("NomeDoDepartamento"));
		return dep;
	}

	@Override
	public List<Vendedor> buscarTudo() {
		// TODO Auto-generated method stub
		return null;
	}
}
