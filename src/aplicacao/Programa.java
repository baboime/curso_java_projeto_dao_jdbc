package aplicacao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {
	
	public static void main(String[] args) throws ParseException {
	
		Scanner sc = new Scanner(System.in);
		
		VendedorDao vendedorDao = DaoFactory.criarVendedorDao();
		
		System.out.println("=== Teste 1: vendedor buscarPeloId ===");
		Vendedor vendedor = vendedorDao.buscarPeloId(3);		
		System.out.println(vendedor);
		
		System.out.println("\n=== Teste 2: vendedor buscarPeloDepartamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> listaVendedor = vendedorDao.buscarPeloDepartamento(departamento);
		listaVendedor.forEach(System.out::println);
		
		System.out.println("\n=== Teste 3: vendedor buscarTudo ===");
		listaVendedor = vendedorDao.buscarTudo();
		listaVendedor.forEach(System.out::println);
		
		System.out.println("\n=== Teste 4: vendedor inserir ===");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.inserir(novoVendedor);
		System.out.println("Vendedor inserido! Novo id = " + novoVendedor.getId());
		
		System.out.println("\n=== Teste 5: vendedor atualizar ===");
		vendedor = vendedorDao.buscarPeloId(1);
		vendedor.setNome("Martha Waine");
		vendedorDao.atualizar(vendedor);
		System.out.println("Atualização executada com sucesso!");
		
		System.out.println("\n=== Teste 6: vendedor excluir ===");
		System.out.print("Informe um ID para excusão: ");
		int id = sc.nextInt();
		vendedorDao.excluirPeloId(id);
		System.out.println("Exclusão realizada com sucesso!");
		
		sc.close();

	}
}
