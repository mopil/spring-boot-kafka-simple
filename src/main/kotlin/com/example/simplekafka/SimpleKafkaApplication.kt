package com.example.simplekafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleKafkaApplication

fun main(args: Array<String>) {
	runApplication<SimpleKafkaApplication>(*args)
}
