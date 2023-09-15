package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_tipos")
@Data
public class Tipo {
	@Id
	private int idtipo;
	private String descripcion;
	
}
