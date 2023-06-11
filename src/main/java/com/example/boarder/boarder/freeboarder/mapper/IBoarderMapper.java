package com.example.boarder.boarder.freeboarder.mapper;


import com.example.boarder.boarder.freeboarder.dto.BoarderSearchDTO;
import com.example.boarder.domain.FreeBoarder;
import com.example.boarder.member.dto.BoarderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;


@Mapper
public interface IBoarderMapper {
    void save(FreeBoarder freeBoarder);

    Optional<FreeBoarder> findByBoarder(Integer boarderNumber);

    void updateBoarder(@Param("boarderDTO") BoarderDTO boarderDTO, @Param("boarder_number") Integer boarder_number);

    void deleteBoarder(String title);

    // 이 메소드로 찾기 구현
    List<FreeBoarder> findAllBoarder(@Param("searchBoarder") BoarderSearchDTO boarderSearchDTO);

    void updateViewCount(Integer boarderNumber);
}
