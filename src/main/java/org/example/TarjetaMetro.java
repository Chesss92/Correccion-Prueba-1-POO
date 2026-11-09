package org.example;

public class TarjetaMetro {
    public static final double tarifa = 0.45;
    private String cedula;
    private String titular;
    private int edad;
    private boolean tieneDiscapacidad;
    private double saldo;
    private int viajesRealizados;
    private double totalRecargado;

    public TarjetaMetro(){
        this.titular = "ANONIMO";
        this.cedula = "1111111";
        this.edad = 30;
        this.tieneDiscapacidad = false;
        this.saldo = 0.0;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTitular() {
        return titular;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getViajesRealizados() {
        return viajesRealizados;
    }

    public double getTotalRecargado() {
        return totalRecargado;
    }

    public void setCedula(String cedula) {
        if (cedula.length() != 10){
            System.out.println("La cedula debe tener exactamente 10 digitos");
            this.cedula = "000000000";
        } else {
            this.cedula = cedula;
        }
    }

    public void setTitular(String titular) {
        if (titular.isBlank()){
            System.out.println("El nombre del titular no puede estar vacio.");
            this.titular = "SIN NOMBRE";
        } else {
            this.titular = titular;
        }
    }

    public void setEdad(int edad) {
        if (edad < 5 || edad > 110){
            System.out.println("La edad esta fuera del rango permitido");
            this.edad = 18;
        } else {
            this.edad = edad;
        }
    }

    public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public TarjetaMetro(String titular, String cedula, int edad, double saldo, boolean tieneDiscapacidad){
        setTitular(titular);
        setCedula(cedula);
        setEdad(edad);
        setTieneDiscapacidad(tieneDiscapacidad);
        if (saldo >= 0 && saldo <= 40){
            this.saldo = saldo;
        } else {
            System.out.println("Saldo inicial esta fuera del rango permitido");
            this.saldo = 0.0;
        }
    }

    public static void mostrarTarifas() {
        System.out.println("Personas con discapacidad: $0.10 (prioridad sobre la edad)");
        System.out.println("De 5 a 17 anios o de 65 en adelante: $0.22");
        System.out.println("Resto de usuarios: $0.45");
        System.out.println("Reglas:");
        System.out.println("- Cada recarga debe ser de $1.00 a $20.00");
        System.out.println("- El saldo de la tarjeta no puede superar $40.00");
        System.out.println("- Un viaje se permite si el saldo es mayor o igual que la tarifa");
    }

    public double calcularTarifa(){
        if (tieneDiscapacidad){
            return  0.10;
        } else if ((edad >= 5 && edad <= 17) || edad >= 65) {
            return  0.22;
        } else {
            return tarifa;
        }
    }

    public double calcularViajesDisponibles(){
        return saldo / calcularTarifa();
    }

    public double calcularViajesDisponibles(double monto){
        return monto / calcularTarifa();
    }

    public boolean recargar(double monto){
        if (monto < 1 || monto > 20){
            System.out.println("MONTO NO PERMITIDO");
            return false;
        } else if (saldo + monto > 40) {
            System.out.println("SUPERA EL SALDO MAXIMO");
            return false;
        } else {
            saldo += monto;
            totalRecargado =+ monto;
            System.out.println("Recarga exitosa. Nuevo saldo: $"+saldo);
            return true;
        }
    }

    public boolean pagarViaje(){
        double tarifa = calcularTarifa();
        if (saldo >= tarifa){
            saldo -= tarifa;
            viajesRealizados ++;
            System.out.println("ACCESO PERMITIDO. Saldo restante: $"+saldo);
            return  true;
        } else {
            System.out.println("SALDO ES INSUFICIENTE");
            return  false;
        }
    }

    public void mostrarInformacion(){
        System.out.println("Titular: "+titular);
        System.out.println("Cedula: "+cedula);
        System.out.println("Edad: "+edad);
        System.out.println("Tiene discapacidad?: "+tieneDiscapacidad);
        System.out.println("Tarifa aplicada: $"+calcularTarifa());
        System.out.println("Saldo: $"+saldo);
        System.out.println("Viajes Realizados: "+viajesRealizados);
    }

}
