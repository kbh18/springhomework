package kr.ac.hansung.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("kr/ac/hansung/conf/beans.xml");

		OfferDAO offerDAO = (OfferDAO) context.getBean("offerDAO");

		System.out.println("The record count is" + offerDAO.getRowCount());
		
		List<Offer> offerList = offerDAO.getOffers();
		
		for(Offer offer: offerList)
			System.out.println(offer);
		
		Offer offer =  new Offer();
		offer.setName("kim");
		offer.setEmail("75ns@naver.com");
		offer.setText("so good");
		
		if(offerDAO.insert(offer)) {
			System.out.println("object is inserted successfully");
		}
		else
			System.out.println("Object insert failed");
		
		offer = offerDAO.getOffer("kim");
		offer.setName("kim");
		if(offerDAO.update(offer)) {
			System.out.println("Object is update successfully");
		}
		else
			System.out.println("Object update failed");
		
		offer = offerDAO.getOffer("kim");
		System.out.println(offer);
		if(offerDAO.delete(offer.getId())) {
			System.out.println("Object is delete successfully");
		}
		else
			System.out.println("Object delete failed");
		
		context.close();
	}	
}
