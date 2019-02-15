package com.stone.mvc;

public class Student {
	private Integer flowId;
	private Integer type;
	private String idCard;
	private String examCard;
	private String studentName;
	private String location;
	private Integer grade;
	public Student() {
		super();
	}
	public Student(Integer flowId, Integer type, String idCard, String examCard, String studentName, String location,
			Integer grade) {
		super();
		this.flowId = flowId;
		this.type = type;
		this.idCard = idCard;
		this.examCard = examCard;
		this.studentName = studentName;
		this.location = location;
		this.grade = grade;
	}
	public Integer getFlowId() {
		return flowId;
	}
	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getExamCard() {
		return examCard;
	}
	public void setExamCard(String examCard) {
		this.examCard = examCard;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}	
}
