package com.oregoom.celulares;

import java.sql.*;
import java.util.Scanner;

public class MainCel {

    public static void main(String[] args) throws SQLException {
        Scanner RTA = new Scanner(System.in);
        System.out.println("Elije una opcion\n"
                + "1) Agregar un celular.\n"
                + "2) Agregar un cliente.\n"
                + "3) Realizar un alquiler.\n"
                + "4) Consultar celulares.\n"
                + "5) Consultar clientes.\n"
                + "6) Consultar alquileres.\n"
                + "7) Consultar alquileres por clientes.\n"
                + "8) Salir.");

        int opcion = RTA.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("A continuacion ingresa los siguientes datos del celular.");
                String M = RTA.nextLine();
                System.out.println("Marca");
                String Marca = RTA.nextLine();
                System.out.println("Referencia");
                String Referencia = RTA.nextLine();
                System.out.println("Ram");
                String Ram = RTA.nextLine();
                System.out.println("Pixeles camara");
                String PxCamara = RTA.nextLine();

                InsertarCelulares(Marca, Referencia, Ram, PxCamara);
                break;
            case 2:
                System.out.println("A continuacion ingresa los siguientes datos del cliente");
                M = RTA.nextLine();
                System.out.println("Numero de documento");
                int NumDocumento = RTA.nextInt();
                System.out.println("Nombre y apellido");
                RTA.nextLine();
                String NombreApellido = RTA.nextLine();
                System.out.println("Numero de contacto");
                int NumContacto = RTA.nextInt();
                RTA.nextLine();
                System.out.println("Direccion del cliente");
                String Direccion = RTA.nextLine();

                InsertarClientes(NumDocumento, NombreApellido, NumContacto, Direccion);
                break;
            case 3:
                System.out.println("Registro de alquiler");
                System.out.println("Numero de documento");
                NumDocumento = RTA.nextInt();
                System.out.println("Marca del celular");
                RTA.nextLine();
                Marca = RTA.nextLine();
                System.out.println("Referencia delcelular");
                Referencia = RTA.nextLine();
                System.out.println("Dias de alquiler");
                int DiasAlquilado = RTA.nextInt();

                InsertarAlquileres(NumDocumento, Marca, Referencia, DiasAlquilado);
                break;
            case 4:
                System.out.println("Celulares reistrados.");
                ListarCelulares();
                break;
            case 5:
                System.out.println("Lista de clientes.");
                ListarClientes();
                break;
            case 6:
                System.out.println("Listado de alquileres.");
                ListarAlquileres();
                break;
            case 7:
                System.out.println("Listado de alquileres por cliente");
                System.out.println("Ingresa el numero de documento");
                NumDocumento = RTA.nextInt();
                
                
                break;
            case 8:
                System.out.println("Salir.");
                break;
            default:
                System.out.println("Recuerda que la opcion "+opcion+" no es valida.");
        }
    }

    //LISTAR DATOS
    static void ListarClientes() throws SQLException {
        try (Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/AlquilerCelulares?serverTimezone=UTC",
                "root",
                "123456789"
        )) {
            System.out.println("Conexion exitosa");

            String sql = "SELECT * FROM Clientes";
            PreparedStatement ps = conectar.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int NumDocumento = rs.getInt("NumDocumento");
                String NombreApellido = rs.getString("NombreApellido");
                int NumContacto = rs.getInt("NumContacto");
                String Direccion = rs.getString("Direccion");

                System.out.printf("%d %s %d %s \n", NumDocumento, NombreApellido, NumContacto, Direccion);
            }

            rs.close();
            ps.close();
            conectar.close();
        }

    }

    static void ListarCelulares() throws SQLException {
        try (Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/AlquilerCelulares?serverTimezone=UTC",
                "root",
                "123456789"
        )) {
            System.out.println("Conexion exitosa");

            String sql = "SELECT * FROM Celulares";
            PreparedStatement ps = conectar.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String Marca = rs.getString("Marca");
                String Referencia = rs.getString("Referencia");
                String Ram = rs.getString("Ram");
                String PxCamara = rs.getString("PxCamara");

                System.out.printf("%s %s %s %s \n", Marca, Referencia, Ram, PxCamara);
            }

            rs.close();
            ps.close();
            conectar.close();
        }

    }

    static void ListarAlquileres() throws SQLException {
        try (Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/AlquilerCelulares?serverTimezone=UTC",
                "root",
                "123456789"
        )) {
            System.out.println("Conexion exitosa");

            String sql = "SELECT * FROM Alquileres";
            PreparedStatement ps = conectar.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int NumDocumento = rs.getInt("NumDocumento");
                String Marca = rs.getString("Marca");
                String Referencia = rs.getString("Referencia");
                int DiasAlquilado = rs.getInt("DiasAlquilado");
                String FechaAlquiler = rs.getString("FechaAlquiler");

                System.out.printf("%d %s %s %d %s \n", NumDocumento, Marca, Referencia, DiasAlquilado, FechaAlquiler);
            }

            rs.close();
            ps.close();
            conectar.close();
        }

    }
    
     static void ListarAlquileresC() throws SQLException {
        try (Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/AlquilerCelulares?serverTimezone=UTC",
                "root",
                "123456789"
        )) {
            System.out.println("Conexion exitosa");

            String sql = "SELECT * FROM Alquileres WHERE NumDocumento";
            PreparedStatement ps = conectar.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int NumDocumento = rs.getInt("NumDocumento");
                String Marca = rs.getString("Marca");
                String Referencia = rs.getString("Referencia");
                int DiasAlquilado = rs.getInt("DiasAlquilado");
                String FechaAlquiler = rs.getString("FechaAlquiler");

                System.out.printf("%d %s %s %d %s \n", NumDocumento, Marca, Referencia, DiasAlquilado, FechaAlquiler);
            }

            rs.close();
            ps.close();
            conectar.close();
        }

    }
    
