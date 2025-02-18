package com.gachonsw.blooddonation.repository;

import com.gachonsw.blooddonation.entity.Association;
import com.gachonsw.blooddonation.entity.Post;
import com.gachonsw.blooddonation.entity.PostAssociation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostAssociationRepository extends JpaRepository<PostAssociation, Long> {

    void deleteAllByPost(Post post);
    List<PostAssociation> findWithPostByAssociation(Association association);

    @EntityGraph(attributePaths = "post")
    Slice<PostAssociation> findSliceWithPostByAssociation(Association association, Pageable pageable);

    void deleteByPostAndAssociation(Post post, Association association);
}
