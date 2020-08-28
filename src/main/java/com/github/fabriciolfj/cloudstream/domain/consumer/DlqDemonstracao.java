package com.github.fabriciolfj.cloudstream.domain.consumer;

import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaErrorMensageria;
import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaMensageria;
import com.github.fabriciolfj.cloudstream.domain.model.Pessoa;
import com.github.fabriciolfj.cloudstream.domain.producer.PessoaErrorProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
//@RequiredArgsConstructor
public class DlqDemonstracao {

    private static final String X_RETRIES_HEADER = "x-retries";
    //private final PessoaErrorProducer producer;

    //@StreamListener(PessoaMensageria.INPUT)
    //@SendTo(PessoaMensageria.OUTPUT)
    public Message<?> reRoute(Message<?> failed) {
        var retires = failed.getHeaders().get(X_RETRIES_HEADER, Integer.class);

        if (retires == null) {
            log.info("Primeira tentativa de consumo. " + failed);
            return MessageBuilder.fromMessage(failed)
                    .setHeader(X_RETRIES_HEADER, 1)
                    .setHeader(BinderHeaders.PARTITION_OVERRIDE, failed.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION_ID))
                    .build();
        } else if (retires.intValue() < 3) {
            log.info("Outra tentativa de consumo. " + failed);
            return MessageBuilder.fromMessage(failed)
                    .setHeader(X_RETRIES_HEADER, retires.intValue() + 1)
                    .setHeader(BinderHeaders.PARTITION_OVERRIDE, failed.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION_ID))
                    .build();
        } else {
            log.info("Enviando para a dlq. " + failed);
            //producer.send(failed);
        }

        return null;
    }
}
