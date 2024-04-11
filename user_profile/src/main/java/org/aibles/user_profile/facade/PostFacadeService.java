package org.aibles.user_profile.facade;

import java.util.List;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.PostResponse;

public interface PostFacadeService {

  PostResponse create(String userProfileId, PostCreateRequest request);
  PostResponse getById(String userProfileId, String id);
  List<PostResponse> getAll(String userProfileId);
  PostResponse updateById(String id, String userProfileId, PostUpdateRequest request);
  void deleteById(String userProfileId, String id);
  void deleteAllByUserProfileId(String userProfileId);
}