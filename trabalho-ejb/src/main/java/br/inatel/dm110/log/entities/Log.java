package br.inatel.dm110.log.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUDITING", schema = "public")
public class Log implements Serializable {

	private static final long serialVersionUID = -5691078595173884500L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int productCode;
	private String operation;
	private Date timestamp;
	
	public Log() {}

	public Log(int productCode, String operation) {
		super();
		this.productCode = productCode;
		this.operation = operation;
		this.timestamp = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", productCode=" + productCode + ", operation=" + operation + ", timestamp="
				+ timestamp + "]";
	}


	
	
}
