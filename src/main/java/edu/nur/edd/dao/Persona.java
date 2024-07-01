package edu.nur.edd.dao;


import java.sql.Date;
import java.sql.Timestamp;

public class Persona {
    private String codigoId;
    private String snombre;
    private String appaterno;
    private String apmaterno;
    private String dtnacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private Timestamp fechaIngreso;

    public Persona() {
    }

    public Persona(String codigoId, String snombre, String appaterno, String apmaterno, String dtnacimiento, String direccion, String telefono, String email, Timestamp fechaIngreso) {
        this.codigoId = codigoId;
        this.snombre = snombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.dtnacimiento = dtnacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
    }

    public Persona(String codigoId, String snombre, String appaterno, String apmaterno, String dtnacimiento, String direccion, String telefono, String email) {
        this.codigoId = codigoId;
        this.snombre = snombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.dtnacimiento = dtnacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;

    }
    public String getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(String codigoId) {
        this.codigoId = codigoId;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getDtnacimiento() {
        return dtnacimiento;
    }

    public void setDtnacimiento(String dtnacimiento) {
        this.dtnacimiento = dtnacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getFechaIngreso() {
        return new Timestamp(System.currentTimeMillis());
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
