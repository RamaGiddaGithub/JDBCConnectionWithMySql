package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcConnectionWithMySqlApplication implements CommandLineRunner{
@Autowired
JdbcTemplate jdbctemplate;

	public static void main(String[] args) {
		SpringApplication.run(JdbcConnectionWithMySqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql="select * from rama.product_tbl";
		String sql2 = "INSERT INTO rama.product_tbl (id, name, quantity, price) VALUES (?, ?, ?,?)";
        
        int result = jdbctemplate.update(sql2, 101,"Ravi Kumar", "3", 4000.0);
        
        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
		
		//String sql3="update rama.product_tbl set name='bhemma' where id=1";
		//jdbctemplate.execute(sql2);
		//jdbctemplate.execute(sql3);
	List<Product_tbl>	product=jdbctemplate.query(sql, BeanPropertyRowMapper.newInstance(Product_tbl.class));
	product.forEach(System.out::println);
	}

}
