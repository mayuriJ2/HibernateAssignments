package com.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Customer {

	@Id
	private Integer custId;
	private String custName;
	private Date custDOB;
	private String custAdd;
	private String custPhone;
	
	//@OneToOne
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="custLockerId")
	private Locker locker;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer custId, String custName, Date custDOB, String custAdd, String custPhone, Locker locker) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custDOB = custDOB;
		this.custAdd = custAdd;
		this.custPhone = custPhone;
		this.locker = locker;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Date getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(Date custDOB) {
		this.custDOB = custDOB;
	}

	public String getCustAdd() {
		return custAdd;
	}

	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custDOB=" + custDOB + ", custAdd=" + custAdd
				+ ", custPhone=" + custPhone + ", locker=" + locker + "]";
	}
	
}
