package edu.nur.edd.dao;

public class Estudiante {
    private String codigoId;
    private String semIngreso;
    private int ihoraservicio;
    private String carreraId;

    public Estudiante() {
    }

    public Estudiante(String codigoId, String semIngreso, int ihoraservicio, String carreraId) {
        this.codigoId = codigoId;
        this.semIngreso = semIngreso;
        this.ihoraservicio = ihoraservicio;
        this.carreraId = carreraId;
    }

    public Estudiante(String codigoId, String semIngreso, String carreraId, int ihoraservicio) {
        this.codigoId = codigoId;
        this.semIngreso = semIngreso;
        this.carreraId = carreraId;
        this.ihoraservicio = ihoraservicio;

    }

    public Estudiante(String codigoId, String semIngreso, String carreraId) {
        this.codigoId = codigoId;
        this.semIngreso = semIngreso;
        this.carreraId = carreraId;
    }

    public Estudiante(String semIngreso, String carreraId) {
        this.semIngreso = semIngreso;
        this.carreraId = carreraId;
    }

    public Estudiante(String semIngreso, String carreraId, int ihoraservicio) {
        this.semIngreso = semIngreso;
        this.carreraId = carreraId;
        this.ihoraservicio = ihoraservicio;
    }
    public String getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(String codigoId) {
        this.codigoId = codigoId;
    }

    public String getSemIngreso() {
        return semIngreso;
    }

    public void setSemIngreso(String semIngreso) {
        this.semIngreso = semIngreso;
    }

    public int getIhoraservicio() {
        return ihoraservicio;
    }

    public void setIhoraservicio(int ihoraservicio) {
        this.ihoraservicio = ihoraservicio;
    }

    public String getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(String carreraId) {
        this.carreraId = carreraId;
    }
}
