package com.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.model.Address;
import com.customer.model.AddressHistory;
import com.customer.model.Customer;
import com.customer.model.CustomerHistory;
import com.customer.repository.AddressHistoryRepository;
import com.customer.repository.AddressRepository;
import com.customer.repository.CustomerHistoryRepository;
import com.customer.repository.CustomerIdSequenceRepositoryImpl;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.customer.util.CustomerConstants;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CustomerIdSequenceRepositoryImpl customerIdSequenceRepository;

	@Autowired
	CustomerHistoryRepository customerHistoryRepository;

	@Autowired
	AddressHistoryRepository addressHistoryRepository;

	@Override
	public Customer signUp(Customer customer) {
		customer.setId("C" + Long
				.toString(customerIdSequenceRepository.getNextSequenceId(CustomerConstants.CUSTOMER_ID_SEQUENCE_NAME)));
		List<Address> addresses = customer.getAddress();
		addressRepository.saveAll(addresses);
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getListOfCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomerById(Customer customer, String customerID) {
		customer.setId(customerID);
		addressRepository.saveAll(customer.getAddress());
		return customerRepository.save(customer);
	}

	@Override
	public String deleteCustomerById(String customerId) {

		if (customerRepository.existsById(customerId)) {

			Customer customer = customerRepository.findById(customerId).get();

			List<AddressHistory> addresshistory = new ArrayList<>();

			for (Address address : customer.getAddress()) {
				AddressHistory addrresshitry = new DozerBeanMapper().map(address, AddressHistory.class);
				addresshistory.add(addrresshitry);
			}

			CustomerHistory customerhistory = new DozerBeanMapper().map(customer, CustomerHistory.class);

			movedataToHistory(customerhistory, addresshistory);

			deleteCustomer(customer);

			return "Requested Customer is Deleted : " + customerId;
		} else {
			return "Request CustomerId is Not Exist";
		}
	}

	private void movedataToHistory(CustomerHistory customer, List<AddressHistory> address) {
		addressHistoryRepository.saveAll(address);
		customerHistoryRepository.save(customer);
	}

	private void deleteCustomer(Customer customer) {
		addressRepository.deleteAll(customer.getAddress());
		customerRepository.delete(customer);
	}

	@Override
	public Customer getCustomerById(String customerID) {
		return customerRepository.findById(customerID).get();
	}

	@Override
	public Customer getCustomerByPhonenumber(String phonenumber) {
		return customerRepository.findByPhonenumber(phonenumber);
	}
}
