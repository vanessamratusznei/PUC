#Atividade Somativa 02 IOT PUCPR
#realizado em 22/09/2023
#Turma: 11100010552_20232_01.
#Integrante: Vanessa Milani Ratusznei

import dht
import urequests
import machine
import time
from machine import Pin

d = dht.DHT11(machine.Pin(27))
rele = Pin(23, Pin.OUT)

# Função responsável pelo wifi
def conecta(ssid, senha):
    import network
    station = network.WLAN(network.STA_IF)
    station.active(True)
    station.connect(ssid, senha)
    for t in range(50):
        if station.isconnected():
            break
        time.sleep(0.1)
    return station

print("Conectando...")

# Parâmetros para conectar o wifi
station = conecta("VLADEMIRO", "32969708")
time.sleep(5)

if not station.isconnected():
    print("Não conectado")
else:
    print("Conectado")

while True:
    d.measure()
    umid = d.humidity()
    temp = d.temperature()
    response=urequests.get("https://api.thingspeak.com/update?api_key=VZ79FW2R7FYUXAPB&field1={}&&field2={}".format(temp, umid))
    response.close()
    print("Temp= {}    Umidade= {}".format(temp, umid))
    time.sleep(10)
    if temp > 31 or umid > 70:
        rele.value(1)
    else:
        rele.value(0)
