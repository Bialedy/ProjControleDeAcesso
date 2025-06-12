package com.Senai.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtil {
    public  static String hash (String texto) { // recebe uma string chamada texto, e retorna uma string representando a hash gerada
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); // a entrada será processada  para gerar uma hash de 256 bits
            byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8)); // getBytes(StandardCharsets.UTF_8 converte a String de entrada (texto) para um array de bytes
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        }catch (NoSuchAlgorithmException e) {
            throw  new RuntimeException("Erro ao criptografar a senha", e);
        }
        }
    }

