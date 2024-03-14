package dto;

import java.sql.Date;

public class BFile {
	private Integer num;
	private String directory;
	private String name;
	private Long size;
	private String contenttype;
	private Date uploaddate;
	
	// 생성자(기본)
	public BFile() {}
	
	// 생성자
	public BFile(Integer num, String directory, String name, Long size, String contenttype, Date uploaddate) {
		this.num = num;
		this.directory = directory;
		this.name = name;
		this.size = size;
		this.contenttype = contenttype;
		this.uploaddate = uploaddate;
	}
	
	
	// get, set
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public Date getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}
	
	
}
