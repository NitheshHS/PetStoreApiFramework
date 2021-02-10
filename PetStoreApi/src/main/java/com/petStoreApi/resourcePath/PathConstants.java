package com.petStoreApi.resourcePath;

public interface PathConstants {
	/**
	 * In path parameter specify key as petId
	 * eg: pathParam("petId","Integer pet id")
	 */
	public String getPetById="/pet/{petId}";
	
	/**
	 * In path parameter specify key as petId before sending the request
	 * eg: pathParam("petId","Integer pet id")
	 */
	public String uploadPetImage="/pet/{petId}/uploadImage";
	
	/**
	 * Use this end point to create a new pet
	 */
	public String addNewPet="/pet";
	
	/**
	 * Use this end point for update the pet information for already created
	 */
	public String updateExistingPet="/pet";
	
	/**
	 * Use this end point for get status of pet here add query parameter for 
	 * eg1:status=available
	 * eg2: status=sold
	 * eg3: status=pending
	 */
	public String petStatus="/pet/findByStatus";
	
	/**
	 * Use this end point to delete pet by passing path parameter PetId
	 * eg: pathParam("petId","Integer pet id")
	 */
	public String deletePet="/pet/{petId}";

}
