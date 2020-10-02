package com.pavolpodstreleny.CloudStorage.mapper;

import com.pavolpodstreleny.CloudStorage.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    List<Note> getNotes(int userId);

    @Select("SELECT * FROM NOTES WHERE userid = #{userId} AND noteid = #{noteId}")
    Note getNote(int userId, int noteId);

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES(#{title}, #{description}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Note note);

    @Update("UPDATE NOTES SET notetitle = #{title}, notedescription = #{description} WHERE noteid = #{id}")
    int update(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    int delete(int noteId);

}
