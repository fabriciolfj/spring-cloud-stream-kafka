package com.github.fabriciolfj.cloudstream.domain.producer;

import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaMensageria;
import com.github.fabriciolfj.cloudstream.domain.model.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PessoaProducer {

    private final PessoaMensageria mensageria;

    public void send(final Pessoa pessoa) {
        log.info("Informação enviada: " + pessoa);
        final Message<Pessoa> message = MessageBuilder.withPayload(pessoa).build();
        mensageria.pessoaOutput().send(message);
    }


}
