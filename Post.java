package Facebook2;

import java.util.List;
import java.util.Vector;

public class Post {
    int postID;
    User postedBy;
    long timestamp;
    List<Like> likesList;
    List<Comment> commentList;
    String contents;
    public Post(User user,int postID,long time){
        this.postedBy=user;this.postID=postID;this.timestamp=time;
        likesList=new Vector<>();
        commentList=new Vector<>();

    }
}
