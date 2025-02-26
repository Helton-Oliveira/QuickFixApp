package com.digisphere.QuickFix

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class QuickFixApplicationTests {

	@Test
	fun contextLoads() {
	}

}
