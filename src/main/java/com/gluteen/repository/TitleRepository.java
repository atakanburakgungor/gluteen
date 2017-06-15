package com.gluteen.repository;

import com.gluteen.domain.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by yusufaslan on 31.05.2017.
 */
public interface TitleRepository extends JpaRepository<Title,Long> {


    Title findById(Long id);

    @Modifying
    @Query("select m from Title m order by m.titleCreated ")
    List<Title> findAllByOrOrderByTitleCreated();

    Title deleteTitleById(Long id);

    @Modifying
    @Query("update Title m set m.titleBody =:titleBody where m.id =:id ")
    Title updateTitle(@PathParam("id") Long id, @PathParam("titleBody") String titleBody);

}
