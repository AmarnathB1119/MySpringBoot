package io.javapro.springbootstart.dbconn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertUserDetails implements CommandLineRunner   {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO userTable (userName, email) VALUES (" + "'Ram', 'ram@gmail.com')";
		int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }else {
            System.out.println("A new row has been Not inserted.");
        }
	}
}
