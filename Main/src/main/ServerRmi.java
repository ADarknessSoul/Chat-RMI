/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.RMISocketFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo
 */
public class ServerRmi {
   
  
    public static void main(String[] args) {

        try {
            
            MiClaseRemota remoteMi = new MiClaseRemota();
            //se registara un puertto 
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("MiInterfazRemota", remoteMi);
                      
            System.out.println("El servidor RMI se encuentra en ejecución");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
