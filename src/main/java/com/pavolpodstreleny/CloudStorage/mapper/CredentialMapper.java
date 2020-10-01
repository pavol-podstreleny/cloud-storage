package com.pavolpodstreleny.CloudStorage.mapper;

import java.util.List;

import com.pavolpodstreleny.CloudStorage.entity.Credential;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CredentialMapper {
    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
    List<Credential> getCredentials(int userId);

    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId} AND credentialid = #{credentialId}")
    Credential getCredential(int userId, int credentialId);

    @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) VALUES(#{url}, #{userName}, #{key}, #{passwordEncrypted}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Credential credential);

    @Update("UPDATE CREDENTIALS SET url = #{url}, username = #{userName}, password = #{passwordEncrypted} WHERE credentialid = #{id}")
    int update(Credential credential);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    int delete(int credentialId);
}