package com.sah.model.entities;
// Generated 11-jun-2014 0:40:44 by Hibernate Tools 3.2.1.GA



/**
 * Comentarios generated by hbm2java
 */
public class Comentarios  implements java.io.Serializable {


     private int idhistorial;
     private Reserva reserva;
     private String calificacion;
     private String comentarios;
     private String recomendacion;

    public Comentarios() {
    }

	
    public Comentarios(int idhistorial, String calificacion, String comentarios, String recomendacion) {
        this.idhistorial = idhistorial;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
        this.recomendacion = recomendacion;
    }
    public Comentarios(int idhistorial, Reserva reserva, String calificacion, String comentarios, String recomendacion) {
       this.idhistorial = idhistorial;
       this.reserva = reserva;
       this.calificacion = calificacion;
       this.comentarios = comentarios;
       this.recomendacion = recomendacion;
    }
   
    public int getIdhistorial() {
        return this.idhistorial;
    }
    
    public void setIdhistorial(int idhistorial) {
        this.idhistorial = idhistorial;
    }
    public Reserva getReserva() {
        return this.reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public String getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
    public String getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public String getRecomendacion() {
        return this.recomendacion;
    }
    
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }




}


