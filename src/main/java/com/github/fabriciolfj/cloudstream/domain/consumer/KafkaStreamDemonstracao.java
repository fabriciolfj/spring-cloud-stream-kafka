package com.github.fabriciolfj.cloudstream.domain.consumer;

import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaMensageria;
import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaModificadaMensageria;
import com.github.fabriciolfj.cloudstream.domain.model.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaStreamDemonstracao {

    @StreamListener(PessoaMensageria.INPUT)
    @SendTo(PessoaModificadaMensageria.OUTPUT)
    public KStream<?, Pessoa> process(KStream<?, String> input) {


        return input
                .mapValues(value -> new Pessoa(UUID.randomUUID().toString(), value))
                .map((key, value) -> new KeyValue<>(null, value));
    }
}
