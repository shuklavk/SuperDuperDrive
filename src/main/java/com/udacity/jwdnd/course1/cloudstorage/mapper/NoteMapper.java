package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.models.Note;

@Mapper
public interface NoteMapper {
	
	@Select("SELECT * FROM NOTES WHERE userid = #{userid}")
	public List<Note> getNotes(Integer userid);
	
//	@Select("SELECT TOP 1 noteid FROM NOTES WHERE noteid = #{noteid}")
//	public Note noteExists(Integer noteid);
	
	@Update("UPDATE NOTES SET notetitle=#{notetitle}, notedescription=#{notedescription} WHERE noteid=#{nodeid}")
	public int updateNote(Note note);
	
	@Insert("INSERT INTO NOTES(notetitle, notedescription, userid) VALUES(#{notetitle}, #{notedescription}, #{userid})")
	@Options(useGeneratedKeys=true, keyProperty="nodeid")
	public int insertNote(Note note);
	
	@Delete("DELETE FROM NOTES WHERE noteid=#{noteid}")
	public void deleteNote(Integer noteid);

}
