package com.zjc.core.query;

import java.io.Serializable;

public class BaseQuery implements Serializable {

	//定义常量 每页数
	public final static int DEFAULT_SIZE = 10;
	private static final long serialVersionUID = 2313564218299912653L;
	//每页数
	protected int pageSize = DEFAULT_SIZE;
	//起始行
	protected int startRow;//起始行
	//页码
	protected int pageNo = 1;
	//Sql查询字段
	protected String fields;
	

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		this.startRow = (pageNo-1)*this.pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public BaseQuery setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.startRow = (pageNo-1)*this.pageSize;
		return this;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	
}
