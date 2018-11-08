package com.mercury.finalProject.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.finalProject.bean.OperationView;
import com.mercury.finalProject.bean.OperationsHistory;
import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.bean.User;
import com.mercury.finalProject.bean.UserDetail;
import com.mercury.finalProject.mail.EmailService;
import com.mercury.finalProject.service.OperationViewService;
import com.mercury.finalProject.service.ProductService;
import com.mercury.finalProject.service.ShelvesProductService;
import com.mercury.finalProject.service.UserServicee;
import com.mercury.finalProject.serviceImpl.UserDetailServiceImpl;

@Aspect
@Component
public class OperationControllerAspect {
	@Autowired
	private EmailService eS;
	@Autowired
	private ShelvesProductService sps;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserServicee userService;
	@Autowired
	private OperationViewService ovs;
	@Autowired
	private UserDetailServiceImpl udsi;
	
	
	@After("execution(* com.mercury.finalProject.controller.OperationViewController.updateOperationView(..))")
	public void sendEmailToBuyerUser(JoinPoint joinPoint) {
		OperationView ov = (OperationView)joinPoint.getArgs()[0];
		User sellerUser = userService.getUserById(ov.getSellerUserId());
		User buyerUser = userService.getUserById(ov.getBuyerUserId());
		Product product = productService.getByProductId(ov.getProductId());
		if (ov.getViewStatus() == 1) {
			ShelvesProduct shelvesProduct = sps.getShelvesProductById(ov.getProductId());
			sps.deleteShelvesProduct(shelvesProduct);
			String emailText = buildAcceptPriceText(sellerUser,buyerUser,ov, product);
			String emailTextForSeller = buildAcceptPriceTextForSeller(sellerUser,buyerUser,ov, product);
			eS.sendSimpleMessage(buyerUser.getUsername(), "Your price has been accepted!", emailText);
			eS.sendSimpleMessage(sellerUser.getUsername(), "Contact him to finish the dael!", emailTextForSeller);
		} else if (ov.getViewStatus() == 2) {
			
		}		
	}
	private String buildAcceptPriceTextForSeller(User sellerUser, User buyerUser, OperationView ov, Product product) {
		StringBuffer sb = new StringBuffer();
		UserDetail buyerUserDetail = udsi.findByUserId(buyerUser.getId());
		return sb.append("Dear ").append(getName(buyerUser.getUsername())).append("\n\n")
				.append("Here are user ").append(getName(buyerUser.getUsername())).append(" contact:\n\n Email: ").append(buyerUserDetail.getEmail())
				.append("\n PhoneNumber: ").append(buyerUserDetail.getPhone())
				.append("\n\nPlease contact him/her directly to finish this deal.\n\n")
				.append("All the best,\n").append("iMorrun Group").toString();
	}
	private String buildAcceptPriceText(User sellerUser, User buyerUser, OperationView ov, Product product) {
		StringBuffer sb = new StringBuffer();
		UserDetail sellerUserDetail = udsi.findByUserId(sellerUser.getId());
		return sb.append("Dear ").append(getName(buyerUser.getUsername())).append("\n\n")
				.append("Congradulation! The price \"$").append(ov.getNowPrice()).append("\" you give to user \"").append(getName(sellerUser.getUsername()))
				.append("\" for his/her product with title \"").append(product.getTitle())
				.append("\" was accepted by him/her.\n\n")
				.append("Here are user ").append(getName(sellerUser.getUsername())).append(" contact:\n\n Email: ").append(sellerUserDetail.getEmail())
				.append("\n PhoneNumber: ").append(sellerUserDetail.getPhone())
				.append("\n\nPlease contact him/her directly to finish this deal.\n\n")
				.append("All the best,\n").append("iMorrun Group").toString();
	}
	
	
	
	@After("execution(* com.mercury.finalProject.controller.OperationsHistoryController.addOperationHistory(..))")
	public void sendEmailToUser(JoinPoint joinPoint) {
		OperationsHistory oh = (OperationsHistory)joinPoint.getArgs()[0];
		ShelvesProduct shelvesProduct = sps.getShelvesProductById(oh.getProductId());
		Product product = productService.getByProductId(oh.getProductId());
		User sellUser = userService.getUserById(shelvesProduct.getShelves().getUserId());
		User buyerUser = userService.getUserById(oh.getOperations().getUserId());
		String sellUserName = getName(sellUser.getUsername());
		String title = product.getTitle();
		int originalPrice = product.getPrice();
		int nowPrice = oh.getPrice();
		String buyerUserName = getName(buyerUser.getUsername());
		String bText = buildText(buyerUserName, sellUserName, title,originalPrice, nowPrice);
		
		OperationView operationView = new OperationView();
		operationView.setSellerUserId(sellUser.getId());
		operationView.setBuyerUserId(buyerUser.getId());
		operationView.setBuyerUserName(buyerUserName);
		operationView.setSellerUserName(sellUserName);
		operationView.setOriginalPrice(originalPrice);
		operationView.setNowPrice(nowPrice);
		operationView.setViewStatus(0);
		operationView.setProductId(oh.getProductId());
		operationView.setOperationDate(new Date());
		ovs.addOperationView(operationView);
		eS.sendSimpleMessage(sellUser.getUsername(), "Your product on iMorrun has buyer!", bText);
		
	}
	private String buildText(String fromName, String toName,  String title, int originalPrice, int nowPrice) {
		StringBuffer sb = new StringBuffer();
		return sb.append("Dear ").append(toName).append("\n\n")
			.append("Your product with title \" ").append(title).append("\", ")
			.append("and price $").append(originalPrice)
			.append(" was argued by user ").append(fromName)
			.append(" with price $").append(nowPrice).append(".\n")
			.append("If you accept/reject this request, please go to iMorrun to do more operations. \n\n")
			.append("All the best,\n").append("iMorrun Group").toString();
	}
	private String getName(String s) {
		if (s == null || s.length() == 0) return null;
		String[] front = s.split("@");
		String res = front[0].substring(0, front[0].length() / 2 + 1);
		
		return res + "XXX";
	}
}
