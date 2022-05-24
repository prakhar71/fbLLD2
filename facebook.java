package Facebook2;

import java.util.*;

public class facebook {
    Map<Integer,User> userMap;
    Map<Integer,Post> postMap;
    long timestamp;
    /***
    int COUNT=10;
    int PER_PAGE=2;
    */
    int COUNT=10;
    int PER_PAGE=2;

    public facebook(){
        this.timestamp=0;
        this.userMap=new HashMap<>();
        this.postMap=new HashMap<>();
       timestamp = System.currentTimeMillis();
    }
    void createPost(int userId, int postId){
     User user = userMap.get(userId);
     Post post = user.createPost(postId,System.currentTimeMillis());
     postMap.put(postId,post);
    }

    List<Integer>  getNewsFeed(int userId){
      List<Post> post = getTop10Post(userId);
      List<Integer> ans=new Vector<>();
      for(Post p : post)
          ans.add(p.postID);
      return ans;
    }

  void follow(int followerId, int followeeId){
      User user = userMap.get(followerId);
      User friend = userMap.get(followeeId);
      user.following.add(friend);
      friend.followers.add(user);
  }

  void unfollow(int followerId, int followeeId){
      User user = userMap.get(followerId);
      User friend = userMap.get(followeeId);
      user.following.remove(friend);
      friend.followers.remove(user);
  }

   void deletePost(int userId, int postId){
       User user = userMap.get(userId);
        user.deletePost(postId);
       postMap.remove(postId);
   }

   List<Integer> getNewsFeedPaginated(int userId, int pageNumber){
        List<Integer> res = getNewsFeed(userId);
        int st=(pageNumber-1)*PER_PAGE , end=Math.min(st+PER_PAGE,res.size()-1);
        List<Integer> ans=new Vector<>();
        for(int i=st;i<=end;i++)
            ans.add(res.get(i));

        return ans;
   }

   List<Post> getTop10Post(int userId){
        List<Post> ans=new Vector<>();
       User user = userMap.get(userId);
       for(User friend : user.following){
          for(Post p : friend.postList){
              if(p.postID==-1) continue;
                 ans.add(p);
          }

       }
       Collections.sort(ans, new Comparator<Post>() {
           @Override
           public int compare(Post o1, Post o2) {
               return (int)(o2.timestamp-o1.timestamp);
           }
       });
       List<Post> top10=new Vector<>();
       for(int i=0;i<Math.min(COUNT,ans.size());i++)
           top10.add(ans.get(i));

       return top10;

   }
}















