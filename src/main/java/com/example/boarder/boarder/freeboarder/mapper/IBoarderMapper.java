package com.example.boarder.boarder.freeboarder.mapper;


import com.example.boarder.domain.FreeBoarder;
import com.example.boarder.member.dto.BoarderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IBoarderMapper {
    void save(FreeBoarder freeBoarder);

    Optional<FreeBoarder> findByBoarder(String title);

    void updateBoarder(@Param("BoarderDTO") BoarderDTO boarderDTO, @Param("title") String title);

    void deleteBoarder(String title);

    List<FreeBoarder> findAllBoarder();

}
