package net.itinajero.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService{
	private List<Categoria> lista=null;
	
	public CategoriasServiceImpl() {
		lista=new LinkedList<Categoria>();
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("Ventas");
		c1.setDescripcion("");

		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Contabilidad");
		c2.setDescripcion("");

		Categoria c3 = new Categoria();
		c3.setId(3);
		c3.setNombre("Transporte");
		c3.setDescripcion("");

		Categoria c4 = new Categoria();
		c4.setId(4);
		c4.setNombre("Informatica");
		c4.setDescripcion("");

		Categoria c5 = new Categoria();
		c5.setId(5);
		c5.setNombre("Construccion");
		c5.setDescripcion("");
		
		Categoria c6 = new Categoria();
		c6.setId(6);
		c6.setNombre("Desarollo de software");
		c6.setDescripcion("");
		
		
		
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		lista.add(c5);
		lista.add(c6);
		
	}
	
	
	
	
	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for (Categoria categoria : lista) {
			if (categoria.getId().equals(idCategoria)) {
				return categoria;
			}
		}
		return null;
	}




	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

}
