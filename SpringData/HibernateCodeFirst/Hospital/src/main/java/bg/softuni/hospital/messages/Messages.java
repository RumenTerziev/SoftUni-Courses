package bg.softuni.hospital.messages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messages {
    public static final String INITIAL_MESSAGE = "Please enter type of data that You would like to work with! - " +
            "Patient, Diagnose, Visitations, Medicament!  Or enter \"End\" to Exit!";

    public static final String ENTER_FIRST_NAME = "Please enter patient's first name! This field must be filled";

    public static final String ENTER_LAST_NAME = "Please enter patient's last_name! or Skip to continue";

    public static final String ENTER_EMAIL = "Please enter patient's email! or Skip to continue";

    public static final String ENTER_DATE_OF_BIRTH = "Please enter patient's date of birth in format YYYY-MM-DD ! This field must be filled";

    public static final String ENTER_INSURANCE_STATUS = "Please enter if patient has insurance! - true or false ! This field must be filled";

    public static final String ENTER_DIAGNOSE = "Please enter patient's diagnose or Skip to continue!";

    public static final String ENTER_MEDICAMENT = "Please enter medicament for patient or Skip to continue!";


    public static Map<String, List<String>> getMessagesMap() {

        Map<String, List<String>> messagesMap = new HashMap<>();
        messagesMap.put("Patient", List.of(
                ENTER_FIRST_NAME, ENTER_LAST_NAME, ENTER_EMAIL, ENTER_DATE_OF_BIRTH,
                ENTER_INSURANCE_STATUS, ENTER_DIAGNOSE, ENTER_MEDICAMENT));


        return messagesMap;
    }

}
