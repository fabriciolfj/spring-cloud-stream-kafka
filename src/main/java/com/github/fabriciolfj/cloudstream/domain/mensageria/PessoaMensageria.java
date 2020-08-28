package com.github.fabriciolfj.cloudstream.domain.mensageria;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PessoaMensageria {

    String INPUT = "input-pessoa";
    String OUTPUT = "output-pessoa";

    @Output(OUTPUT)
    MessageChannel pessoaOutput();

    @Input(INPUT)
    SubscribableChannel pessoaInput();

}

