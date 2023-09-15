package app;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

// GUI

public class Demo09 {
	// listado de todos los usuarios, segun un criterio 
	
	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog("ingrese usuario: ");
		String clave = JOptionPane.showInputDialog("ingrese clave: ");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios where idtipos =? -->lista
		String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		try {
			Usuario u = em.createQuery(jpql, Usuario.class).
					setParameter("xusr", usuario).setParameter("xcla",clave).getSingleResult();
			
			// mostrar el contenido del usuario
			
			JOptionPane.showMessageDialog(null, "bienvenido " + u.getNom_usua());
			// abrir la ventana principal 
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			//dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error:Usuario o clave incorrecto");
		}
		
		
		em.close();
	}
	
}
