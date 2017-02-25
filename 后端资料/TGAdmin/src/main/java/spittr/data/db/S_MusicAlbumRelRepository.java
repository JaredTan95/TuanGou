package spittr.data.db;

import spittr.data.domain.S_MusicAblumRelationship;

import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public interface S_MusicAlbumRelRepository {
    boolean save(S_MusicAblumRelationship musicAblumRelationship);

    List<S_MusicAblumRelationship> findByAlbumId(String id);

    List<S_MusicAblumRelationship> findBySongId(String id);

    List selectRelaByAlbumId(String id);
}
