package main.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptarpass {
    public static void main(String[] args){
     BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
    String password="123";
        System.out.println("Password" + password);
        System.out.println("Pass incriptado: " + encriptar(password));
    
    } 
    public static String encriptar(String password){
    BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
