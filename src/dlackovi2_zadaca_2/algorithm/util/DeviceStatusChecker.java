/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.algorithm.util;

import dlackovi2_zadaca_2.Dlackovi2_zadaca_2;
import static dlackovi2_zadaca_2.Dlackovi2_zadaca_2.actuators;
import static dlackovi2_zadaca_2.Dlackovi2_zadaca_2.sensors;
import dlackovi2_zadaca_2.model.Actuator;
import dlackovi2_zadaca_2.model.Device;
import dlackovi2_zadaca_2.model.Sensor;
import dlackovi2_zadaca_2.rng.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author d.horvat
 */
public class DeviceStatusChecker {
    public static List<Device> checkStatus(List<Device> devices)
    {
        List<Device> devicesToRemove = new ArrayList<>();
        List<Device> devicesToAdd = new ArrayList<>();
        for (Device device : devices) {
                if(!device.checkStatus())
                {
                    if(device instanceof Actuator)
                    {
                        Actuator actuator = (Actuator) device;
                        System.out.print("Provjera aktuatora: " + actuator.getId() + " " + actuator.getName());
                    } else 
                    {
                        Sensor sensor = (Sensor) device;
                        System.out.print("Provjera senzora: " + sensor.getId() + " " + sensor.getName());
                    }
                    System.out.println(" | Broj pogresaka: " + device.getNumFails());
                    if(device.getNumFails() >= 3)
                    {
                        device.setNumFails(0);
                        if(device instanceof Sensor)
                        {
                            Sensor newSensor = null;
                            RandomNumberGenerator rng = RandomNumberGenerator.getInstance(700);
                            while(newSensor == null || newSensor.getType() != ((Sensor)device).getType())
                                newSensor = sensors.get(rng.dajSlucajniBroj(0, sensors.size() - 1));
                            
                            devicesToRemove.add(device);
                            devicesToAdd.add(newSensor);
                            System.out.println("= TACTICAL ALERT = Zamjena: " + ((Sensor) device).getName() + " | " + newSensor.getName());
                        }
                        if(device instanceof Actuator)
                        {
                            Actuator newActuator = null;
                            RandomNumberGenerator rng = RandomNumberGenerator.getInstance(700);
                            while(newActuator == null || newActuator.getType() != ((Actuator)device).getType())
                                newActuator = actuators.get(rng.dajSlucajniBroj(0, actuators.size() - 1));
                            
                            devicesToRemove.add(device);
                            devicesToAdd.add(newActuator);
                            System.out.println("= TACTICAL ALERT = Zamjena: " + ((Actuator) device).getName() + " | " + newActuator.getName());
                        }
                    }
                } else 
                {
                    if(device instanceof Actuator)
                    {
                        Actuator actuator = (Actuator) device;
                        System.out.print("Provjera aktuatora: " + actuator.getId() + " " + actuator.getName());
                    } else 
                    {
                        Sensor sensor = (Sensor) device;
                        System.out.print("Provjera senzora: " + sensor.getId() + " " + sensor.getName());
                    }
                    System.out.println(" | Ispravan uređaj.");
                }
            }
        devices.removeAll(devicesToRemove);
        devices.addAll(devicesToAdd);
        return devices;
    }
}
