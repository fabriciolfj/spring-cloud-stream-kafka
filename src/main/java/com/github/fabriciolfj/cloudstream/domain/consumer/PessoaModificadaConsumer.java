package com.github.fabriciolfj.cloudstream.domain.consumer;

import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaModificadaMensageria;
import com.github.fabriciolfj.cloudstream.domain.model.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PessoaModificadaConsumer {

    @StreamListener(PessoaModificadaMensageria.INPUT)
    public void consumer(final Pessoa pessoa) {
        log.info("Modificada pessoa: " + pessoa);
    }
}
