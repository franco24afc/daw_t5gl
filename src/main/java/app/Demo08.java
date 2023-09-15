package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class Demo08 {

	// Objetivo: listado de todos los usuarios
		// mostrando ademas el tipo de usuario
		public static void main(String[] args) {

			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion02");
			EntityManager em = fabrica.createEntityManager();
			
			// select * from tb_usuarios --> List
			String jpql = "select u from Producto u";
			List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
			
			// Imprimir el listado
			for (Producto u : lstProductos) {
				System.out.println("Código...:" + u.getId_prod());
				System.out.println("Nombre...:" + u.getDes_prod());
				System.out.println("Proveedor.....:" + u.getIdproveedor() + " " +  u.getObjProveedor().getNombre_rs());
				System.out.println("Categoria.....:" + u.getIdcategoria() + " " +  u.getObjCategoria().getDescripcion());
				System.out.println("--------------------------");
			}
			
			em.close();
		}	
		
}
