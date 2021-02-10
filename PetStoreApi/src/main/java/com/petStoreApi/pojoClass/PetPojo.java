package com.petStoreApi.pojoClass;

public class PetPojo {
	
	private int id;
	private Category category;
	private String name;
	private String[] photoUrls;
	private Tag[] tag;
	private String status;
	public PetPojo(int id, Category category, String name, String[] photoUrls, Tag[] tag, String status) {
	
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tag = tag;
		this.status = status;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Tag[] getTag() {
		return tag;
	}

	public void setTag(Tag[] tag) {
		this.tag = tag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