//INSERTAR DATOS

    static void InsertarClientes(int NumDocumento, String NombreApellido, int NumContacto, String Direccion) throws SQLException {
        try (Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/AlquilerCelulares?serverTimezone=UTC",
                "root",
                "123456789"
        )) {
            System.out.println("Conexion exitosa");

            String sql = "INSERT INTO Clientes(NumDocumento,NombreApellido, NumContacto,Direccion)VALUES(?,?,?,?)";
            PreparedStatement ps = conectar.prepareStatement(sql);
            ps.setInt(1, NumDocumento);
            ps.setString(2, NombreApellido);
            ps.setInt(3, NumContacto);
            ps.setString(4, Direccion);
            ps.executeUpdate();

            ps.close();
            conectar.close();
        }

    }

    static void InsertarCelulares(String Marca, String Referencia, String Ram, String PxCamara) throws SQLException {
        try (Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/AlquilerCelulares?serverTimezone=UTC",
                "root",
                "123456789"
        )) {
            System.out.println("Conexion exitosa");

            String sql = "INSERT INTO Celulares(Marca,Referencia, Ram,PxCamara)VALUES(?,?,?,?)";
            PreparedStatement ps = conectar.prepareStatement(sql);
            ps.setString(1, Marca);
            ps.setString(2, Referencia);
            ps.setString(3, Ram);
            ps.setString(4, PxCamara);
            ps.executeUpdate();

            ps.close();
            conectar.close();
        }

    }

    static void InsertarAlquileres(int NumDocumento, String Marca, String Referencia, int DiasAlquilado) throws SQLException {
        try (Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/AlquilerCelulares?serverTimezone=UTC",
                "root",
                "123456789"
        )) {
            System.out.println("Conexion exitosa");

            String sql = "INSERT INTO Alquileres(NumDocumento,Marca, Referencia,DiasAlquilado,FechaAlquiler)VALUES(?,?,?,?,CURRENT_TIME())";
            PreparedStatement ps = conectar.prepareStatement(sql);
            ps.setInt(1, NumDocumento);
            ps.setString(2, Marca);
            ps.setString(3, Referencia);
            ps.setInt(4, DiasAlquilado);
            ps.executeUpdate();

            ps.close();
            conectar.close();
        }

    }

}
