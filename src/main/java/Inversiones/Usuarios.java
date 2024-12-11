package Inversiones;

public class Usuarios {
    private int IdUsuario;
    private String nombre,contrasena,email;

    //metodos

    public String invertir(){
        return "El usuario puede invertir";
    }
    public String verInversion(){
        return "ver inversiones";
    }

    public Usuarios(int idUsuario, String nombre, String contrasena, String email) {
        IdUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
    }





}
