package deepskilling;

public class DependencyInjection {

    public interface CustomerRepository {
        String findCustomerById(int id);
    }

    public static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(int id) {
            if (id == 1) {
                return "John Doe";
            } else {
                return "Customer not found";
            }
        }
    }

    public static class CustomerService {
        private CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public String getCustomerName(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        System.out.println(customerService.getCustomerName(1));
        System.out.println(customerService.getCustomerName(2));
    }
}
