package Facebook2;

public class App {
    public static void main(String[] args) {
        facebook fb=new facebook();
        User u1 = new User(1,"ram");
        User u2 = new User(2,"shyam");
        User u3 = new User(3,"harry");
        User u4 = new User(4,"lee");
        fb.userMap.put(1,u1);
        fb.userMap.put(2,u2);
        fb.userMap.put(3,u3);
        fb.userMap.put(4,u4);

        fb.follow(2,3);
        fb.follow(3,4);
        fb.follow(4,1);
        fb.follow(4,2);

//        for(User u:u4.followers)
//            System.out.println(u.userID);

        fb.createPost(3,1);
        fb.createPost(3,2);
        fb.createPost(3,3);
        fb.createPost(3,4);



        fb.createPost(4,5);
        fb.createPost(4,6);
        fb.createPost(4,7);

        fb.createPost(1,8);
        fb.createPost(2,9);
        fb.createPost(2,10);


//        System.out.println(fb.getNewsFeed(3));
//        fb.getNewsFeed(4);

//        fb.deletePost(3,2);
//        fb.deletePost(4,7);
//
//        for(Post p:u4.postList)
//            System.out.println(p.postID);


        System.out.println(fb.getNewsFeed(3));
//        System.out.println(fb.getNewsFeed(2));
//
        System.out.println(fb.getNewsFeedPaginated(3,2));


    }
}
