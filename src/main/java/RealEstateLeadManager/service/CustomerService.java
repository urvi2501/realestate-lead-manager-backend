package RealEstateLeadManager.service;

import RealEstateLeadManager.entity.Customer;
import RealEstateLeadManager.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> updateCustomer(
            Long id,
            Customer customerDetails) {

        return customerRepository.findById(id)
                .map(customer -> {

                    customer.setName(customerDetails.getName());
                    customer.setPhone(customerDetails.getPhone());
                    customer.setEmail(customerDetails.getEmail());
                    customer.setAddress(customerDetails.getAddress());
                    customer.setPropertyType(customerDetails.getPropertyType());
                    customer.setBudget(customerDetails.getBudget());
                    customer.setStatus(customerDetails.getStatus());

                    return customerRepository.save(customer);
                });
    }

    public boolean deleteCustomer(Long id) {

        if (!customerRepository.existsById(id)) {
            return false;
        }

        customerRepository.deleteById(id);
        return true;
    }
}