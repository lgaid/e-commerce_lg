package java_ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Datagenerator {

    public static void createCustomers(){

        Address customer1address1 = new Address("14869","Gallows Rd","Suite 301","22042","VA");
        Address customer1address2 = new Address("15230","Jermantown Drive","Apartment 1109", "20130", "VA");
        Address customer2address1 = new Address("5895","Callow Terrace","A2","220152", "NJ");

        List<Address> customer1AddressList = new ArrayList<>();

        customer1AddressList.add(customer1address1);
        customer1AddressList.add(customer1address2);

        Customer customer1 = new Customer(UUID.randomUUID(),"Kyle","kyle@gmail.com",customer1AddressList);
        Customer customer2 = new Customer(UUID.randomUUID(),"Lilo","lilo@gmail.com");


        StaticConstants.CUSTOMER_LIST.add(customer1);
        StaticConstants.CUSTOMER_LIST.add(customer2);



    }

    public static void createCategory(){

        

    }




}
