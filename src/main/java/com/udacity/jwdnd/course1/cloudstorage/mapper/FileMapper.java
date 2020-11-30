package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.models.File;

@Mapper
public interface FileMapper {
	
	@Select("SELECT * FROM FILES WHERE userid = #{userid}")
	public List<File> getAllFiles(int userid);
	
	@Select("SELECT * FROM FILES WHERE fileid = #{fileid}")
	public File getFile(int fileid);
	
	@Insert("INSERT INTO FILES(contentType, filename, filesize, userid, filedata) VALUES(#{contentType}, #{filename}, #{filesize}, #{userid}, #{filedata})")
	@Options(useGeneratedKeys=true, keyProperty="fileid")
	public int insertFile(File file);
	
	@Delete("DELETE FROM FILES WHERE fileid = #{fileid}")
	public void deleteFile(int fileid);

}
