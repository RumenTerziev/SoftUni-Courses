package bg.softuni.hospital;

import bg.softuni.hospital.entities.Diagnose;
import bg.softuni.hospital.entities.Medicament;
import bg.softuni.hospital.entities.Patient;
import bg.softuni.hospital.entities.Visitation;
import bg.softuni.hospital.repositories.Repository;
import bg.softuni.hospital.repositories.RepositoryImpl;

import java.time.LocalDate;
import java.util.Set;

public class Main {

    private static final Repository<Patient> PATIENT_REPOSITORY = new RepositoryImpl<>();
    private static final Repository<Medicament> MEDICAMENT_REPOSITORY = new RepositoryImpl<>();
    private static final Repository<Visitation> VISITATION_REPOSITORY = new RepositoryImpl<>();
    private static final Repository<Diagnose> DIAGNOSE_REPOSITORY = new RepositoryImpl<>();


    public static void main(String[] args) {

        Patient patient = new Patient();
        patient.setFirstName("Gosho");
        patient.setHasInsurance(true);
        patient.setDateOfBirth(LocalDate.of(1995, 12, 12));

        Visitation visitation = new Visitation();
        visitation.setDate(LocalDate.of(2022, 11, 11));
        visitation.setPatient(patient);


        Diagnose diagnose = new Diagnose();
        diagnose.setName("Weak diagnose");
        diagnose.setPatients(Set.of(patient));

        Medicament medicament = new Medicament();
        medicament.setName("Vitamin C");
        medicament.setPatients(Set.of(patient));



        PATIENT_REPOSITORY.save(patient);
        MEDICAMENT_REPOSITORY.save(medicament);
        DIAGNOSE_REPOSITORY.save(diagnose);
        VISITATION_REPOSITORY.save(visitation);

        patient.setVisitations(Set.of(visitation));
        patient.setDiagnoses(Set.of(diagnose));
        patient.setMedicaments(Set.of(medicament));

        PATIENT_REPOSITORY.save(patient);

        MEDICAMENT_REPOSITORY.closeConnection();
        DIAGNOSE_REPOSITORY.closeConnection();
        VISITATION_REPOSITORY.closeConnection();
        PATIENT_REPOSITORY.closeConnection();

    }
}
