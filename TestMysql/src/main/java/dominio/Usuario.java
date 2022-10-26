/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author Alumno Mañana
 */
public class Usuario implements Serializable {

    private int Id;
    private String Name;
    private String Password;

    public Usuario() {
    }

    public Usuario(int Id, String Name, String Password) {
        this.Id = Id;
        this.Name = Name;
        this.Password = Password;
    }

    public Usuario(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.Id;
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
        final Usuario other = (Usuario) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Id=" + Id + ", Name=" + Name + ", Password=" + Password + '}';
    }

}
