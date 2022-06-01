package com.company;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;


public class DispositivoRIC{
    // Constantes de Clase
    private static final String DATE_EXCEPTION = "DATE_EXCEPTION";
    private static final String DATE_FORMAT_EXCEPTION = "DATE_FORMAT_EXCEPTION";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    // Funcion Principal
    public static boolean ValidarMayoriaDeEdad(String nacimiento, String consulta) throws DateException, DateFormatException {
        Date FechaNacimiento;
        Date FechaConsulta;

        try {
            FechaNacimiento = sdf.parse(nacimiento);
        }
        catch (ParseException e){
            throw new DateFormatException(DATE_FORMAT_EXCEPTION, "Fecha Nacimiento con formato incorrecto");
        }

        try {
            FechaConsulta = sdf.parse(consulta);
        }
        catch (ParseException e){
            throw new DateFormatException(DATE_FORMAT_EXCEPTION, "Fecha Consulta con formato incorrecto");
        }

        if (FechaNacimiento.after(FechaConsulta)) {
            throw new DateException(DATE_EXCEPTION, "Fecha de consulta es mayor a fecha de nacimiento");
        }
        if (FechaConsulta.getYear() - FechaNacimiento.getYear() > 18){
            return true;
        }
        else if (FechaConsulta.getYear() - FechaNacimiento.getYear() == 18){
            if (FechaConsulta.getMonth() - FechaNacimiento.getMonth() > 0) {
                return true;
            }
            else if (FechaConsulta.getMonth() - FechaNacimiento.getMonth() == 0) {
                return FechaConsulta.getDay() - FechaNacimiento.getDay() >= 0;
            }
        }
        return false;
    }


}