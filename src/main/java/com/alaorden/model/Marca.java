package com.alaorden.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idMarca;

    @Column(name = "nombre")
    public String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "marca",fetch = FetchType.LAZY)
    public List<Producto> productos;
}
