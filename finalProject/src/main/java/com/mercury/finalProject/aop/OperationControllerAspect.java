package com.mercury.finalProject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.finalProject.bean.OperationsHistory;
import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.bean.User;
import com.mercury.finalProject.mail.EmailService;
import com.mercury.finalProject.service.ProductService;
import com.mercury.finalProject.service.ShelvesProductService;
import com.mercury.finalProject.service.UserServicee;

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
	@Pointcut("execution(* com.mercury.finalProject.controller.OperationsHistoryController.addOperationHistory(..))")
	public void addOperationHistory() {
		
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
