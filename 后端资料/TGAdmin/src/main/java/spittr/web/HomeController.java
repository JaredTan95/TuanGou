package spittr.web;

import com.google.inject.Inject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spittr.data.db.JdbcTemplate.*;
import spittr.data.domain.S_albums;
import spittr.data.domain.S_singer;
import spittr.data.domain.S_song;
import spittr.data.domain.S_users;
import spittr.utils.PageQueryParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by tanjian on 16/9/14.
 * 首页控制器
 */
@ComponentScan
@Controller
@RequestMapping(value = "")
public class HomeController {
   /* @Autowired
    private FreeMarkerConfig freeMarkerConfig;//获取FreemarkerConfig的实例*/

    private String urlPrefix="/Home/views/";

    private JdbcOperations jdbcOperations;
    private JdbcS_songRepository jdbcSSongRepository;
    private JdbcS_albumsRepository jdbcSAlbumsRepository;
    private JdbcS_singerRepository jdbcSSingerRepository;
    private JdbcUsersRepository jdbcUsersRepository;

    @Inject
    public HomeController(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
        jdbcSSongRepository=new JdbcS_songRepository(jdbcOperations);
    }

    @RequestMapping(value = "",method = GET)
    public String home(){
        return urlPrefix+"index";
    }

    @RequestMapping(value = "/playlist",method = GET)
    public String playlist(){
        return urlPrefix+"playlist";
    }


   @RequestMapping(value = "/getTopListdata",method = GET)
    public @ResponseBody List getTopListdata(){
       List lists=jdbcSSongRepository.listByVisitedNum();
       return lists;
   }

   @RequestMapping(value = "/getTopAlbumsData",method = GET)
   public @ResponseBody List getTopAlbumsData(){
        return new JdbcS_albumsRepository(jdbcOperations).ListByVis();
   }

   @RequestMapping(value = "/getAlbumDetl",method = POST)
   public @ResponseBody
   Map<String, Object> getAlbumDetl(String id){
       Map<String,Object> maps=new HashMap<>();
       maps.put("albumDetl", new JdbcS_albumsRepository(jdbcOperations).findById(id));
       maps.put("musicLists",new JdbcS_MusicAlbumRelRepository(jdbcOperations).selectRelaByAlbumId(id));
       return maps;
   }

   @RequestMapping(value = "/getMusicDetail",method = GET)
   public @ResponseBody
   S_song getMusicDetail(String songid){
       return new JdbcS_songRepository(jdbcOperations).findBySongId(songid);
   }

   @RequestMapping(value = "/addUpVisiNum",method = POST)
    public @ResponseBody boolean  addUpVisiNum(String songid){
        return jdbcSSongRepository.addVisitedNUm(songid);
   }

  /* @RequestMapping(value = "/ttt",method = GET)
   @ResponseBody
    public ModelAndView ttt(ModelAndView modelAndView) {
        S_song song = new S_song();
        song.setS_songid("2323422");
        song.setS_title("Never Back Down Back");
        modelAndView.setViewName("test");
        modelAndView.addObject("song","song");
        *//*return new ModelAndView("test", "song", song);*//*
        return modelAndView;
    }*/

    @RequestMapping(value = "/albumPagination",method = GET)
    public @ResponseBody
    Map<Object, Object> albumPagination(@RequestParam(value = "pagesize", required = false, defaultValue = "8") int pagesize
            , @RequestParam(value = "pagenum", required = false, defaultValue = "1") int pagenum){
        PageQueryParam param=new PageQueryParam();
        param.setPageSize(pagesize);
        param.setPageNumber(pagenum);
        String SELECT_BY_VIS="SELECT s_aid,s_singerid,s_atitle,s_apubTime,s_adescp,s_avisRec,s_aCoverUrl " +
                "FROM S_albums ORDER BY s_avisRec DESC limit ?,?;";
        String sqlcount = "SELECT COUNT(*) FROM S_albums;";
        int totalCount = jdbcOperations.update(sqlcount);
        int pageCount;
        if (totalCount % param.getPageSize() == 0) {
            pageCount = totalCount / param.getPageSize();
        } else {
            pageCount = totalCount / param.getPageSize() + 1;
        }
        Object[] object = new Object[] {  param.getIndexNum(), param.getPageSize() };

        List<S_albums> lists=jdbcOperations.query(SELECT_BY_VIS, object, (resultSet, i) -> new S_albums(
                resultSet.getString("s_aid")
                ,resultSet.getString("s_singerid")
                ,resultSet.getString("s_atitle")
                ,resultSet.getDate("s_apubTime")
                ,resultSet.getString("s_adescp")
                ,resultSet.getInt("s_avisRec")
                ,resultSet.getString("s_aCoverUrl")
        ));
        Map<Object,Object> maps=new HashedMap();
        maps.put("pageCount",pageCount);
        maps.put("albums",lists);
        return maps;
    }

    @RequestMapping(value = "/search",method = GET)
    @ResponseBody
    public Map<String,List> search(String q){
        jdbcSAlbumsRepository=new JdbcS_albumsRepository(jdbcOperations);
        jdbcSSingerRepository=new JdbcS_singerRepository(jdbcOperations);
        jdbcUsersRepository=new JdbcUsersRepository(jdbcOperations);
        //搜索单曲
        List<S_song> qSongLists=jdbcSSongRepository.findByTitle(q);
        //搜索专辑
        List<S_albums> qAlbumLists=jdbcSAlbumsRepository.findByTitle(q);
        //搜索歌手
        List<S_singer> qSingerLists=jdbcSSingerRepository.findByName(q);
        //搜索用户
        List<S_users> qUserLists=jdbcUsersRepository.findByNickName(q);
        Map<String,List> maps=new HashMap<>();
        maps.put("songLists",qSongLists);
        maps.put("albumLists",qAlbumLists);
        maps.put("singerLists",qSingerLists);
        maps.put("userLists",qUserLists);
        return maps;
    }
}
