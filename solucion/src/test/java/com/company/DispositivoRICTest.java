package com.company;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test
public class DispositivoRICTest  {
    String fechaNacimiento;
    String fechaConsulta;
    DispositivoRIC dispositivoRIC;

    public void setUp()  {
        fechaNacimiento = "24/06/2002";
        fechaConsulta = "30/06/2022";
    }

    @Test
    public void testMayorDeEdad() throws DateException, DateFormatException {
        Assert.assertTrue(dispositivoRIC.ValidarMayoriaDeEdad(fechaNacimiento, fechaConsulta), "Es mayor de edad");
    }
}
