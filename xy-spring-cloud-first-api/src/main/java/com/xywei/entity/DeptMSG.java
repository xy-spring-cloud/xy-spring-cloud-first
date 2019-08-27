package com.xywei.entity;

/**
 * @author future
 * @Datetime 2019年8月27日 下午12:41:49<br/>
 * @Description
 */
public class DeptMSG extends Dept {

	/**
	 * @Datetime 2019年8月27日 下午12:44:03<br/>
	 */
	private static final long serialVersionUID = -6312356722070552042L;
	private String message;

	public DeptMSG(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DeptMSG [message=" + message + ", getDeptno()=" + getDeptno() + ", getDname()=" + getDname()
				+ ", getDb_source()=" + getDb_source() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
