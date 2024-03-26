package user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import user.bean.UserImageDTO;

@Mapper
public interface UserUploadDAO {

	public void upload(List<UserImageDTO> userImageList);

	public List<UserImageDTO> getUploadList();

}
