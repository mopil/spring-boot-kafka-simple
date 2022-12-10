package com.example.simplekafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Component
class SimpleConsumer {
    @KafkaListener(topics = ["mopil"], groupId = "group-id-mopil")
    fun consume(message: String) {
        println("receive message : $message")
    }
}

data class MessageDto(val message: String)

@RestController
class SimpleProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @PostMapping("/message")
    fun sendMessage(@RequestBody messageDto: MessageDto) {
        println("send message : $messageDto.message")
        kafkaTemplate.send("mopil", messageDto.message)
    }
}