package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookBaseInformationImportDto {

    @XmlElement(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }
}
