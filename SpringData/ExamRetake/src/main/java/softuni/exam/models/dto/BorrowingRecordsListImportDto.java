package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "borrowing_records")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordsListImportDto {

    @XmlElement(name = "borrowing_record")
    private List<BorrowingRecordsImportDto> borrowingRecords;

    public List<BorrowingRecordsImportDto> getBorrowingRecords() {
        return borrowingRecords;
    }
}
