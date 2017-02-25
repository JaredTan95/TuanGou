/**
 * Created by tanjian on 16/10/13.
 * js
 */

$(document).ready(function () {
    $.tjAppJs.loadHtml2div("/Home/views/load.html");
    $('.nav-item').bind('click', function () {
        $(this).addClass('active').siblings().removeClass('active');
    });
  /*  function search() {
        $.get("/search?q="+$('#search').val(),function(data){
            console.log(data);
            alert(data);
        });
    }*/
    (function ($) {
        /*开启animations*/
        new WOW().init();

        var iframe = $("#iframeContent");
        var mymusicId = $("#mymusic");
        var homePage = $('#homePage');

        var navbarBtnfunc = {
            mymusic: function () {
                $.get("/login/personal", function (data) {
                    $.tjAppJs.loadHtml2div(data);
                });
            }
        };

        var detailsBtn = $(".detailsBtn");
        var evetfunc = {
            moreInfo: function () {
                $.tjAppJs.loadHtml2div("/Home/views/albumDetails.html");
            }
        };
        homePage.bind('click', function () {
            $.tjAppJs.loadHtml2div("/Home/views/load.html");
        });
        mymusicId.on("click", function () {
            navbarBtnfunc.mymusic();
        });
        detailsBtn.on("click", function () {
            /* evetfunc.moreInfo();*/
        });
        $('div').on('click', '.jp-playlist-current', function () {
            $.tjAppJs.updatePlayingMusicId($.SpittrJqplayer.getCurPlayId());
            $.tjAppJs.loadHtml2div("/Home/views/musicDetail.html");
          /*  var html="";
            $.get("/ttt",function (data) {
                html=data;
            });
           $.tjAppJs.loadHtml2div(html);*/
        });
    })(jQuery);

    (function ($) {
        /* btnGroupFa.on('click',function(){
         var songid=$('.audioPlayer').attr("data-currtPlaying");
         console.log("收藏音乐id:"+songid);
         $.post("/login/addToFav",{songId: songid},function(data){
         if(data=="noUser"){
         $.get("/login/personal",function (data) {
         $.tjAppJs.loadHtml2div(data);
         });
         }else if(data=="true"){
         btnGroupFa.addClass("fa-star");
         btnGroupFa.removeClass("fa-star-o");
         }else {
         btnGroupFa.addClass("fa-star-o");
         btnGroupFa.removeClass("fa-star");
         }
         });
         });*/
        $('.icon-previous,.icon-next').on('click', function () {
            $('.jp-playlist ul').find("li").each(function () {
                if ($(this).hasClass('jp-playlist-current')) {
                    $(this).show();
                    $(this).siblings().hide();
                }
            });
        });
        $('.jp-pause').on('click',function () {
            /* 暂停播放，将文档标题恢复至"Spittr-Production Music" */
            $(document).attr('title',"Spittr-Production Music");
        });
    })(jQuery);
});


var searchResultsLists="";
/*通过添加命名空间来添加全局函数*/
/*加载html至id为'bodyContent'的div中*/
var bodyContent = $('#bodyContent');
jQuery.tjAppJs = {
    loadHtml2div: function (pathUrl) {
        bodyContent.innerHTML = "";
        bodyContent.load(pathUrl);
    },
    updateAlbumId: function (id) {
        bodyContent.attr("data-albumId", id);
    },
    getAlbumId: function () {
        return bodyContent.attr("data-albumId");
    },
    updatePlayingMusicId:function(id){
        bodyContent.attr("data-playingId",id);
    },
    updateSearchQ:function () {
        bodyContent.attr("data-q", $('#search').val());
    },
    getSearchQ:function () {
        return bodyContent.attr("data-q");
    },
    getPlayingMusicId:function () {
      return bodyContent.attr("data-playingId");
    },
    checkIsFav: function (id) {
        /*当用户点击播放列表中的音乐时，会检测当前登录是我用户是否已经收藏过该音乐，并改变相应图标以示已关注*/
        /* var btnGroupFa=$('.addtoFav',parent.document);*/
        $.post("/login/isAdded2Fav", {songid: id}, function (data) {
            if (data) {
                /*   btnGroupFa.addClass("fa-star");
                 btnGroupFa.removeClass("fa-star-o");*/
            } else {
                /*  btnGroupFa.addClass("fa-star-o");
                 btnGroupFa.removeClass("fa-star");*/
            }
        });
    },
    search:function () {
       /* $.get("/search?q="+$('#search').val(),function(data){
            searchResultsLists=data;
            console.log(data);
        });*/
        $.tjAppJs.updateSearchQ();
        $.tjAppJs.loadHtml2div("/Home/views/searchResults.html");
        return false;
    }
};


/*音频播放器*/
var playlist = [];

var cssSelector = {
    jPlayer: "#jquery_jplayer",
    cssSelectorAncestor: ".audioPlayer"
};

var options = {
    remainingDuration: true,
    smoothPlayBar: true,
    swfPath: "http://cdnjs.cloudflare.com/ajax/libs/jplayer/2.6.4/jquery.jplayer/Jplayer.swf",
    supplied: "ogv, m4v, oga, mp3"
};
var myPlaylist = new jPlayerPlaylist(cssSelector, playlist, options);
/*音频播放器 end*/

jQuery.SpittrJqplayer = {
    getPlaylist: function () {
        return myPlaylist;
    },
    itemPlay: function (data) {
        $('.musicInfo .jp-playlist ul').find("li").hide();
        console.log(data);
        $(this).siblings().attr('display', "none");
        this.getPlaylist().add(data);
        this.getPlaylist().play(-1);
        $(document).attr('title',"▶ 正在播放:"+$.SpittrJqplayer.getCurPlayTitle());
    },
    getCurPlayId: function () {
        var current = myPlaylist.current;
        playlist = myPlaylist.playlist;
        var curId="";
        jQuery.each(playlist, function (index, obj) {
            if (index == current) {
                curId=obj.id;
            } // if condition end
        });
        if(curId!=""){
            return curId;//返回当前播放器正在播放的单曲id}
        }else {
            console.log("curid==null");
        }
    },
    getCurPlayTitle:function () {
        var current = myPlaylist.current;
        playlist = myPlaylist.playlist;
        var curTitle="";
        jQuery.each(playlist, function (index, obj) {
            if (index == current) {
                curTitle=obj.title;
            } // if condition end
        });
        if(curTitle!=""){
            return curTitle;//返回当前播放器正在播放的单曲 标题}
        }else {
            console.log("curTitle==null");
        }
    }
};






