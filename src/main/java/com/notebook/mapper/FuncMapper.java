package com.notebook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.notebook.domain.User;
@Mapper
@Repository
public interface FuncMapper {
	List<User> getAll();
}
