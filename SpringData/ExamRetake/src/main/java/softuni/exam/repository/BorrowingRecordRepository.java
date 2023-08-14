package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Genre;
import softuni.exam.models.entity.BorrowingRecords;

import java.util.List;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecords, Long> {


    List<BorrowingRecords> findAllByBook_GenreOrderByBorrowDateDesc(Genre genre);
}
