package DAO;
// Generated 16-jun-2020 11:09:31 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gamasproductos generated by hbm2java
 */
@Entity
@Table(name = "gamasproductos", catalog = "jardineria")
public class Gamasproductos implements java.io.Serializable {

	private String gama;
	private String descripcionTexto;
	private String descripcionHtml;
	private byte[] imagen;

	public Gamasproductos() {
	}

	public Gamasproductos(String gama) {
		this.gama = gama;
	}

	public Gamasproductos(String gama, String descripcionTexto, String descripcionHtml, byte[] imagen) {
		this.gama = gama;
		this.descripcionTexto = descripcionTexto;
		this.descripcionHtml = descripcionHtml;
		this.imagen = imagen;
	}

	@Id

	@Column(name = "Gama", unique = true, nullable = false, length = 50)
	public String getGama() {
		return this.gama;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	@Column(name = "DescripcionTexto", length = 65535)
	public String getDescripcionTexto() {
		return this.descripcionTexto;
	}

	public void setDescripcionTexto(String descripcionTexto) {
		this.descripcionTexto = descripcionTexto;
	}

	@Column(name = "DescripcionHTML", length = 65535)
	public String getDescripcionHtml() {
		return this.descripcionHtml;
	}

	public void setDescripcionHtml(String descripcionHtml) {
		this.descripcionHtml = descripcionHtml;
	}

	@Column(name = "Imagen")
	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

}
