package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GamasproductosDAO {

	Session ses;

	public GamasproductosDAO() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		this.ses = sf.openSession();
	}
	
	public List<Gamasproductos> getAll() {
		Query query = ses.createQuery("from Gamasproductos");
		List<Gamasproductos> lista = query.list();
		return lista;
	}
	
	public Gamasproductos get(String gama) {
		Gamasproductos gamasproductos = (Gamasproductos) ses.get(Gamasproductos.class, gama);
		return gamasproductos;
	}
	
	public List<Gamasproductos> getAll(String gama) {
		Query query = ses.createQuery("from Gamasproductos where gama= :aromaticas").setParameter("aromaticas",gama);
		List<Gamasproductos> lista = query.list();
		return lista;
	}

	public Gamasproductos create(Gamasproductos g){
		ses.beginTransaction();
		ses.save(g);
		ses.getTransaction().commit();
		return g;
	}
	
	public Gamasproductos update(Gamasproductos g) {
		ses.beginTransaction();
		ses.update(g);
		ses.getTransaction().commit();
		return g;
	}
	
	public void delete(String gama) {
		Gamasproductos g = get(gama);
		ses.beginTransaction();
		ses.delete(g);
		ses.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		GamasproductosDAO pgm = new GamasproductosDAO();
		pgm.test();

	}
	
	private void test() {
		 System.out.println("Inicio ");
		 
//		 List<Gamasproductos> lista1= getAll();
//		 for (int i=0; i<lista1.size(); i++) {
//			 Gamasproductos gama1 = lista1.get(i);
//			 System.out.println(gama1.getGama()+ " $ " + gama1.getDescripcionTexto()+ " $ " 
//					 + gama1.getDescripcionHtml()+ " $ " + gama1.getImagen());
//		 }
		 
//		 Gamasproductos gama2 = get("Aromáticas");
//			System.out.println(gama2.getGama()+ " $ " + gama2.getDescripcionTexto()+ " $ " 
//					 + gama2.getDescripcionHtml()+ " $ " + gama2.getImagen());
//				  System.out.println("Detalle leido");
				  
//		 	List<Gamasproductos> lista2 = getAll("Aromáticas");
//			for (int i = 0; i < lista2.size(); i++) {
//				Gamasproductos gama3 = lista2.get(i);
//				System.out.println(gama3.getGama()+ " $ " + gama3.getDescripcionTexto()+ " $ " 
//				 + gama3.getDescripcionHtml()+ " $ " + gama3.getImagen());
//		}	
//			System.out.println("Detalles de un pedido leido");
		 
//			Gamasproductos gama3 = new Gamasproductos(); 
//			gama3.setGama("Payaso");
//			gama3.setDescripcionTexto("Payaso aromatico");
//			gama3.setDescripcionHtml(null);
//			gama3.setImagen(null);
//			create(gama3);
//			System.out.println("Alta realizada");
//			 
//			 Gamasproductos gama4 = new Gamasproductos(); 
//			gama4.setGama("Payaso2");
//			gama4.setDescripcionTexto("Payaso aromatico 2");
//			gama4.setDescripcionHtml(null);
//			gama4.setImagen(null);
//			 update(gama4);
//			 System.out.println("Actualizacion realizada");
		  
			
		  delete("Payaso");
			System.out.println("Borrado realizado");
			
			
	}
}
