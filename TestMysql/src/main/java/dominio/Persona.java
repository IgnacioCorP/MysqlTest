/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * DAO - Data Acces Object: 
 */
public class Persona implements Serializable{
    private int Id;
    private String name;
    private String LastName;
    private String Email;
    private String Telefono;

    public Persona(int Id, String name, String LastName, String Email, String Telefono) {
        this.Id = Id;
        this.name = name;
        this.LastName = LastName;
        this.Email = Email;
        this.Telefono = Telefono;
    }

    public Persona(String name, String LastName, String Email, String Telefono) {
        this.name = name;
        this.LastName = LastName;
        this.Email = Email;
        this.Telefono = Telefono;
    }

    public Persona() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.Id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "Id=" + Id + ", name=" + name + ", LastName=" + LastName + ", Email=" + Email + ", Telefono=" + Telefono + '}';
    }
    
    
    
}
