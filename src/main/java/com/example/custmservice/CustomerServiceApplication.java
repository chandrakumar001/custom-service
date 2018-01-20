package com.example.custmservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class CustomerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
@RestController
class Cust_Controller{
	private static List list=new ArrayList<>();
	static {
		list.add(new order(1111));
		list.add(new order(2222));
		list.add(new order(3333));
		list.add(new order(4444));
		
	} 
	
	@GetMapping("/customers/{id}")
	public Customer getAll(@PathVariable("id") int id ) {
		
		Customer custom=new Customer(id,"Chandra",list);
		return custom;
	}
	
}
class Customer{
	private int cut_id;
	private String name;
	private List<order> ord;
	public int getCut_id() {
		return cut_id;
	}
	public void setCut_id(int cut_id) {
		this.cut_id = cut_id;
	}
	public List<order> getOrd() {
		return ord;
	}
	public void setOrd(List<order> ord) {
		this.ord = ord;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int cut_id, String name, List<order> ord) {
		super();
		this.cut_id = cut_id;
		this.name = name;
		this.ord = ord;
	}
	@Override
	public String toString() {
		return "Customer [cut_id=" + cut_id + ", name=" + name + ", ord=" + ord + "]";
	}
	
	
	
}

class order{
	private int or_nu;

	public int getOr_nu() {
		return or_nu;
	}

	public void setOr_nu(int or_nu) {
		this.or_nu = or_nu;
	}

	
	public order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public order(int or_nu) {
		super();
		this.or_nu = or_nu;
	}

	@Override
	public String toString() {
		return "order [or_nu=" + or_nu + "]";
	}

}