package com.project.reports;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // Força o uso do perfil "test"
class ReportGeneratorApplicationTests {

	@Test
	void contextLoads() {
		// Teste básico para verificar o contexto
	}
}