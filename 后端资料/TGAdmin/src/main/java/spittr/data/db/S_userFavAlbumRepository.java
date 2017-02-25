package spittr.data.db;

import spittr.data.domain.S_userFavAlbum;

import java.util.List;

/**
 * Created by tanjian on 2017/1/1.
 */
public interface S_userFavAlbumRepository {
    long count();

    boolean save(S_userFavAlbum userFavAlbum);

    List<S_userFavAlbum> findUserFav(String userid);

    List<S_userFavAlbum> findByAlbumId(String aid);
}
