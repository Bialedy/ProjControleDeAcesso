package com.Senai.mqtt;

import com.Senai.Justificativa.Justificativa;
import com.senai.controller.ControleDeAcessoController;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttSubscriber {
    private static final String BROKER = "tcp://localhost:1883";
    private static final String CLIENT_ID = "ServidorJava";
    private static final String TOPICO = "catraca/rfid";
    private static final Justificativa controller = new Justificativa(11, "Julia", "10/20/2005", "onibus");

    public static void iniciarMqtt() {
        try {
            MqttClient client = new MqttClient(BROKER, CLIENT_ID);
            client.connect();
            client.subscribe(TOPICO, (topic, msg) -> {
                String payload = new String(msg.getPayload());
                System.out.println();
            });
            System.out.println("Inscrito no tópico MQTT: " + TOPICO);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

