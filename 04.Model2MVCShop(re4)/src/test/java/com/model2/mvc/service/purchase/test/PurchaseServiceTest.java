package com.model2.mvc.service.purchase.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.purchase.PurchaseService;

import junit.framework.Assert;

import com.model2.mvc.service.domain.Purchase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {

	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	//@Test
	public void testAddPurchase() throws Exception{
		
		Purchase purchase = new Purchase();
		
		purchase.setProdNo(10002);
		purchase.setPaymentOption("1");
		purchase.setReceiverName("test");
		purchase.setReceiverPhone("010".trim());
		purchase.setDivyAddr("testHome");
		purchase.setDivyRequest("testRequest");
		purchase.setTranCode("1".trim());
		//purchase.getDivyDate();
		
		System.out.println("addPurchase: "+purchase);
		
		purchaseService.addPurchase(purchase);
			
	}
	@Test
	public void testGetPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		
		purchase = purchaseService.getPurchase(10001);
		
		System.out.println("getPurchase: "+purchase);
		
		Assert.assertEquals(10001, purchase.getTranNo());
		
	}
	
	//@Test
	public void testGetPurchase2() throws Exception {
		
		Purchase purchase = new Purchase();
		
		purchase = purchaseService.getPurchase2(10000);
		
		System.out.println("getPurchase2: "+purchase);
		
		Assert.assertEquals(10000, purchase.getProdNo());
		
	}

}
