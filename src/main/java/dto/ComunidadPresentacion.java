package dto;

import java.util.List;

public class ComunidadPresentacion {
    private String nombre;
    private String objetivo;
    private List<MiembroPresentacion> miembros;
    private List<MiembroPresentacion> administradores;
    private Boolean esAdmin;
}
