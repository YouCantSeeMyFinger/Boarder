package com.example.boarder.boarder.freeboarder.repository;

import com.example.boarder.domain.FreeBoarder;
import com.example.boarder.member.dto.BoarderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface IBoarderRepo {
    public FreeBoarder save(FreeBoarder freeBoarder);

    public Optional<FreeBoarder> findBoarder(Integer boarderNumber);

    public void updateBoarder(@Param("boarderDTO") BoarderDTO boarderDTO, @Param("boarder_number") Integer boarder_number);

    public void deleteBoarder(String title);

    public List<FreeBoarder> findAllBoarder();

    public void updateViewCount(@Param("boarderNumber") Integer boarderNumber);
}
