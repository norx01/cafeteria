package com.cafeteria.cafeteria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "novedades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Novedades
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_novedades;

    @ManyToOne
    @JoinColumn(name = "id_clientes")
    private Clientes clientes;

    @NotBlank(message = "Descripcion es requerida")
    @Column(nullable = false)
    private String descripcion;

    @NotNull(message = "Importancia es requerida")
    @Min(value = 1, message = "Importancia debe ser mayor a 1")
    @Max(value = 10, message = "Importancia debe ser menor o igual a 10")
    @Column(nullable = false)
    private Integer importancia;

}
