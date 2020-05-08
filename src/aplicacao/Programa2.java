package aplicacao;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartamentoDao departamentoDao = DaoFactory.criarDepartamentoDao();
		
		System.out.println("=== Teste 1: departamento buscarPeloId ===");
		Departamento departamento = departamentoDao.buscarPeloId(2);	
		System.out.println(departamento);
		
		System.out.println("\n=== Teste 2: departamento buscarTudo ===");
		List<Departamento> listaDepartamento = departamentoDao.buscarTudo();
		listaDepartamento.forEach(System.out::println);
		
		System.out.println("\n=== Teste 3: departamento inserirDepartamento ===");
		Departamento novoDepartamento = new Departamento(null, "Musica");
		departamentoDao.inserir(novoDepartamento);
		System.out.println("Departamento inserido! Novo departamento: " + novoDepartamento.getId());
		
		System.out.println("\n=== Teste 4: departamento atualizar ===");
		departamento = departamentoDao.buscarPeloId(6);
		departamento.setNome("Teste");
		departamentoDao.atualizar(departamento);
		System.out.println("Departamento atualizado!");
		
		System.out.println("\n=== Teste 5: departamento excluir ===");
		System.out.print("Informar o Id do Departamento que será excluído: ");
		int id = sc.nextInt();
		departamentoDao.excluirPeloId(id);
		System.out.println("Departamento excluido!");
		

		sc.close();
	}

}
