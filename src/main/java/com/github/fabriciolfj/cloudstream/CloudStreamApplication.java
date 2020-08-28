package com.github.fabriciolfj.cloudstream;

import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaErrorMensageria;
import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaMensageria;
import com.github.fabriciolfj.cloudstream.domain.mensageria.PessoaModificadaMensageria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({PessoaMensageria.class, PessoaErrorMensageria.class, PessoaModificadaMensageria.class})
@SpringBootApplication
public class CloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamApplication.class, args);
	}

}
