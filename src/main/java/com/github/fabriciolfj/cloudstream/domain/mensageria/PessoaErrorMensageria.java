package com.github.fabriciolfj.cloudstream.domain.mensageria;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PessoaErrorMensageria {

    String INPUT_ERROR = "input-pessoa-error";
    String OUTPUT_ERROR = "output-pessoa-error";

    @Output(OUTPUT_ERROR)
    MessageChannel pessoaErrorOutput();

    @Input(INPUT_ERROR)
    SubscribableChannel pessoaErrorInput();
}
