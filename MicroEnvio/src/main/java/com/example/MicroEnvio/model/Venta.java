package com.example.MicroEnvio.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //se conecta con entidad
@Table(name="venta") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor

public class Venta {
    @Id
    private int id_venta;

    private Integer id_pedido;

    private Integer id_tienda;

    private Integer id_cliente;

    private Date fecha_venta;

    private int total_neto;

    private int descuento_aplicado;

    private String tipo_documento;
}
