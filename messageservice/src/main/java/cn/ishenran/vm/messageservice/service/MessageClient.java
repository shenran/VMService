package cn.ishenran.vm.messageservice.service;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MessageClient {
    final String broker ="tcp://mqtt.ishenran.cn:1883";
    /**
     /**
     * 发消息使用的一级 Topic，需要先在 MQ 控制台里创建
     */
    final String topic ="ishenran";


    /**
     * MQTT 的 ClientID，一般由两部分组成，GroupID@@@DeviceID
     * 其中 GroupID 在 MQ 控制台里创建
     * DeviceID 由应用方设置，可能是设备编号等，需要唯一，否则服务端拒绝重复的 ClientID 连接
     */
    String clientId ="";
    //String DeviceID
    MqttClient sampleClient=null;


    public MessageClient(String DeviceID, final MessageDelegate messageDelegate) {
        MemoryPersistence persistence = new MemoryPersistence();
        clientId=DeviceID;
        try {
            sampleClient = new org.eclipse.paho.client.mqttv3.MqttClient(broker, clientId, persistence);
            final MqttConnectOptions connOpts = new MqttConnectOptions();
            System.out.println("Connecting to broker: " + broker);
            /**
             * 计算签名，将签名作为 MQTT 的 password。
             * 签名的计算方法，参考工具类 MacSignature，第一个参数是 ClientID 的前半部分，即 GroupID
             * 第二个参数阿里云的 SecretKey
             */
            //sign = MacSignature.macSignature(clientId.split("@@@")[0], secretKey);
            //connOpts.setUserName(acessKey);
            connOpts.setServerURIs(new String[]{broker});
            //connOpts.setPassword(sign.toCharArray());
            connOpts.setCleanSession(true);
            connOpts.setKeepAliveInterval(90);
            connOpts.setAutomaticReconnect(true);
            sampleClient.setCallback(new MqttCallbackExtended() {
                public void connectComplete(boolean reconnect, String serverURI) {
                    System.out.println("connect success");
                    //连接成功，需要上传客户端所有的订阅关系
                    try {
                        sampleClient.subscribe(topic+"/vm/"+clientId);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }

                public void connectionLost(Throwable throwable) {
                    System.out.println("mqtt connection lost");
                    try {
                        sampleClient.unsubscribe(topic+"/vm/"+clientId);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }

                }

                public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                    System.out.println("messageArrived:" + topic + "------" + new String(mqttMessage.getPayload()));
                    messageDelegate.messageArrived(new String(mqttMessage.getPayload()));
                }

                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    System.out.println("deliveryComplete:" + iMqttDeliveryToken.getMessageId());
                }
            });
            sampleClient.connect(connOpts);
        } catch (MqttSecurityException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    }
