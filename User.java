package Facebook2;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class User {
    int userID;
    String name;
    List<User> followers;
    List<User> following;
    List<Post> postList;
    public User(int userID,String name){
        this.userID=userID;
        this.name=name;
        followers=new Vector<>();
        following=new Vector<>();
        postList=new Vector<>();
    }

    Post createPost(int postID,long time){
        Post p=new Post(this,postID,time);
        this.postList.add(p);
        return p;
    }

    void deletePost(int pID){
        Iterator<Post> it =postList.iterator();

        while (it.hasNext()){
            Post p = it.next();
            if(p.postID==pID){
                it.remove();
                p.postID=-1;
                break;
            }
        }

    }

}
