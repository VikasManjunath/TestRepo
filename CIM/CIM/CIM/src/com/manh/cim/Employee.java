package com.manh.cim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ibm.mobile.services.data.IBMDataObject;
import com.ibm.mobile.services.data.IBMDataObjectSpecialization;
@IBMDataObjectSpecialization("Employee")
public class Employee  extends IBMDataObject implements Serializable {

	/**
	 * @param eMPLOYEE_NAME
	 * @param eMPLOYEE_MAIL_ID
	 * @param eMPLOYEE_EXTN
	 * @param eMPLOYEE_MGR
	 * @param eMPLOYEE_DESCRIPTION_RATING
	 */
	public Employee(String eMPLOYEE_NAME, String eMPLOYEE_MAIL_ID,
			String eMPLOYEE_EXTN, String eMPLOYEE_MGR, Integer eMPLOYEE_ID,
			ArrayList<String> eMPLOYEE_DESCRIPTION_RATING) {
		super();
		EMPLOYEE_NAME = eMPLOYEE_NAME;
		EMPLOYEE_MAIL_ID = eMPLOYEE_MAIL_ID;
		EMPLOYEE_EXTN = eMPLOYEE_EXTN;
		EMPLOYEE_MGR = eMPLOYEE_MGR;
		EMPLOYEE_ID = eMPLOYEE_ID;
		EMPLOYEE_DESCRIPTION_RATING = new ArrayList<String>(eMPLOYEE_DESCRIPTION_RATING);
	}

	private String CLASS_NAME = "Employee";
	private String EMPLOYEE_NAME = "name";
	private String EMPLOYEE_MAIL_ID = "name";
	private String EMPLOYEE_EXTN = "name";
	private String EMPLOYEE_MGR = "name";
	private Integer EMPLOYEE_ID = 0;
	
	public Integer getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}


	public void setEMPLOYEE_ID(Integer eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}

	private ArrayList <String> EMPLOYEE_DESCRIPTION_RATING = null;
	private Float EMPLOYEE_AVG_RATING = (float) 0.0;
	
	public Float getEMPLOYEE_AVG_RATING() {
		return EMPLOYEE_AVG_RATING;
	}


	public void setEMPLOYEE_AVG_RATING(Float eMPLOYEE_AVG_RATING) {
		EMPLOYEE_AVG_RATING = eMPLOYEE_AVG_RATING;
	}


	public String getClassName() {
		return CLASS_NAME;
	}


	public String getEmployeeMailId() {
		return EMPLOYEE_MAIL_ID;
	}


	public String getEmployeeExtn() {
		return EMPLOYEE_EXTN;
	}


	public List<String> getEmployeeDescriptionRating() {
		return EMPLOYEE_DESCRIPTION_RATING;
	}


	public void setClassName(String className) {
		CLASS_NAME = className;
	}


	public void setEmployeeMailId(String employeeMailId) {
		EMPLOYEE_MAIL_ID = employeeMailId;
	}


	public void setEmployeeExtn(String employeeExtn) {
		EMPLOYEE_EXTN = employeeExtn;
	}


	public void setEmployeeDescriptionRating(
			ArrayList<String> employeeDescriptionRating) {
		EMPLOYEE_DESCRIPTION_RATING = employeeDescriptionRating;
	}


	/**
	 * gets the name of the EMPLOYEE.
	 * @return String EMPLOYEE_NAME
	 */
	public String getEmployeeName() {
		return EMPLOYEE_NAME;
	}


	public void setEmployeeName(String employeeName) {
		setObject(EMPLOYEE_NAME, (employeeName != null) ? employeeName : "");
	}
	
	/**
	 * when calling toString() for an item, we'd really only want the name.
	 * @return String theItemName
	 */
	public String toString() {
		String theItemName = "";
		theItemName = getEmployeeName();
		return theItemName;
	}
	
	
	
	
}
