package com.prodapt.ctlacademy.dto;

public class CourseDTO {
	
	    private String courseName;
//	    private String contentType ;
		private String domainName ;
		private String courseDesc;
		private String trainer ;
		private String courseImage;
		private String courseContent;
		
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
//		public String getContentType() {
//			return contentType;
//		}
//		public void setContentType(String contentType) {
//			this.contentType = contentType;
//		}
		public String getDomainName() {
			return domainName;
		}
		public void setDomainName(String domainName) {
			this.domainName = domainName;
		}
		public String getCourseDesc() {
			return courseDesc;
		}
		public void setCourseDesc(String courseDesc) {
			this.courseDesc = courseDesc;
		}
		public String getTrainer() {
			return trainer;
		}
		public void setTrainer(String trainer) {
			this.trainer = trainer;
		}
		public String getCourseImage() {
			return courseImage;
		}
		public void setCourseImage(String courseImage) {
			this.courseImage = courseImage;
		}
		public String getCourseContent() {
			return courseContent;
		}
		public void setCourseContent(String courseContent) {
			this.courseContent = courseContent;
		}
		
		
}
