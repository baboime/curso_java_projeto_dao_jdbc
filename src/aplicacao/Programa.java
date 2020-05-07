package aplicacao;

import java.text.ParseException;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		VendedorDao vendedorDao = DaoFactory.criarVendedorDao();
		
		System.out.println("=== Teste 1: vendedor buscarPeloId ===");
		
		Vendedor vendedor = vendedorDao.buscarPeloId(3);
		
		System.out.println(vendedor);

	}

}
