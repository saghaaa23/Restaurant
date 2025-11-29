package com.restaurant.restaurant_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurentManagementApplication.class, args);
		System.out.println("\n" +
				"╔══════════════════════════════════════════════════════════╗\n" +
				"║                                                          ║\n" +
				"║   🍽️  RESTAURANT MANAGEMENT SYSTEM                       ║\n" +
				"║                                                          ║\n" +
				"║   ✅ Backend lancé avec succès !                         ║\n" +
				"║                                                          ║\n" +
				"║   📝 Swagger UI: http://localhost:8081/swagger-ui.html  ║\n" +
				"║   🔐 API: http://localhost:8081/api                     ║\n" +
				"║                                                          ║\n" +
				"║   👤 Comptes de test:                                   ║\n" +
				"║      - admin / admin123 (ADMIN)                         ║\n" +
				"║      - manager / manager123 (MANAGER)                   ║\n" +
				"║      - user / user123 (USER)                            ║\n" +
				"║                                                          ║\n" +
				"╚══════════════════════════════════════════════════════════╝\n"
		);
	}
}