package br.inatel.dm110.api.log;

import java.io.Serializable;
import java.util.Date;

public class LogTO implements Serializable {
	
	private static final long serialVersionUID = 224684304229394710L;
	
	private int id;
	private int productCode;
	private String operation;
	private Date timestamp;
	
	public LogTO() {}

	public LogTO(int productCode, String operation) {
		super();
		this.productCode = productCode;
		this.operation = operation;
		this.timestamp = new Date();
	}
	
	public LogTO(int id, int productCode, String operation, Date timestamp) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.operation = operation;
		this.timestamp = timestamp;
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
		return "LogTO [id=" + id + ", productCode=" + productCode + ", operation=" + operation + ", timestamp="
				+ timestamp + "]";
	}

}
