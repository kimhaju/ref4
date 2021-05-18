package com.model2.mvc.service.purchase.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.purchase.PurchaseService;

import junit.framework.Assert;

import com.model2.mvc.common.Search;
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
	//@Test
	public void testGetPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		System.out.println("getPurchase: "+purchase);
		purchase = purchaseService.getPurchase(10000);
		System.out.println("getPurchase111: "+purchase);
		Assert.assertEquals("SCOTT",purchase.getReceiverName());
		
	}
	
	//@Test
	public void testGetPurchase2() throws Exception {
		
		Purchase purchase = new Purchase();
		purchase = purchaseService.getPurchase2(10000);
		System.out.println("getPurchase2: "+purchase);
		//Assert.assertEquals(10000, purchase.getProdNo());
		
	}
	
	@Test

	public void testGetPurchaseListAll() throws Exception{

		Search search = new Search();

		search.setCurrentPage(1);
		search.setPageSize(3);

		String buyerId = "user02";

		Map<String,Object> map = purchaseService.getPurchaseList(search, buyerId);
		List<Object> list = (List<Object>)map.get("list");

		System.out.println("purchase list :" +list);

		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);

		search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");

	 	map = purchaseService.getPurchaseList(search, buyerId);
	 	list = (List<Object>)map.get("list");

	 	System.out.println("purchase search: "+search);
	 	System.out.println("purchase list: "+list);

	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	}

}
