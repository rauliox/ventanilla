package com.pe.pgn.clubpgn.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * ClpbEmpresaAfiliadora generated by hbm2java
 */
@Entity
@Table(name = "clpb_empresa_afiliadora")
public class ClpbEmpresaAfiliadora extends CamposAuditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private BigDecimal id;
	private String deEmpresaAfiliadora;
	private boolean stEmpresaAfiliadora;
	private ClpbPrograma clpbPrograma;

	public ClpbEmpresaAfiliadora() {
	}

	@Id
    @Column(name="id")
    @SequenceGenerator(name="seqempresaafiliadora", sequenceName="seq_empresa_afiliadora")
    @GeneratedValue(generator="seqempresaafiliadora")
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "de_empresa_afiliadora", nullable = false, length = 100)
	public String getDeEmpresaAfiliadora() {
		return this.deEmpresaAfiliadora;
	}

	public void setDeEmpresaAfiliadora(String deEmpresaAfiliadora) {
		this.deEmpresaAfiliadora = deEmpresaAfiliadora;
	}

	@Column(name = "st_empresa_afiliadora", nullable = false)
	@Type(type = "yes_no") 
	public boolean isStEmpresaAfiliadora() {
		return stEmpresaAfiliadora;
	}

	public void setStEmpresaAfiliadora(boolean stEmpresaAfiliadora) {
		this.stEmpresaAfiliadora = stEmpresaAfiliadora;
	}

	@ManyToOne(targetEntity = ClpbPrograma.class)
	@JoinColumn(name = "co_programa")
	public ClpbPrograma getClpbPrograma() {
		return clpbPrograma;
	}

	public void setClpbPrograma(ClpbPrograma clpbPrograma) {
		this.clpbPrograma = clpbPrograma;
	}

	@Column(name = "co_usuario_creador", updatable = false, nullable = false, length = 30)
	public String getCoUsuarioCreador() {
		return coUsuarioCreador;
	}

    @Column(name = "da_fecha_creacion", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
	public Calendar getDaFechaCreacion() {
		return daFechaCreacion;
	}

	@Column(name = "co_usuario_modificador", length = 30)
	public String getCoUsuarioModificador() {
		return coUsuarioModificador;
	}

    @Column(name = "da_fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
	public Calendar getDaFechaModificacion() {
		return daFechaModificacion;
	}
    
	@Override
	public String toString() {
		return "ClpbEmpresaAfiliadora [id=" + id + ", deEmpresaAfiliadora="
				+ deEmpresaAfiliadora + ", stEmpresaAfiliadora="
				+ stEmpresaAfiliadora + ", clpbPrograma=" + clpbPrograma + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clpbPrograma == null) ? 0 : clpbPrograma.hashCode());
		result = prime
				* result
				+ ((deEmpresaAfiliadora == null) ? 0 : deEmpresaAfiliadora
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (stEmpresaAfiliadora ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClpbEmpresaAfiliadora other = (ClpbEmpresaAfiliadora) obj;
		if (clpbPrograma == null) {
			if (other.clpbPrograma != null)
				return false;
		} else if (!clpbPrograma.equals(other.clpbPrograma))
			return false;
		if (deEmpresaAfiliadora == null) {
			if (other.deEmpresaAfiliadora != null)
				return false;
		} else if (!deEmpresaAfiliadora.equals(other.deEmpresaAfiliadora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stEmpresaAfiliadora != other.stEmpresaAfiliadora)
			return false;
		return true;
	}

}