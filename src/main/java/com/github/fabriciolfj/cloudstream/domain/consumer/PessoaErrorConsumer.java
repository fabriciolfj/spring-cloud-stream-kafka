package com.github.fabriciolfj.cloudstream.domain.consumer;

import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaErrorMensageria;
import com.github.fabriciolfj.cloudstream.domain.model.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PessoaErrorConsumer {

    @StreamListener(PessoaErrorMensageria.INPUT_ERROR)
    public void consumer(final Pessoa pessoa) {
        log.info("Error: " + pessoa.toString());
    }
}
