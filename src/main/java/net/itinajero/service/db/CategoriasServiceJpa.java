package net.itinajero.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.itinajero.model.Categoria;
import net.itinajero.repository.CategoriasRepository;
import net.itinajero.service.ICategoriasService;
@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {
	@Autowired
    private CategoriasRepository categoriasrepo;
	@Override
	public void guardar(Categoria categoria) {
		categoriasrepo.save(categoria);

	}

	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return categoriasrepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional <Categoria> optional=categoriasrepo.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		categoriasrepo.deleteById(idCategoria);
		
	}

}
