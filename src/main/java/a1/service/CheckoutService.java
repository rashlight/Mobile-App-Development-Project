package a1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import a1.model.CheckoutInfo;
import a1.repository.entity.CartItemEntity;


@Service
public class CheckoutService {
	
	public CheckoutInfo prepareCheckout(List<CartItemEntity> cartItems) {
		CheckoutInfo checkoutInfo = new CheckoutInfo();
		
		float productCost = calculateProductCost(cartItems);
		//float productTotal = calculateProductTotal(cartItems);
		//float paymentTotal = productTotal + shippingCostTotal;
		
		checkoutInfo.setProductCost(productCost);
		//checkoutInfo.setProductTotal(productTotal);
		checkoutInfo.setProductTotal(productCost);
		//checkoutInfo.setShippingCostTotal(shippingCostTotal);
		//checkoutInfo.setPaymentTotal(paymentTotal);
		
		//checkoutInfo.setDeliverDays(shippingRate.getDays());
		//checkoutInfo.setCodSupported(shippingRate.isCodSupported());
		
		return checkoutInfo;
	}


//	private float calculateProductTotal(List<CartItemEntity> cartItems) {
//		float total = 0.0f;
//		
//		for (CartItemEntity item : cartItems) {
//			total += item.getSubtotal();
//		}
//		
//		return total;
//	}

	private float calculateProductCost(List<CartItemEntity> cartItems) {
		float cost = 0.0f;
		
		for (CartItemEntity item : cartItems) {
			cost += item.getQuantity() * item.getItem().getPrice();
		}
		
		return cost;
	}

}
