package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI

public class Demo06 {
	// listado de todos los usuarios 
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios
		String jpql = "select u from Usuarios u";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
		em.close();
		
		// mostrar el contenido del listado
		for (Usuario u : lstUsuarios) {
			System.out.println("codigo...."+ u.getCod_usua());
			System.out.println("nombre...."+ u.getNom_usua() + "" + u.getApe_usua());
			System.out.println("tipo...."+ u.getIdtipo() + "-" + u.getObjTipo().getDescripcion());
			System.out.println(".........");
		}
	}
	
}
