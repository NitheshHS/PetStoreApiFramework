package com.petStoreApi.resourcePath;
/**
 * This interface conatins all store end points
 * @author Nitheesha
 *
 */
public interface StorePath {
	
	String placeOrderPet="/store/order";
	String findPurchaseOrder="/store/order/{orderId}";
	String deletePurchaseOrder="/store/order/{orderId}";
	

}
