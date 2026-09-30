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

                    customer.setEnquiryDateTime(
                            customerDetails.getEnquiryDateTime());

                    customer.setPurpose(customerDetails.getPurpose());
                    customer.setCategory(customerDetails.getCategory());
                    customer.setPropertyType(
                            customerDetails.getPropertyType());

                    customer.setOtherPropertyType(
                            customerDetails.getOtherPropertyType());

                    customer.setBudget(customerDetails.getBudget());
                    customer.setLocation(customerDetails.getLocation());

                    customer.setCarpetArea(
                            customerDetails.getCarpetArea());

                    customer.setBuiltUpArea(
                            customerDetails.getBuiltUpArea());

                    customer.setSuperBuiltUpArea(
                            customerDetails.getSuperBuiltUpArea());

                    customer.setLeadSource(
                            customerDetails.getLeadSource());

                    customer.setStatus(customerDetails.getStatus());

                    customer.setAdditionalInformation(
                            customerDetails.getAdditionalInformation());

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