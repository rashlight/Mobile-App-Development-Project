package vn.edu.usth.ufood.utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.media.Image;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import vn.edu.usth.ufood.R;

public class StubData {
    public static class User {
        protected String fullName;
        protected String avatarLink;
        protected int points;

        public User(String fullName, String avatarLink) {
            this.fullName = fullName;
            this.avatarLink = avatarLink;
            this.points = 0;
        }

        public User(String fullName, String avatarLink, int points) {
            this.fullName = fullName;
            this.avatarLink = avatarLink;
            this.points = points;
        }

        public String getFirstName() {
            return fullName.split(" ")[0];
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getAvatarLink() {
            return avatarLink;
        }

        public void setAvatarLink(String avatarLink) {
            this.avatarLink = avatarLink;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    public static class Item {
        protected String id;
        protected String name;
        protected Duration prepTime;
        protected String imageLink;
        protected long price;
        protected float rating;
        protected ArrayList<Item> extras;
        protected ArrayList<Comment> comments;



        public Item(String id, String name, Duration prepTime, String imageLink, long price, float rating, ArrayList<Item> extras, ArrayList<Comment> comments) {
            this.id = id;
            this.name = name;
            this.prepTime = prepTime;
            this.imageLink = imageLink;
            this.price = price;
            setRating(rating);
            this.extras = extras;
            this.comments = comments;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Duration getPrepTime() {
            return prepTime;
        }

        public void setPrepTime(Duration prepTime) {
            this.prepTime = prepTime;
        }

        public String getImageLink() {
            return imageLink;
        }

        public void setImageLink(String imageLink) {
            this.imageLink = imageLink;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public float getRating() {
            return rating;
        }

        public void setRating(float rating) {
            if (rating < 0.0 || rating > 5.0) throw new IndexOutOfBoundsException("Invalid rating");
            this.rating = rating;
        }

        public ArrayList<Item> getExtras() {
            return extras;
        }

        public void setExtras(ArrayList<Item> extras) {
            this.extras = extras;
        }

        public ArrayList<Comment> getComments() {
            return comments;
        }

        public void setComments(ArrayList<Comment> comments) {
            this.comments = comments;
        }

    }

    public static class Comment {

        protected User user;
        protected Date postDate;
        protected String content;

        public Comment(User user, Date postDate, String content) {
            this.user = user;
            this.postDate = postDate;
            this.content = content;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Date getPostDate() {
            return postDate;
        }

        public void setPostDate(Date postDate) {
            this.postDate = postDate;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static ArrayList<String> getItemNames(ArrayList<Item> items) {
        ArrayList<String> result = new ArrayList<>();
        for (Item item : items) {
            result.add(item.name);
        }

        return result;
    }

    public static ArrayList<String> getItemImageLinks(ArrayList<Item> items) {
        ArrayList<String> result = new ArrayList<>();
        for (Item item : items) {
            result.add(item.imageLink);
        }

        return result;
    }

    public static ArrayList<String> getItemDurations(ArrayList<Item> items) {
        ArrayList<String> result = new ArrayList<>();

        for (Item item : items) {
            long s = item.prepTime.toSeconds();
            String fmt = String.format(Locale.getDefault(), "%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
            result.add(fmt);
        }

        return result;
    }

    public static ArrayList<String> getItemPrice(ArrayList<Item> items) {
        ArrayList<String> result = new ArrayList<>();
        for (Item item : items) {
            result.add(String.valueOf(item.price));
        }

        return result;
    }

    public static ArrayList<Float> getItemRatings(ArrayList<Item> items) {
        ArrayList<Float> result = new ArrayList<>();
        for (Item item : items) {
            result.add(item.rating);
        }

        return result;
    }

    public static User StubUser = new User(
            "Son Tran Giang",
            "https://usth.edu.vn/wp-content/uploads/2022/07/pic-tran-giang-son-555x740-1-555x740.jpg",
            1337
    );

    public static ArrayList<Item> StubItems = new ArrayList<>(Arrays.asList(
            new Item(
                    "blood_orange_cake",
                    "BLOOD ORANGE CAKE",
                    Duration.ofSeconds(65),
                    "https://images.pexels.com/photos/53468/dessert-orange-food-chocolate-53468.jpeg?h=350&auto=compress&cs=tinysrgb",
                    25000,
                    3,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(
                            new Comment(
                                    new User("Hi","https://picsum.photos/200"),
                                    new Date(2022,1,3),
                                    "The cake is really delicious"
                            ),
                            new Comment(
                                    new User("Roma","https://picsum.photos/200"),
                                    new Date(2022,4,21),
                                    "Good price, mediocre food"
                            )
                        )
                    )
            ),
            new Item(
                    "semiretired_tiramisu",
                    "SEMIRETIRED TIRAMISU",
                    Duration.ofSeconds(137),
                    "https://images.pexels.com/photos/159887/pexels-photo-159887.jpeg?h=350&auto=compress",
                    85000,
                    4,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(
                            new Comment(
                                    new User("Ben","https://picsum.photos/200"),
                                    new Date(2022,10,6),
                                    "Quite expensive, but good taste"
                            ),
                            new Comment(
                                    new User("Simon","https://picsum.photos/200"),
                                    new Date(2022,4,16),
                                    "Avoid taking this!"
                            )
                        )
                    )
            ),
            new Item(
                    "marble_cake",
                    "MARBLE CAKE",
                    Duration.ofSeconds(240),
                    "https://images.pexels.com/photos/136745/pexels-photo-136745.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb",
                    30000,
                    5,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(
                            new Comment(
                                    new User("Jack","https://picsum.photos/200"),
                                    new Date(2022,9,6),
                                    "The best underpriced cake"
                            )
                        )
                    )
            ),
            new Item(
                    "rainbow_cake",
                    "RAINBOW CAKE",
                    Duration.ofSeconds(60),
                    "https://images.pexels.com/photos/39355/dessert-raspberry-leaf-almond-39355.jpeg?h=350&auto=compress&cs=tinysrgb",
                    10000,
                    2.5f,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList())
            ),
            new Item(
                    "rice_pudding",
                    "RICE PUDDING",
                    Duration.ofSeconds(200),
                    "https://images.pexels.com/photos/239578/pexels-photo-239578.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb",
                    40000,
                    5,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(
                            new Comment(
                                    new User("Lily","https://picsum.photos/200"),
                                    new Date(2021,12,12),
                                    "Good price!"
                            ),
                            new Comment(
                                    new User("Dan","https://picsum.photos/200"),
                                    new Date(2022,7,15),
                                    "Can't ask any better price"
                            ),
                            new Comment(
                                    new User("Kevin","https://picsum.photos/200"),
                                    new Date(2022,2,19),
                                    "Too little"
                            )
                        )
                    )
            ),
            new Item(
                    "ice_cream",
                    "ICE CREAM",
                    Duration.ofSeconds(30),
                    "https://images.pexels.com/photos/8382/pexels-photo.jpg?w=1260&h=750&auto=compress&cs=tinysrgb",
                    30000,
                    3.5f,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(
                            new Comment(
                                    new User("Banzai","https://picsum.photos/200"),
                                    new Date(2022,12,1),
                                    "Fair price"
                            )
                        )
                    )
            ),
            new Item(
                    "strawberry_cake",
                    "STRAWBERRY CAKE",
                    Duration.ofSeconds(240),
                    "https://images.pexels.com/photos/51186/pexels-photo-51186.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb",
                    10000000,
                    5,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(
                            new Comment(
                                    new User("Elen","https://picsum.photos/200"),
                                    new Date(2022,9,26),
                                    "Premium price, luxury taste"
                            ),
                            new Comment(
                                    new User("Armstrong","https://picsum.photos/200"),
                                    new Date(2022,8,8),
                                    "Really big but the price seems off"
                            )
                        )
                    )
            ),
            new Item(
                    "cupcake_fruit",
                    "CUPCAKE FRUIT",
                    Duration.ofSeconds(1),
                    "https://images.pexels.com/photos/55809/dessert-strawberry-tart-berry-55809.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb",
                    2500,
                    1,
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList())
                )
            )
        );
}
