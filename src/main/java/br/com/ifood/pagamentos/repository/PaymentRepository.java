package br.com.ifood.pagamentos.repository;

import br.com.ifood.pagamentos.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
