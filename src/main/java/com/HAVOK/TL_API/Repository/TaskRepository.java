package com.HAVOK.TL_API.Repository;

import com.HAVOK.TL_API.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = "select t from Task t where t.user_id = ?1")
    public List<Task> getTaskByUserId(Integer user_id);
}
