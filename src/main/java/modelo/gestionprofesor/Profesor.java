
package modelo.gestionprofesor;

import java.sql.Date;

/**
 * @author AdeS
 */
public class Profesor {
    private int id_profesor;
    private String apellido;
    private String nombre;
    private int num_documento;
    private String tipo_documento;
    private Date fecha_nacimineto;
    private String email;
    private int num_tel;
    private String titulo;
    private String especialidad;
    private Date fecha_ingreso;
    private int legajo;
    private int id_domicilio;

    
    public Profesor() {}
    
    public Profesor(int id_profesor, String apellido, String nombre, int num_documento, String tipo_documento, Date fecha_nacimineto, String email, int num_tel, String titulo, String especialidad, Date fecha_ingreso, int legajo, int id_domicilio) {
        this.id_profesor = id_profesor;
        this.apellido = apellido;
        this.nombre = nombre;
        this.num_documento = num_documento;
        this.tipo_documento = tipo_documento;
        this.fecha_nacimineto = fecha_nacimineto;
        this.email = email;
        this.num_tel = num_tel;
        this.titulo = titulo;
        this.especialidad = especialidad;
        this.fecha_ingreso = fecha_ingreso;
        this.legajo = legajo;
        this.id_domicilio = id_domicilio;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(int num_documento) {
        this.num_documento = num_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Date getFecha_nacimineto() {
        return fecha_nacimineto;
    }

    public void setFecha_nacimineto(Date fecha_nacimineto) {
        this.fecha_nacimineto = fecha_nacimineto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id_profesor=" + id_profesor + ", apellido=" + apellido + ", nombre=" + nombre + ", num_documento=" + num_documento + ", tipo_documento=" + tipo_documento + ", fecha_nacimineto=" + fecha_nacimineto + ", email=" + email + ", num_tel=" + num_tel + ", titulo=" + titulo + ", especialidad=" + especialidad + ", fecha_ingreso=" + fecha_ingreso + ", legajo=" + legajo + ", id_domicilio=" + id_domicilio + '}';
    }
    
    
    
}
