package org.convidad.controller;

import org.convidad.datarepo.Database;
import org.convidad.domain.BankAccount;
import org.convidad.domain.Client;
import org.convidad.service.BankAccountService;
import org.convidad.service.BankService;
import org.convidad.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BankController {
	
	public static Database database = Database.getInstace();
	
	@Autowired
	BankService bankService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	BankAccountService bankAccountService;
	
	/**
	 * Return an web interface that allows the user to create a new bank account
	 */
	@RequestMapping(value="/new-account-view", method = RequestMethod.GET)
	public ModelAndView createAccount() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("createAccount");
		return mav;
	}
	
	/**
	 * Create a bank account for an existing client.
	 * 
	 * @return Page correct. If the operation was successful. <br>
	 * 		   Page error. 	 If the operation was not successful.
	 */
	@RequestMapping(value = "/new-account/{idClient}", method = RequestMethod.POST)
	public ModelAndView createAccount(@PathVariable("idClient") String idClient, @RequestBody BankAccount bankAccount) {
		boolean created =  bankService.createBankAccountForClient(idClient, bankAccount);
		String viewName = created ? "clientInfo" : "error";
		ModelAndView mav = new ModelAndView();
		Client client = clientService.findClient(idClient);
		mav.addObject("client", client);
		mav.setViewName(viewName);
		return mav;
	}
	
	/**
	 * Return a view with the info of a client.
	 * 
	 * @return Page with client info. If the operation was successful. <br>
	 * 		   Page error. 	          If the operation was not successful.
	 */
	@RequestMapping(value = "/client-info/{idClient}", method = RequestMethod.GET)
	public ModelAndView viewClient(@PathVariable("idClient") String idClient) {
		Client client = clientService.findClient(idClient);
		String viewName = client != null  ? "clientInfo" : "error";
		ModelAndView mav = new ModelAndView();
		mav.addObject("client", client);
		mav.setViewName(viewName);
		return mav;
	}
	
	/**
	 * Return a view to inject in another view.
	 * 
	 * @return Page with client info. If the operation was successful. <br>
	 * 		   Page error. 	          If the operation was not successful.
	 */
	@RequestMapping(value = "/simple-view-client-info/{idClient}", method = RequestMethod.GET)
	public ModelAndView simpleViewClient(@PathVariable("idClient") String idClient) {
		Client client = clientService.findClient(idClient);
		String viewName = client != null  ? "simpleHtmlClientInfo" : "error";
		ModelAndView mav = new ModelAndView();
		mav.addObject("client", client);
		mav.setViewName(viewName);
		return mav;
	}	
	
	/**
	 * Deposit money in a bank account adding the parameters in the url. <br>
	 * 
	 * Example: http://localhost:8080/deposit?id=5416123015035048&amount=234
	 * 
	 * @param id of the bank account
	 * @param amount of money to deposit
	 * @return web interface with the state of the bank account
	 */
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public ModelAndView depositMoney(@RequestParam(required = true) String id,
									@RequestParam(required = true) double amount) {
    	double deposited =  bankService.depositMoneyInBankAccount(id, amount);
		String viewName = deposited != Double.NaN ? "bankAccountInfo" : "error";
		ModelAndView mav = new ModelAndView();
		BankAccount bankAccount= bankAccountService.findBankAccount(id);
		mav.addObject("bankAccount", bankAccount);
		mav.setViewName(viewName);
		return mav;
	}
	
	/**
	 * Deposit money in a bank account adding the parameters in the url. <br>
	 * 
	 * Example: http://localhost:8080/deposit?id=5416123015035048&amount=234
	 * 
	 * @param id of the bank account
	 * @param amount of money to deposit
	 * @return web interface with the state of the bank account
	 */
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public ModelAndView withdrawMoney(@RequestParam(required = true) String id,
									@RequestParam(required = true) double amount) {
    	double withdrawed =  bankService.withdrawMoneyInBankAccount(id, amount);
		String viewName = withdrawed != Double.NaN ? "bankAccountInfo" : "error";
		ModelAndView mav = new ModelAndView();
		BankAccount bankAccount= bankAccountService.findBankAccount(id);
		mav.addObject("bankAccount", bankAccount);
		mav.setViewName(viewName);
		return mav;
	}	
	
	
}
