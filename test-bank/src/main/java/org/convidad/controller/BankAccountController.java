package org.convidad.controller;

import java.util.List;

import org.convidad.domain.BankAccount;
import org.convidad.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BankAccountController {

	@Autowired
	BankAccountService bankAccountService;

	/**
	 * Return a list with all bank accounts.
	 * 
	 * @return 200 OK. 			List of bank accounts. <br>
	 * 		   204 No Content. 	If there aren't bank accounts.
	 */
	@RequestMapping(value = "/bankaccounts/", method = RequestMethod.GET)
	public ResponseEntity<List<BankAccount>> listAllBankAccounts() {
		List<BankAccount> list = bankAccountService.listAllBankAccounts();
		HttpStatus httpStatus = list.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<List<BankAccount>>(list, httpStatus);
	}

	/**
	 * Return one bank account.
	 * 
	 * @return 200 OK.	 		Info of bank account. <br>
	 *         204 No Content. 	If the bank account doesn't exist.
	 */
	@RequestMapping(value = "/bankaccounts/{id}", method = RequestMethod.GET)
	public ResponseEntity<BankAccount> getBankAccount(@PathVariable("id") String id) {
		BankAccount bankaccount = bankAccountService.findBankAccount(id);
		return bankaccount != null ?  new ResponseEntity<BankAccount>(bankaccount, HttpStatus.OK) : new ResponseEntity<BankAccount>(HttpStatus.NO_CONTENT);  
	}

	/**
	 * Create a new bank account.
	 * 
	 * @param BankAccount object.
	 * @return 201 Created if a new bank account has been inserted. <br> 
	 *         409 Conflict if it was not possible to create the new bank account.
	 */
	@RequestMapping(value = "/bankaccounts/", method = RequestMethod.POST)
	public ResponseEntity<Void> addBankAccount(@RequestBody BankAccount bankAccount) {
		HttpStatus returnStatus = bankAccountService.addBankAccount(bankAccount) ? HttpStatus.CREATED : HttpStatus.CONFLICT;
		return new ResponseEntity<Void>(new HttpHeaders(), returnStatus);
	}

	/**
	 * Update an existing bank account.
	 * 
	 * @param BankAccount object.
	 * @return 200 OK.		 If the bank account has been updated. <br> 
	 * 		   409 Conflict. If it was not possible to updated the bank account.
	 */
	@RequestMapping(value = "/bankaccounts/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateBankAccount(@RequestBody BankAccount bankAccount) {
		HttpStatus returnStatus = bankAccountService.updateBankAccount(bankAccount) ? HttpStatus.OK : HttpStatus.CONFLICT;
		return new ResponseEntity<Void>(new HttpHeaders(), returnStatus);
	}

	/**
	 * Update a bank account.
	 * 
	 * @param Bank account id
	 * @param BankAccount object.
	 * @return 200 OK.		 If the bank account has been updated. <br> 
	 * 		   409 Conflict. If it was not possible to update the bank account.
	 */
	@RequestMapping(value = "/bankaccounts/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateBankAccountById(@PathVariable("id") String id, @RequestBody BankAccount bankAccount) {
		bankAccount.setId(id);
		HttpStatus returnStatus = bankAccountService.updateBankAccount(bankAccount) ? HttpStatus.OK : HttpStatus.CONFLICT;
		return new ResponseEntity<Void>(new HttpHeaders(), returnStatus);
	}

	/**
	 * Delete a bank account.
	 * 
	 * @param Bank account id
	 * @param BankAccount object.
	 * @return 201 OK + Bank account info.	 If the bank account has been removed. <br> 
	 *         204 No content. 				 if it was not possible to remove the bank account.
	 */	
	@RequestMapping(value = "/bankaccounts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BankAccount> deleteBankAccountById(@PathVariable("id") String id) {
		BankAccount deleted = bankAccountService.deleteBankAccountById(id);
		HttpStatus returnStatus = deleted != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
		return new ResponseEntity<BankAccount>(deleted, returnStatus);
	}

}
