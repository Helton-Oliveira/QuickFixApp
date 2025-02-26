package com.digisphere.QuickFix

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<QuickFixApplication>().with(TestcontainersConfiguration::class).run(*args)
}
