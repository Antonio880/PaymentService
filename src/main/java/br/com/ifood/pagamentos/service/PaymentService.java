package br.com.ifood.pagamentos.service;

import br.com.ifood.pagamentos.dto.PaymentDto;
import br.com.ifood.pagamentos.model.Payment;
import br.com.ifood.pagamentos.model.Status;
import br.com.ifood.pagamentos.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PaymentDto> getAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(p -> modelMapper.map(p, PaymentDto.class));
    }

    public PaymentDto getById(Long id) {
        Payment payment = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(payment, PaymentDto.class);
    }

    public PaymentDto save(PaymentDto paymentDto) {
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        payment.setStatus(Status.CRIADO);
        payment = repository.save(payment);

        return modelMapper.map(payment, PaymentDto.class);
    }

    public PaymentDto updatePayment(Long id, PaymentDto dto) {
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setId(id);
        payment = repository.save(payment);
        return modelMapper.map(payment, PaymentDto.class);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
