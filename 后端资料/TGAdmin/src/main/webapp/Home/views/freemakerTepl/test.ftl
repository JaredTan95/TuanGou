<!DOCTYPE html>
<html lang="en">
<head></head>
<body>
    <!--Main layout-->
    <div class="container music-detail">
        <div class="row">
            <!--Main column-->
            <div class="col-lg-8 offset-lg-2">
                <!--First row-->
                <div class="row">
                    <div class="col-md-12">
                        <!--Product-->
                        <div class="product-wrapper">
                            <div class="row">
                                <div class="col-md-8">
                                    <!--Featured image-->
                                    <div class="view overlay hm-white-light z-depth-1-half">
                                        <img id="scover" src=""
                                             class="img-fluid " alt="cover image">
                                        <div class="mask">
                                        </div>
                                    </div>
                                    <!--/.Featured image-->
                                </div>
                                <div class="col-md-4">


                                    <div class="list-group">
                                        <a href="#" id="s_title" class="list-group-item active">Woman</a>
                                        <a href="#" class="list-group-item">Man</a>
                                        <a href="#" class="list-group-item">Shoes</a>
                                        <a href="#" class="list-group-item">T-shirt</a>
                                        <a href="#" class="list-group-item">Jewellery</a>
                                    </div>

                                </div>
                            </div>

                            <br>

                            <!--Product data-->
                            <h2 class="h2-responsive">单曲介绍</h2>
                            <p>单曲信息:
                              <a href="${song.getS_songid()}">${song.getS_title()}</a>!
                            <hr>
                            <p id="songdescp"></p>

                            <ul class="rating inline-ul">
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star"></i></li>
                            </ul>

                        </div>
                        <!--Product-->

                    </div>
                </div>
                <!--/.First row-->
                <!--Second row-->
                <div class="row">

                    <!--Heading-->
                    <div class="reviews">
                        <h2 class="h2-responsive">评论</h2>
                    </div>

                    <hr/>
                    <div class="md-form">
                        <textarea type="text" id="music-comment" class="md-textarea"></textarea>
                        <label for="music-comment">在这里输入吧~</label>
                        <div class="md-form form-group">
                            <a href="#!" class="btn btn-primary btn-md">确认</a>
                        </div>
                    </div>

                    <!--First review-->
                    <div class="media">
                        <a class="media-left" href="#!">
                            <img class="rounded-circle" src="http://mdbootstrap.com/img//Photos/Avatars/img%20(13).jpg"
                                 alt="Generic placeholder image">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">John Doe</h4>
                            <ul class="rating inline-ul">
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star"></i></li>
                                <li><i class="fa fa-star"></i></li>
                            </ul>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi cupiditate temporibus iure
                                soluta. Quasi mollitia maxime nemo quam accusamus possimus, voluptatum expedita assumenda.
                                Earum sit id ullam eum vel delectus!</p>
                        </div>
                    </div>

                    <!--Second review-->
                    <div class="media">
                        <a class="media-left" href="#">
                            <img class="rounded-circle" src="http://mdbootstrap.com/img//Photos/Avatars/avatar-6.jpg"
                                 alt="Generic placeholder image">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">Nathan Casie</h4>
                            <ul class="rating inline-ul">
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                            </ul>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi cupiditate temporibus iure
                                soluta. Quasi mollitia maxime nemo quam accusamus possimus, voluptatum expedita assumenda.
                                Earum sit id ullam eum vel delectus!</p>
                        </div>
                    </div>

                    <!--Second review-->
                    <div class="media">
                        <a class="media-left" href="#">
                            <img class="rounded-circle" src="http://mdbootstrap.com/img//Photos/Avatars/avatar-7.jpg"
                                 alt="Generic placeholder image">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">Dave Snow</h4>
                            <ul class="rating inline-ul">
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star amber-text"></i></li>
                                <li><i class="fa fa-star"></i></li>
                            </ul>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi cupiditate temporibus iure
                                soluta. Quasi mollitia maxime nemo quam accusamus possimus, voluptatum expedita assumenda.
                                Earum sit id ullam eum vel delectus!</p>
                        </div>
                    </div>

                </div>
                <!--/.Second row-->
                <!--Pagination-->
                <nav class="row text-xs-center">
                    <ul class="pagination">
                        <li class="page-item disabled">
                            <a class="page-link" href="#!" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item active">
                            <a class="page-link" href="#!">1 <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#!">2</a></li>
                        <li class="page-item"><a class="page-link" href="#!">3</a></li>
                        <li class="page-item"><a class="page-link" href="#!">4</a></li>
                        <li class="page-item"><a class="page-link" href="#!">5</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#!" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!--/.Pagination-->
            </div>
            <!--/.Main column-->
        </div>
    </div>
    <!--/.Main layout-->
<script>
    $(document).ready(function () {
        console.log("传入id:"+$.tjAppJs.getPlayingMusicId());
        $.get("/getMusicDetail",{songid:$.tjAppJs.getPlayingMusicId()},function (data) {
            console.log("得到id信息:"+data);
            $('#songdescp').html(data.s_songdescp);
            $('#scover').attr("src","http://"+data.s_scover);
        });
    });
</script>
</body>
</html>