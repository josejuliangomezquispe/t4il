package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

// GUI

public class Demo07 {
	// listado de todos los usuarios 
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_producto
		String jpql = "select p from Producto p";
		List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
		em.close();
		
		// mostrar el contenido del listado
		for (Producto p : lstProductos) {
			System.out.println("codigo...."+ p.getId_prod());
			System.out.println("nombre...."+ p.getDes_prod());
			System.out.println("categoria...."+ p.getObjCategoria() .getDescripcion());
			System.out.println("proveedor...."+ p.getObjProveedor() .getNombre_rs());
			System.out.println(".........");
		}
		
		em.close();
	}
	
}
