package spittr.data.db;

import spittr.data.domain.S_MusicCategory;

import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public interface S_MusicCategoryRepository {
    boolean Save(S_MusicCategory sMusicCategory);

    List<S_MusicCategory> findBySongId(String songId);

    List<S_MusicCategory> findSongsByCatId(String typeId);
}
