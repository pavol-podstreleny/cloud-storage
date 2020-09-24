package com.pavolpodstreleny.CloudStorage.mapper;

import java.util.List;

import com.pavolpodstreleny.CloudStorage.entity.File;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE userid = #{userId}")
    List<File> getFiles(int userId);

    @Select("SELECT * FROM FILES WHERE userid = #{userId} AND fileId = #{fileId}")
    File getUserFileById(int userId, int fileId);

    @Select("SELECT * FROM FILES WHERE userid = #{userId} AND filename = #{fileName}")
    File getUserFileByFileName(int userId, String fileName);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) VALUES(#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{data})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(File file);

    @Delete("DELETE FROM FILES WHERE fileId = #{id}")
    int delete(int id);

}
