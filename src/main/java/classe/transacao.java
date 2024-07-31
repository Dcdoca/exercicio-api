package classe;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private LocalDateTime dataHora;

    @ManyToOne
    private contabancaria contaOrigem;

    @ManyToOne
    private contabancaria contaDestino;

    public void setContaOrigem(contabancaria contaOrigem2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContaOrigem'");
    }

    public void setContaDestino(contabancaria contaDestino2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContaDestino'");
    }

    public void setValor(Double valor2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setValor'");
    }

    public void setDataHora(LocalDateTime now) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDataHora'");
    }

    // Getters e Setters
}
