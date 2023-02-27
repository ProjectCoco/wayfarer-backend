package com.wayfarer.community.repository;

import com.wayfarer.community.entity.ReplyComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityReplyCommentRepository extends JpaRepository<ReplyComment, Long> {
}
