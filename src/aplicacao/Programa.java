package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Departamento obj = new Departamento(1, "Teste");
		
		Vendedor vendedor = new Vendedor(1, "Edney", "edney.baboim.gmail.com", sdf.parse("16/07/1981"), 9000.0, obj);
		
		VendedorDao vendedorDao = DaoFactory.criarVendedorDao();
		
		System.out.println(obj);
		System.out.println(vendedor);

	}

}
