package model.dao;

import java.util.List;

import model.entidades.Departamento;

public interface DepartamentoDao {
	
	void inserir(Departamento obj);
	void atualizar(Departamento obj);
	void excluirPeloId(Departamento obj);
	Departamento buscarPeloId(Integer id);
	List<Departamento> buscarTudo();

}
