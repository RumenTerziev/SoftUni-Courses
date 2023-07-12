package bg.softuni.hospital.utils;

import bg.softuni.hospital.entities.Diagnose;
import bg.softuni.hospital.entities.Medicament;
import bg.softuni.hospital.entities.Patient;
import bg.softuni.hospital.entities.Visitation;

import java.util.HashMap;
import java.util.Map;

public class InvokationManager {

    public static Map<String, Class<?>> getEntityMap() {

        Map<String, Class<?>> resultMap = new HashMap<>();
        resultMap.put("Patient", Patient.class);
        resultMap.put("Visitation", Visitation.class);
        resultMap.put("Diagnose", Diagnose.class);
        resultMap.put("Medicament", Medicament.class);

        return resultMap;
    }

}
