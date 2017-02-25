package spittr.data.db;

import spittr.data.domain.S_userFavSong;

import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public interface S_userFavSongRepository {

    long count();

    boolean save(S_userFavSong sUserFavSong);

    List<S_userFavSong> findUsersFav(String userid);

    List<S_userFavSong> findBySongId(String s_songid);

    boolean isExsits(S_userFavSong sUserFavSong);
}
