import com.study.agecalculator.Pessoa;
import com.study.agecalculator.ValidacaoException;

import java.time.LocalDate;

public class PessoaFactory {

    private final int ANO_ATUAL;

    public PessoaFactory() {
        ANO_ATUAL = LocalDate.now().getYear();
    }

    public PessoaFactory(int ANO_ATUAL) {
        this.ANO_ATUAL = ANO_ATUAL;
    }

    public Pessoa[] criar(String[] args) {
        Pessoa[] resposta = new Pessoa[args.length];

        for (int i = 0; i < args.length; i++) {
            String item = args[i];

            String[] partes = item.split(":");

            if(partes.length < 2) {
                throw new ValidacaoException("Cada linha da entrada deve seguir o formato nome:anoNascimento.");
            }

            String nome = partes[0];
            int idade = ANO_ATUAL - Integer.parseInt(partes[1]);

            if(idade < 0) {
                throw new ValidacaoException("Ano de nascimento não pode ser maior que o atual.");
            }

            if(nome.isBlank()) {
                throw new ValidacaoException("O nome não pode ser vazio.");
            }

            resposta[i] = new Pessoa(partes[0], idade);
        }

        return resposta;
    }

}
