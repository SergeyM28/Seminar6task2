package ru.mikhailov.seminar6task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mikhailov.seminar6task2.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
