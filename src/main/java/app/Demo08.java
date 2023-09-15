package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI

public class Demo08 {
	// listado de todos los usuarios, segun un criterio 
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios where idtipos =? -->lista
		int xtipo =1;
		String jpql = "select u from Usuario u where u.idtipo = :xtipo";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).
				setParameter("xtipo", xtipo).getResultList();
		
		// mostrar el contenido del listado
		for (Usuario u : lstUsuarios) {
			System.out.println("codigo...."+ u.getCod_usua());
			System.out.println("nombre...."+ u.getNom_usua() + "" + u.getApe_usua());
			System.out.println("tipo...."+ u.getIdtipo() + "-" + u.getObjTipo().getDescripcion());
			System.out.println(".........");
		}
		
		em.close();
	}
	
}
