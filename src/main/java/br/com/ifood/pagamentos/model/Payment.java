package br.com.ifood.pagamentos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal value;

    @NotNull
    @Size(max=100)
    private String name;

    @NotBlank
    @Size(max=19)
    private String number;

    @NotBlank
    @Size(max=7)
    private String expiration;

    @NotBlank
    @Size(min=3, max=3)
    private String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long orderId;

    @NotNull
    private Long paymentMethodId;

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getCode() {
        return code;
    }

    public Status getStatus() {
        return status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
